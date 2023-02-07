package net.icxd.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDB {
    private static MongoDB instance;
    private MongoClient client;
    private String uri;
    private String database;
    public MongoDB(String uri, String database) {
        this.uri = uri;
        this.database = database;
    }

    public MongoDB() {
        this.uri = "mongodb://localhost:27017";
        this.database = "defaultDatabase";
    }

    public void init() {
        instance = this;
        this.client = new MongoClient(new MongoClientURI(uri));
    }

    /**
     * Return the client.
     *
     * @return The MongoClient object.
     */
    public MongoClient getClient() { return client; }
    /**
     * Returns the URI of the current client.
     *
     * @return The uri of the current client.
     */
    public String getUri() { return uri; }
    /**
     * This function sets the value of the uri variable to the value of the uri parameter.
     *
     * @param uri The URI of the resource to be accessed.
     */
    public void setUri(String uri) { this.uri = uri; }
    /**
     * Returns the database name.
     *
     * @return The database name.
     */
    public String getDatabase() { return database; }
    /**
     * This function sets the database variable to the value of the database parameter.
     *
     * @param database The name of the database to connect to.
     */
    public void setDatabase(String database) { this.database = database; }

    /**
     * If the instance variable is null, create a new instance of the class and assign it to the instance variable. Then
     * return the instance variable.
     *
     * @return The instance of the MongoDB class.
     */
    public static MongoDB getInstance() { return instance; }
}
