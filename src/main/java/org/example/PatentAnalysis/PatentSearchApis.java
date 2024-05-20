package org.example.PatentAnalysis;

import org.example.FeatureSearch.FeatureSearch;

import java.util.HashSet;
import java.util.Set;

public class PatentSearchApis {
    public static Set<Integer> getRelevantPatentIds(String feature){
        // TODO: Implement logic to match feature to patent and return result
        Set<Integer> relevantPatentIds = new HashSet<>();
        relevantPatentIds.add(2);
        relevantPatentIds.add(3);
        relevantPatentIds.add(4);
        return relevantPatentIds;
    }

    public static Set<Integer> getRelevantPatentsForPatent(Integer patentId){
        Set<Integer> relevantPatents = new HashSet<>();
        Set<String> features = FeatureSearch.getPatentFeatures(patentId);
        for(String feature : features){
            relevantPatents.addAll(getRelevantPatentIds(feature));
        }
        return relevantPatents;
    }
}
