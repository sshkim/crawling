package sshkim.crawling.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import sshkim.crawling.Const;

/**
 * Created by sshkim on 2016. 10. 31..
 */
public class MongoDBConnection implements AutoCloseable {
    private MongoClient mongoClient = null;
    private DB db = null;

    public MongoDBConnection() {
        initDB();
    }

    private void initDB() {
        MongoClientOptions options = (new MongoClientOptions.Builder()).connectionsPerHost(Const.MONGODB_CONNECTION_PER_HOST).maxWaitTime(10000).socketKeepAlive(true).threadsAllowedToBlockForConnectionMultiplier(5).build();
        mongoClient = new MongoClient(new ServerAddress(Const.MONGODB_HOST, Const.MONGODB_PORT), options);
        db = mongoClient.getDB(Const.MONGODB_DBNAME);
    }

    public void closeConnection() {
        mongoClient.close();
    }


    public void close() throws Exception {
        closeConnection();
    }
}
