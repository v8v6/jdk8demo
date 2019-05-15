package com.sc.cd.es;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2018-12-03 11:27
 */
@Log4j2
public class EsUtil {

    /**
     * 获取es client,
     * @return
     */
    public static TransportClient getClient() {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        TransportClient client = null;
        try {
            client =new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.203.128"), 9200));
            List<DiscoveryNode> nodes = client.listedNodes();
            for (DiscoveryNode node : nodes) {
                log.info("Discovered node: " + node.getHostAddress());
            }
        } catch (UnknownHostException e) {
            log.error(e.getMessage(),e);
        }
        return client;
    }







}
