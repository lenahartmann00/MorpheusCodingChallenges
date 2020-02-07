package com.lenahartmann00.morpheus_challenges.logic.gson;

/**
 * This interface should be implemented as a json model class. It is used to highlight that in
 * {@link com.lenahartmann00.morpheus_challenges.logic.challenge.AbstractChallenge} the generic
 * types have to be a json model which are used by {@link com.google.gson.Gson}.<br> Note: The
 * variable names are used to match the attribute with the specific json object. So the attribute
 * names cannot differ from the json names.
 */
public interface JsonModel {

}