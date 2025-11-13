package com.simportal.service;

import com.simportal.model.Offer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimService {

    // Hard-coded valid ICCIDs (in real life, read from DB)
    private static final String[] VALID_ICCIDS = {
        "8901260123456789012",
        "8901260987654321098",
        "8901260112233445566",
        "123"
    };

    public boolean isValidIccId(String iccId) {
        if (iccId == null) return false;
        for (String valid : VALID_ICCIDS) {
            if (valid.equals(iccId)) return true;
        }
        return false;
    }

    public List<Offer> getSpecialOffers(String iccId) {
        // pretend we look up offers based on ICCID
        return List.of(
            new Offer() {{ setTitle("10 GB Free"); setDescription("First month"); setDiscount(0); }},
            new Offer() {{ setTitle("50% Off"); setDescription("Second month"); setDiscount(50); }}
        );
    }
}