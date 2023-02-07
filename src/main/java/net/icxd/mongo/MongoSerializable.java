package net.icxd.mongo;

import org.bson.Document;

public interface MongoSerializable {
    Document toDocument();
    MongoSerializable fromDocument(Document document);
}
