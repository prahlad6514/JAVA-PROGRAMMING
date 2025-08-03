#pom.xml file for Maven project

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>RecommendationSystem</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.apache.mahout</groupId>
            <artifactId>mahout-core</artifactId>
            <version>14.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.mahout</groupId>
            <artifactId>mahout-math</artifactId>
            <version>14.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-common</artifactId>
            <version>3.2.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-mapreduce-client-core</artifactId>
            <version>3.2.0</version>
        </dependency>
    </dependencies>
</project>


#Implement the Recommendation Engine
 RecommendationEngine.java in the com.example package.

package com.example;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericUser BasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.impl.recommender.GenericUser BasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecommendationEngine {

    public static void main(String[] args) {
        try {
            // Load user preferences from CSV file
            DataModel model = new FileDataModel(new File("data/user_preferences.csv"));

            // Create similarity and recommender objects
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new NearestNUser Neighborhood(2, similarity, model);
            Recommender recommender = new GenericUser BasedRecommender(model, neighborhood, similarity);

            // Get recommendations for a specific user
            long userId = 1; // Change this to test different users
            List<RecommendedItem> recommendations = recommender.recommend(userId, 2);

            // Display recommendations
            System.out.println("Recommendations for User " + userId + ":");
            for (RecommendedItem item : recommendations) {
                System.out.println("Item ID: " + item.getItemID() + ", Value: " + item.getValue());
            }

        } catch (IOException | TasteException e) {
            e.printStackTrace();
        }
    }
}
