package org.example.Clients;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.action.delete.DeleteRequest;
import org.opensearch.action.delete.DeleteResponse;
import org.opensearch.action.get.GetRequest;
import org.opensearch.action.get.GetResponse;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.action.index.IndexResponse;
import org.opensearch.action.support.master.AcknowledgedResponse;
import org.opensearch.client.RequestOptions;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.RestHighLevelClient;
import org.opensearch.client.indices.CreateIndexRequest;
import org.opensearch.client.indices.CreateIndexResponse;
import org.opensearch.common.settings.Settings;

import java.io.IOException;
import java.util.HashMap;

public class OpenSearchRestClient {

    public static void search(){
        try {

            String clusterUrl = "https://search-patent-index-mfegi4vq3yutou7d5wi6377bum.aos.eu-west-1.on.aws:9200";
            String username = "admin";
            String password = "prdgSV9V6jcbyc@^od";

            //Establish credentials to use basic authentication.
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();

            credentialsProvider.setCredentials(AuthScope.ANY,
                    new UsernamePasswordCredentials(username, password));

            //Create a client.
            RestClientBuilder builder = RestClient.builder(new HttpHost(d"search-patent-index-mfegi4vq3yutou7d5wi6377bum.aos.eu-west-1.on.aws", 9200, "https"))
                    .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                        @Override
                        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        }
                    });

            RestHighLevelClient client = new RestHighLevelClient(builder);

            //Getting back the document
            GetRequest getRequest = new GetRequest("patent-corpus", "1");
            GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);

            System.out.println(response.getSourceAsString());

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
