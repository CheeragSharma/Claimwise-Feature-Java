package org.example.PatentAnalysis;

import java.util.HashSet;
import java.util.Set;

public class PatentFeatureExtractor {
    public static Set<String> getPatentFeatures(Integer patentId) {
        // TODO: Brute force features for patents irrespective of patentID
        Set<String> patentFeatures = new HashSet<>();
        if(patentId == 1) {
            patentFeatures.add("Strong");
            patentFeatures.add("lightweight");
        } else if(patentId == 2) {
            patentFeatures.add("Weak");
            patentFeatures.add("lightweight");
        } else if (patentId == 3) {
            patentFeatures.add("Weak");
            patentFeatures.add("Heavy");
        } else if (patentId == 4) {
            patentFeatures.add("Heavy");
            patentFeatures.add("Strong");
        }
        return patentFeatures;
    }
}