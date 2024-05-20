package org.example;

import java.util.HashMap;
import java.util.Set;

import org.example.Clients.OpenSearchRestClient;
import org.example.FeatureSearch.FeatureSearch;
import org.example.PatentAnalysis.PatentSearchApis;

public class Main {
    public static void main(String[] args) {
        // TODO: brute force id of original patent we want to check against all patents
        Integer productPatentId = 1;
        Set<Integer> relevantPatents = PatentSearchApis.getRelevantPatentsForPatent(productPatentId);
        HashMap<Integer, Double> mapping = FeatureSearch.featureMatchPercentage(relevantPatents, productPatentId);
        System.out.println(mapping);
    }
}