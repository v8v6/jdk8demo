package com.sc.cd.es;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;

import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 描述:
 *
 * @author junxi.chen
 * @create 2019-01-07 14:55
 */
@Slf4j
public class IndexDemo {
    public static void main(String[] args) {
        TransportClient client = EsUtil.getClient();





        /*testInsertDoc(client);

        Map<String,Object> data = Maps.newHashMap();
        testUpdateDoc(data, client);

        testUpdateAndInsertDoc(client);
        String indexName = "indexName",indexType = "indexType",id = "id";
        get(indexName,indexType,id,client);*/



    }

    public static Map<String, Object> get(String indexName,String indexType,String id,Client client){
        GetResponse getResponse = client
                .prepareGet(indexName, indexType, id)
                .execute().actionGet();

        return getResponse.getSource();
    }

    @Test
    public void delDocument(){
        TransportClient client = EsUtil.getClient();
        DeleteResponse deleteResponse = client
                .prepareDelete("indexName", "indexType", "1")
                .execute().actionGet();
        deleteResponse.isFragment();
    }

    @Test
    public void delIndex(){
        TransportClient client = EsUtil.getClient();
        DeleteIndexRequest deleteRequest = new DeleteIndexRequest("indexName");
        client.admin().indices().delete(deleteRequest).actionGet();
    }



    /**
     * 插入索引文档
     */
    @Test
    public void testInsertDoc() {
        TransportClient client = EsUtil.getClient();
        try {
            IndexResponse docResponse = client.prepareIndex("indexName", "typeName", "1")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("type", "syslog")
                            .field("eventCount", 1)
                            .field("eventData", Date.from(Instant.now()))
                            .field("message", "secilog insert doc test")
                            .endObject()).execute().actionGet();
            log.info(docResponse.getIndex(),docResponse.getId(),docResponse.status().getStatus());
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
    }


    /**
     * 创建index
     */
    @Test
    public  void testCreateIndex() {
        TransportClient client = EsUtil.getClient();
        try{
            XContentBuilder mapping = jsonBuilder()
                    .startObject()
                    .startObject("settings")
                    // 分片数量
                    .field("number_of_shards",1)
                    .field("number_of_replicas",1)
                    .endObject()
                    .endObject()
                    .startObject()
                    .startObject("typeName")
                    .startObject("properties")
                    .startObject("type").field("type","string").field("store","yes").endObject()
                    .startObject("eventCount").field("type","long").field("store","yes").endObject()
                    .startObject("eventDate").field("type","date").field("format","dateOptionalTime").field("store","yes").endObject()
                    .startObject("message").field("type","string").field("index","not_analyzed").field("store","yes").endObject()
                    .endObject()
                    .endObject()
                    .endObject();

            CreateIndexResponse indexResponse = client.admin().indices().prepareCreate("indexName").setSource(mapping).get();

            if (indexResponse.isAcknowledged()){
                System.out.println("create index success...");
            }else{
                System.out.println("create index failed...");

            }
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
        }
    }












    public static void testUpdateAndInsertDoc(Client client){
        try {
            //或者使用下面方式（效果一样）
            XContentBuilder jsonBuilder =XContentFactory.jsonBuilder();

            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index("indexName")
            .type("typeName")
            .id("id")
            .doc(jsonBuilder
                    .startObject()
                        .field("title").value("XContentBuilder")
                    .endObject());
            client.update(updateRequest).actionGet();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }


    }

    private static void testUpdateDoc(Map<String, Object> data, Client client) {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("indexName")
                .type("typeName")
                .id("id")
                .doc(data);

        UpdateResponse updateResponse = client.update(updateRequest).actionGet();
        System.out.println(updateResponse);
    }


}
