package com.sc.cd.es;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.junit.Test;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


@Log4j2
public class EsUtilTest {

    @Test
    public void getClient() {
        Client client= new EsUtil().getClient();
        log.error("client:{}",client);
    }

    @Test
    public void get() {
        Client client= new EsUtil().getClient();
        try {
            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("user", "kimchy")
                            .field("postDate", new Date())
                            .field("message", "trying out Elasticsearch")
                            .endObject()
                    )
                    .get();
            log.error("response:{}",response);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }

    }
}