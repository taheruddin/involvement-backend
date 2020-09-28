package com.hm.backend;

import com.hm.backend.dao.Sector;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Utils {
    public static final Sector rootSector = new Sector(1L, "Air", null, null);
    public static final Sector branchSector = new Sector(2L, "Air", rootSector, null);
    public static final Sector leafSector = new Sector(3L, "Air",branchSector, new ArrayList<>());

    public static String getJsonString(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        return new BufferedReader(
            new InputStreamReader(inputStream, StandardCharsets.UTF_8))
            .lines()
            .collect(Collectors.joining("\n")
            );
    }

    public static Sector getLeafSector() {
        setChildren();
        return leafSector;
    }

    public static Sector getBranchSector() {
        setChildren();
        return branchSector;
    }

    private static void setChildren() {
        rootSector.setChildren(Arrays.asList(branchSector));
        branchSector.setChildren(Arrays.asList(leafSector));
    }
}
