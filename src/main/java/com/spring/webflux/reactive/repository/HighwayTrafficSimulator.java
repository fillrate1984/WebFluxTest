package com.spring.webflux.reactive.repository;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.webflux.reactive.model.Vehicle;

import reactor.core.publisher.Flux;

@Service
public class HighwayTrafficSimulator implements HighwayTraffic {

	public HighwayTrafficSimulator() {
	}

	public Flux<Vehicle> flowTraffic() {

		return Flux.<Vehicle>create(fluxSink -> {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("TraficSimulator.flowTraffic");
					fluxSink.next(HighwayUtilities.simulateTraffic());
					Thread.sleep(30);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).share();
	}


	private static class HighwayUtilities {

		private static Vehicle simulateTraffic() {
			Integer speed = ThreadLocalRandom.current().nextInt(60, 175);

			return new Vehicle(speed);

		}

	}
}
