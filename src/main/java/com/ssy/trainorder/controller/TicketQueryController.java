package com.ssy.trainorder.controller;

import com.ssy.trainorder.entity.DirectTicketResult;
import com.ssy.trainorder.entity.Result;
import com.ssy.trainorder.service.TicketQueryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Resource;

@RestController
@RequestMapping
public class TicketQueryController {

    @Resource
    private TicketQueryService ticketQueryService;

    @RequestMapping("directTicketRemaining")
    public Result findDirectTicket(@Validated @RequestBody Map<String,Object> request,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
        }

        String start_place = (String) request.get("start_place");
        String end_place = (String) request.get("end_place");
        String start_date = (String) request.get("start_date");
        String min_time = (String) request.get("min_time");
        String max_time = (String) request.get("max_time");

        List<DirectTicketResult> directTicketResults = new ArrayList<DirectTicketResult>();
        directTicketResults = ticketQueryService.findDirectTicket(start_place,end_place,start_date);

        if(directTicketResults.isEmpty()) {
            return Result.fail("结果为空");
        }

        if(min_time != "") {
            for(int i = 0; i < directTicketResults.size(); i++) {
                if(directTicketResults.get(i).getStart_time().compareTo(min_time) < 0) {
                    directTicketResults.remove(i);
                    i--;
                }
            }
        }
        if(max_time != "") {
            for(int i = 0; i < directTicketResults.size(); i++) {
                if(directTicketResults.get(i).getStart_time().compareTo(max_time) > 0) {
                    directTicketResults.remove(i);
                    i--;
                }
            }
        }

        if(directTicketResults.isEmpty()) {
            return Result.fail("结果为空");
        }

        for(DirectTicketResult directTicketResult:directTicketResults) {
            int last = Integer.parseInt(directTicketResult.getLast_time());
            String last_time = String.format("%02d:%02d",last/60,last%60);
            directTicketResult.setLast_time(last_time);
            String train_no = directTicketResult.getTrain_no();
            String start_station_name = directTicketResult.getStart_station_name();
            String end_station_name = directTicketResult.getEnd_station_name();
            String depart_date = ticketQueryService.findDepartDate(train_no,start_station_name,start_date);
            String seat_types[] = {"特等座","一等座","二等座","软卧","硬卧","硬座"};
            for(String seat_type:seat_types) {
                if(ticketQueryService.findSeatRemaining(train_no,start_station_name,end_station_name,depart_date,seat_type) != null) {
                    int remaining = ticketQueryService.findSeatRemaining(train_no,start_station_name,end_station_name,depart_date,seat_type);
                    if (remaining > 20) {
                        switch (seat_type) {
                            case "特等座":
                                directTicketResult.setPremier_seat("有");
                                break;
                            case "一等座":
                                directTicketResult.setFirst_seat("有");
                                break;
                            case "二等座":
                                directTicketResult.setSecond_seat("有");
                                break;
                            case "软卧":
                                directTicketResult.setSoft_sleeper("有");
                                break;
                            case "硬卧":
                                directTicketResult.setHard_sleeper("有");
                                break;
                            case "硬座":
                                directTicketResult.setHard_seat("有");
                                break;
                            default:
                                break;
                        }
                    } else if (remaining >= 0) {
                        switch (seat_type) {
                            case "特等座":
                                directTicketResult.setPremier_seat(String.valueOf(remaining));
                                break;
                            case "一等座":
                                directTicketResult.setFirst_seat(String.valueOf(remaining));
                                break;
                            case "二等座":
                                directTicketResult.setSecond_seat(String.valueOf(remaining));
                                break;
                            case "软卧":
                                directTicketResult.setSoft_sleeper(String.valueOf(remaining));
                                break;
                            case "硬卧":
                                directTicketResult.setHard_sleeper(String.valueOf(remaining));
                                break;
                            case "硬座":
                                directTicketResult.setHard_seat(String.valueOf(remaining));
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        return Result.succ(directTicketResults);
    }

}
