//Paste into: GroupWork/SubscribeAndSave/src/main/java/com/kenzie/subscribeandsave/App.java
//from repository: ata-week-2

//this link was useful for understanding the issue: https://stackoverflow.com/questions/11565694/java-io-filenotfoundexception-on-an-existing-file

package com.kenzie.subscribeandsave;

import com.kenzie.subscribeandsave.dao.SubscriptionDAO;
import com.kenzie.subscribeandsave.dao.SubscriptionFileStorage;
import com.kenzie.subscribeandsave.resources.AmazonIdentityService;
import com.kenzie.subscribeandsave.resources.AmazonProductService;
import com.kenzie.subscribeandsave.service.SubscriptionService;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/**
 * Provides inversion of control for the SNS MLP by instantiating all of the
 * dependencies needed by the SubscriptionDebugUtil and its dependency classes.
 */
public class App {

    /**
     * Returns a product service.
     *
     * @return Product service usable for fetching products by ASIN
     */
    public static AmazonProductService getAmazonProductService() {
        try {
            File temp = new File(ClassLoader.getSystemResource("catalog.json").toURI());
            return new AmazonProductService(temp);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Returns an identity service.
     *
     * @return Identity service usable for fetching customers by ID
     */
    public static AmazonIdentityService getAmazonIdentityService() {
        try {
            File temp = new File(ClassLoader.getSystemResource("customers.txt").toURI());
            return new AmazonIdentityService(temp);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets a subscription DAO.
     *
     * @return A subscription DAO for reading/writing subscriptions
     */
    public static SubscriptionDAO getSubscriptionDAO() {
        return new SubscriptionDAO(getSubscriptionFileStorage());
    }

    /**
     * Gets a subscription file storage manager.
     *
     * @return A subscription file data store
     */
    public static SubscriptionFileStorage getSubscriptionFileStorage() {
        try {
            File tempFile = new File(ClassLoader.getSystemResource("subscriptions.csv").toURI());
            return new SubscriptionFileStorage(tempFile);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets subscription service.
     *
     * @return the subscription service
     */
    public static SubscriptionService getSubscriptionService() {
        return new SubscriptionService(getAmazonIdentityService(), getSubscriptionDAO(), getAmazonProductService());
    }
}
