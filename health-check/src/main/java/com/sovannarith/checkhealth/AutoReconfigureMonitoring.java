package com.sovannarith.checkhealth;

import org.apache.maven.model.Contributor;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.HealthStatusHttpMapper;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Configuration
public class AutoReconfigureMonitoring {


	@Value("${info.build.version}")
	private String version;

	final HealthEndpoint healthEndpoint;
	final HealthStatusHttpMapper statusMapper;
	final InfoEndpoint infoEndpoint;

	AutoReconfigureMonitoring(HealthEndpoint healthEndpoint, HealthStatusHttpMapper statusMapper,
							  InfoEndpoint infoEndpoint) {
		this.healthEndpoint = healthEndpoint;
		this.statusMapper = statusMapper;
		this.infoEndpoint = infoEndpoint;
	}

	@GetMapping("/health")
	public ResponseEntity getHealth() {
		Health health = healthEndpoint.health();
		return ResponseEntity.status(statusMapper.mapStatus(health.getStatus())).body(health);
	}

	@GetMapping("/info")
	public ResponseEntity getInfo() {
		infoEndpoint.info();
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model model = null;
		try {
			model = reader.read(new FileReader("health-check/pom.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		}
		System.out.println(model.getId());
		System.out.println(model.getGroupId());
		System.out.println(model.getArtifactId());
		System.out.println(model.getVersion());
		List<InfoContributor> infoContributors = new ArrayList<>();
		Contributor contributor = new Contributor();
		contributor.addProperty("A", "apple");
		contributor.addProperty("B", "boy");
		contributor.addProperty("C", "cat");
//		infoContributors.set(0, contributor);
//		new InfoEndpoint()
		return ResponseEntity.ok(infoEndpoint.info());
	}

}
