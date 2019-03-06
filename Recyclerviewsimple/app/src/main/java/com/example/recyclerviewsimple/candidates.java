package com.example.recyclerviewsimple;

public class candidates {
    private String candidatename;
    private String party;
    private int candidate;

    public candidates(String candidatename, String party, int candidate) {
        this.candidatename = candidatename;
        this.party = party;
        this.candidate = candidate;
    }

    public String getCandidatename() {
        return candidatename;
    }

    public String getParty() {
        return party;
    }

    public int getCandidate() {
        return candidate;
    }
}
