package net.icxd.mongo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;

public interface ICollection {

    /**
     * The name of the collection.
     *
     * @return The name of the collection.
     */
    String name();
    /**
     * Returns a new Document object with the default settings.
     *
     * @return The default document for the current application.
     */
    Document defaultDocument();

    /**
     * If the database doesn't exist, create it, then return the collection
     *
     * @return A MongoCollection<Document>
     */
    default MongoCollection<Document> get() {
        if (!MongoDB.getInstance().getClient().listDatabaseNames().into(new ArrayList<>()).contains(MongoDB.getInstance().getDatabase()))
            MongoDB.getInstance().getClient().getDatabase(MongoDB.getInstance().getDatabase()).createCollection(name());
        return MongoDB.getInstance().getClient().getDatabase(MongoDB.getInstance().getDatabase()).getCollection(name());
    }
}
