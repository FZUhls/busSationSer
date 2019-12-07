package com.example.lessonthree.controller;


import com.example.lessonthree.jpa.AdminJPA;
import com.example.lessonthree.jpa.BusJPA;
import com.example.lessonthree.jpa.BusNumberJPA;
import com.example.lessonthree.model.Administrator;
import com.example.lessonthree.model.Bus;
import com.example.lessonthree.model.BusNumber;
import com.example.lessonthree.model.Result;
import com.example.lessonthree.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/bus")
public class BusController {
    @Autowired
    AdminJPA adminJPA;
    @Autowired
    BusNumberJPA busNumberJPA;
    @Autowired
    BusJPA busJPA;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result Login(Administrator entity){
       Result result;
       Administrator administrator = adminJPA.findByUsername(entity.getUsername());
       if(administrator!= null){
           System.out.println(administrator.getId());
           System.out.println(administrator.getUsername());
           System.out.println(administrator.getPasswd());
           if (entity.getPasswd().equals(administrator.getPasswd())){
               result = ResultUtil.success();
               result.setMsg("登录成功");
               return result;
           }else {
               result = ResultUtil.error(1,"密码错误");
               return result;
           }
       }else {
           result = ResultUtil.error(1,"用户名不存在");
           return result;
       }
    }
    //寻找车次
    @RequestMapping(value = "/findbusnum",method = RequestMethod.GET)
    public Result<List<BusNumber>> findBusNum(Long num){
        if (num == null){
            List<BusNumber> findList = busNumberJPA.findAll();
            Result<List<BusNumber>> result = ResultUtil.success(findList);
            return result;
        }else {
            BusNumber find = busNumberJPA.findBusNumberByBusNum(num);
            if (find!=null){
                return ResultUtil.success(find);
            }else {
                return ResultUtil.error(2,"Nofind");
            }
        }
    }
    //增加车次
    @RequestMapping(value = "/addbusnum",method = RequestMethod.GET)
    public Result addBusNum(BusNumber entity){

        if (busNumberJPA.findBusNumberByBusNum(entity.getBusNum())!=null){
            return ResultUtil.error(3,"exist already");
        }
        BusNumber isDo = busNumberJPA.save(entity);
        if(isDo!=null){
            return ResultUtil.success(isDo);
        }else {
            return ResultUtil.error(2,"add error");
        }
    }
    //删除车次
    @RequestMapping(value = "/deletebusnum",method = RequestMethod.GET)
    public Result deleteBusNum(Long num){
        BusNumber busNumber = busNumberJPA.findBusNumberByBusNum(num);
        if (busNumber!=null){
            busNumberJPA.deleteById(busNumber.getId());
            return ResultUtil.success();
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }
    //增加车辆
    @RequestMapping(value = "/busadd",method = RequestMethod.GET)
    public Result busAdd(Bus entity){
        if (busJPA.findBusByLicencePlate(entity.getLicencePlate())!=null){
            return ResultUtil.error(3,"exist already");
        }
        Bus isDo = busJPA.save(entity);
        if(isDo!=null){
            return ResultUtil.success(isDo);
        }else {
            return ResultUtil.error(2,"add error");
        }
    }
    //查询车辆
    @RequestMapping(value = "/findbus",method = RequestMethod.GET)
    public Result<List<Bus>> findbus(String licencePlate){
        if (licencePlate == null){
            return ResultUtil.success(busJPA.findAll());
        }
        if(licencePlate.equals("")){
            return ResultUtil.success(busJPA.findAll());
        }else {
            Bus bus = busJPA.findBusByLicencePlate(licencePlate);
            if(bus!=null){
                return ResultUtil.success(bus);
            }else {
                return ResultUtil.error(2,"Nofind");
            }
        }
    }
    //删除车辆
    @RequestMapping(value = "/deletebus",method = RequestMethod.GET)
    public Result deletebus(String licencePlate){
        Bus bus = busJPA.findBusByLicencePlate(licencePlate);
        if(bus!=null){
            busJPA.delete(bus);
            return ResultUtil.success();
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }



}
