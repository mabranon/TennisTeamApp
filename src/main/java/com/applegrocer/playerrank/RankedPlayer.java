/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.applegrocer.playerrank;

/**
 *
 * @author AppleGrocer
 */
public class RankedPlayer {
    private Integer rank;
    private String name;
    private Integer wins;
    private Integer losses;
    
    public RankedPlayer(Integer rank, String name, Integer wins, 
            Integer losses){
        this.rank=rank;
        this.name=name;
        this.wins=wins;
        this.losses=losses;
    }

    /**
     * @return the rank
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the wins
     */
    public Integer getWins() {
        return wins;
    }

    /**
     * @param wins the wins to set
     */
    public void setWins(Integer wins) {
        this.wins = wins;
    }

    /**
     * @return the losses
     */
    public Integer getLosses() {
        return losses;
    }

    /**
     * @param losses the losses to set
     */
    public void setLosses(Integer losses) {
        this.losses = losses;
    }
    
    
}
