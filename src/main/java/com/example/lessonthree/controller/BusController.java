package com.example.lessonthree.controller;


import com.example.lessonthree.jpa.*;
import com.example.lessonthree.model.*;
import com.example.lessonthree.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.Null;
import java.sql.Date;
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
    @Autowired
    ConductorJPA conductorJPA;
    @Autowired
    DriverJPA driverJPA;
    @Autowired
    TicketJPA ticketJPA;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result Login(Administrator entity) {
        Result result;
        Administrator administrator = adminJPA.findByUsername(entity.getUsername());
        if (administrator != null) {
            System.out.println(administrator.getId());
            System.out.println(administrator.getUsername());
            System.out.println(administrator.getPasswd());
            if (entity.getPasswd().equals(administrator.getPasswd())) {
                result = ResultUtil.success();
                result.setMsg("登录成功");
                return result;
            } else {
                result = ResultUtil.error(1, "密码错误");
                return result;
            }
        } else {
            result = ResultUtil.error(1, "用户名不存在");
            return result;
        }
    }

    //修改车次
    @RequestMapping(value = "updatebusnum", method = RequestMethod.GET)
    public Result updateBusNum(Long busNum, String destination, String licencePlate
            , Long ticketCost, String depTime, String date, String arrTime, String platform) {
        BusNumber busNumber;
        if (busNum == null) {
            return ResultUtil.error(3, "wrong parameter!");
        } else {
            busNumber = busNumberJPA.findBusNumberByBusNum(busNum);
            if (busNumber == null) {
                return ResultUtil.error(2, "Nofind");
            } else {
                if (destination != null && !destination.equals("")) {
                    busNumber.setDestination(destination);
                }
                if (licencePlate != null && !licencePlate.equals("")) {
                    busNumber.setLicencePlate(licencePlate);
                }
                if (ticketCost != null) {
                    busNumber.setTicketCost(ticketCost);
                }
                if (depTime != null && !depTime.equals("")) {
                    busNumber.setDepTime(depTime);
                }
                if (date != null && !date.equals("")) {
                    busNumber.setDate(date);
                }
                if (arrTime != null && !arrTime.equals("")) {
                    busNumber.setArrTime(arrTime);
                }
                if (platform != null && !platform.equals("")) {
                    System.out.println("do this code" + platform);
                    busNumber.setPlatform(platform);
                }
                if (busJPA.findBusByLicencePlate(busNumber.getLicencePlate())!=null){
                    busNumber.setSeatNum(busJPA.findBusByLicencePlate(busNumber.getLicencePlate()).getMaxPassen());
                    return ResultUtil.success(busNumberJPA.save(busNumber));
                }else {
                    return ResultUtil.error(3,"no this bus");
                }
            }
        }
    }

    //查询车次
    @RequestMapping(value = "/findbusnum", method = RequestMethod.GET)
    public Result<List<BusNumber>> findBusNum(String depTime, String date, String departure) {
        List<BusNumber> busNumberList;
        if (departure != null && !departure.equals("")) {
//            System.out.println("Run depaeture find");
            busNumberList = busNumberJPA.findBusNumberByDeparture(departure);
            if (busNumberList == null || busNumberList.isEmpty()) {
                return ResultUtil.error(2, "Nofind");
            } else {
                return ResultUtil.success(busNumberList);
            }
        } else if (date != null && depTime != null && !depTime.equals("") && !date.equals("")) {
            busNumberList = busNumberJPA.findBusNumberByDateAndDepTime(date, depTime);
//            System.out.println("run date and depTine find");
            if (busNumberList == null || busNumberList.isEmpty()) {
                /*if (busNumberList!=null){
                    System.out.println(busNumberList);
                }*/
                return ResultUtil.error(2, "Nofind");
            } else {
                return ResultUtil.success(busNumberList);
            }
        } else {
            busNumberList = busNumberJPA.findAll();
            return ResultUtil.success(busNumberList);
        }
    }

    //增加车次
    @RequestMapping(value = "/addbusnum", method = RequestMethod.GET)
    public Result addBusNum(BusNumber entity) {
        if (busNumberJPA.findBusNumberByBusNum(entity.getBusNum()) != null) {
            return ResultUtil.error(3, "exist already");
        } else {
            if (busJPA.findBusByLicencePlate(entity.getLicencePlate()) == null) {
                return ResultUtil.error(2, "We don't have this bus");
            } else {
                BusNumber isDo = busNumberJPA.save(entity);
                if (isDo != null) {
                    return ResultUtil.success(isDo);
                } else {
                    return ResultUtil.error(2, "add error");
                }
            }
        }
    }

    //删除车次
    @RequestMapping(value = "/deletebusnum", method = RequestMethod.GET)
    public Result deleteBusNum(Long num) {
        BusNumber busNumber = busNumberJPA.findBusNumberByBusNum(num);
        if (busNumber != null) {
            busNumberJPA.deleteById(busNumber.getId());
            return ResultUtil.success();
        } else {
            return ResultUtil.error(2, "Nofind");
        }
    }

    //增加车辆
    @RequestMapping(value = "/addbus", method = RequestMethod.GET)
    public Result busAdd(Bus entity) {
        if (busJPA.findBusByLicencePlate(entity.getLicencePlate()) != null) {
            return ResultUtil.error(3, "exist already");
        }

        Bus isDo = busJPA.save(entity);
        if (isDo != null) {
            return ResultUtil.success(isDo);
        } else {
            return ResultUtil.error(2, "add error");
        }
    }

    //查询车辆
    @RequestMapping(value = "/findbus", method = RequestMethod.GET)
    public Result<List<Bus>> findbus(String licencePlate) {
        if (licencePlate == null) {
            return ResultUtil.success(busJPA.findAll());
        }
        if (licencePlate.equals("")) {
            return ResultUtil.success(busJPA.findAll());
        } else {
            Bus bus = busJPA.findBusByLicencePlate(licencePlate);
            if (bus != null) {
                return ResultUtil.success(bus);
            } else {
                return ResultUtil.error(2, "Nofind");
            }
        }
    }

    //删除车辆
    @RequestMapping(value = "/deletebus", method = RequestMethod.GET)
    public Result deletebus(String licencePlate) {
        Bus bus = busJPA.findBusByLicencePlate(licencePlate);
        if (bus != null) {
            busJPA.delete(bus);
            return ResultUtil.success();
        } else {
            return ResultUtil.error(2, "Nofind");
        }
    }

    //修改车辆信息
    @RequestMapping(value = "/updatebus", method = RequestMethod.GET)
    public Result updatebus(String licencePlate,Long driverNum) {
        Bus bus;
        if (driverNum == null) {
            return ResultUtil.error(3, "wrong parameter!");
        }
        else {
            bus = busJPA.findBusByLicencePlate(licencePlate);
            if (bus == null) {
                return ResultUtil.error(2, "Nofind");
            } else {
                bus.setDriverNum(driverNum);
                if(busJPA.save(bus)!=null){
                    return ResultUtil.success(bus);
                }else {
                    return ResultUtil.error(3,"update error");
                }
            }
        }
    }

    //增加售票员
    @RequestMapping(value = "/addcondutor",method = RequestMethod.GET)
    public Result addCondutor(Conductor conductor){
        if (conductorJPA.findConductorByConNum(conductor.getConNum())!=null){
            return ResultUtil.error(2,"already exist");
        }else {
            return ResultUtil.success(conductorJPA.save(conductor));
        }
    }
    //删除售票员
    @RequestMapping(value = "/deletecondutor",method = RequestMethod.GET)
    public Result deleteCondutor(Long conNum){
        if (conductorJPA.findConductorByConNum(conNum)!=null){
            conductorJPA.delete(conductorJPA.findConductorByConNum(conNum));
            return ResultUtil.success();
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }
    //查询售票员
    @RequestMapping(value = "/findcondutor",method = RequestMethod.GET)
    public Result<List<Conductor>> findcondutor(Long conNum){
        if (conNum !=null){
            Conductor conductor = conductorJPA.findConductorByConNum(conNum);
            if (conductor!=null){
                return ResultUtil.success(conductor);
            }else {
                return ResultUtil.error(2,"Nofind");
            }
        }else {
            return ResultUtil.success(conductorJPA.findAll());
        }
    }

    //更新售票员
    @RequestMapping(value = "/updatecondutor",method = RequestMethod.GET)
    public Result updateCondutor(Long conNum,Long basicSalary,Long pushMoney,Long ticketNum){
        Conductor conductor;
        if (conductorJPA.findConductorByConNum(conNum)!=null){
            conductor = conductorJPA.findConductorByConNum(conNum);
            conductor.setBasicSalary(basicSalary);
            conductor.setPushMoney(pushMoney);
            conductor.setTicketNum(ticketNum);
            return ResultUtil.success(conductorJPA.save(conductor));
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }
    //增加司机
    @RequestMapping(value = "/adddriver",method = RequestMethod.GET)
    public Result addDriver(Driver driver){
        if(driverJPA.findDriverByDriverNum(driver.getDriverNum())!=null){
            return ResultUtil.error(2,"already exist");
        }else {
            return ResultUtil.success(driverJPA.save(driver));
        }
    }
    //删除司机
    @RequestMapping(value = "deletedriver",method = RequestMethod.GET)
    public Result deleteDriver(Long driverNum){
        if(driverJPA.findDriverByDriverNum(driverNum)!=null){
            driverJPA.delete(driverJPA.findDriverByDriverNum(driverNum));
            return ResultUtil.success();
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }

    //查询司机
    @RequestMapping(value = "finddriver",method = RequestMethod.GET)
    public Result<List<Driver>> findDriver(Long driverNum){
        Driver driver;
        if(driverNum !=null){
            driver = driverJPA.findDriverByDriverNum(driverNum);
            if (driver!=null){
                return ResultUtil.success(driver);
            }else {
                return ResultUtil.error(2,"Nofind");
            }
        }else {
            return ResultUtil.success(driverJPA.findAll());
        }
    }
    //修改司机
    @RequestMapping(value = "updatedriver",method = RequestMethod.GET)
    public Result updateDriver(Long driverNum,String name,Long salary){
        Driver driver;
        if (driverJPA.findDriverByDriverNum(driverNum)!=null){
            driver = driverJPA.findDriverByDriverNum(driverNum);
            driver.setDriverNum(driverNum);
            driver.setName(name);
            driver.setSalary(salary);
            driverJPA.save(driver);
            return ResultUtil.success(driver);
        }else {
            return ResultUtil.error(2,"Nofind");
        }
    }
    //增加车票
    @RequestMapping(value = "addticket",method = RequestMethod.GET)
    public Result addticket(Ticket ticket){
        return ResultUtil.error(2,"no result");
    }

}