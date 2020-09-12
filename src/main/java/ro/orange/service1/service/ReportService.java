package ro.orange.service1.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ro.orange.service1.dto.ReportDTO;

@Service
@Transactional
public class ReportService {

    private final Logger logger = LoggerFactory.getLogger(ReportService.class.getName());
    public static final String PERSISTENCESERVICE = "PERSISTENCESERVICE";

    @Autowired
    //@LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    public ReportDTO generateReport(ReportDTO reportDTO) {
        Application application = eurekaClient.getApplication(PERSISTENCESERVICE);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/reports/"+ reportDTO.getCnp() + "/" + reportDTO.getIban();
        logger.debug(String.format("MS1 ReportService URL :: %s ", url));
        ReportDTO reportDTO1 = restTemplate.getForObject(url, ReportDTO.class);
        logger.debug(String.format("MS1 Received a new generated report :: %s ", reportDTO1.toString()));
        return reportDTO;
    }
}
