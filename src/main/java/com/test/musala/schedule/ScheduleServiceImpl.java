package com.test.musala.schedule;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.test.musala.dto.DroneDto;
import com.test.musala.dto.ResponseDto;
import com.test.musala.service.IDroneDispatcherService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl {

	private IDroneDispatcherService droneService;

	Logger logger = Logger.getLogger(ScheduleServiceImpl.class.getName());

	public ScheduleServiceImpl(IDroneDispatcherService droneService) {
		this.droneService = droneService;
	}

	@Scheduled(fixedDelay = 10000)
	public void checkDronesBattery() {
		ResponseEntity<ResponseDto<List<DroneDto>>> response = droneService.getAllDrones();
		if (response.hasBody() && !response.getBody().getData().isEmpty()) {
			response.getBody().getData().stream().forEach(drone -> {

				System.out.println(drone.getSerialNumber());
				logger.info(new StringBuilder()
						.append("Drone id : ")
						.append(drone.getId())
						.append(" Battery level : ")
						.append(drone.getBatteryPercentage())
						.append(" %").toString());

			});
		}
	}

}
