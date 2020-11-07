package edu.geodani.validation.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import edu.geodani.validation.dto.ReportDTO;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ReportService {

    private static final String PERSISTENCESERVICE = "PERSISTENCESERVICE";

    //@LoadBalanced
    private final RestTemplate restTemplate;

    private final EurekaClient eurekaClient;

    public ReportDTO generateReport(ReportDTO reportDTO) {
        Application application = eurekaClient.getApplication(PERSISTENCESERVICE);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/reports/"+ reportDTO.getCnp() + "/" + reportDTO.getIban();
        log.debug(String.format("MS1 ReportService URL :: %s ", url));
        ReportDTO reportDTO1 = restTemplate.getForObject(url, ReportDTO.class);
        log.debug(String.format("MS1 Received a new generated report :: %s ", reportDTO1.toString()));
        return reportDTO;
    }
}
