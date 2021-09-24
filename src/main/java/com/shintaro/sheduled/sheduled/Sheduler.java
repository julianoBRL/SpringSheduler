package com.shintaro.sheduled.sheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Sheduler {
	
	@Scheduled(cron = "0 45 15 1/1 * ?", zone = "America/Sao_Paulo")
	public void turnOnSleep() {
		log.info("Turning ON sleep mode.");
		Locker.getInstance().setSlepping(true);
	}
	
	@Scheduled(cron = "0 0 16 1/1 * ?", zone = "America/Sao_Paulo")
	public void turnOffSleep() {
		log.info("Turning OFF sleep mode.");
		Locker.getInstance().setSlepping(false);
	}
	
}
