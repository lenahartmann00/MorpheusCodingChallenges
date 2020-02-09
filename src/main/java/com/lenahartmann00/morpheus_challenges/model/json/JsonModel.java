package com.lenahartmann00.morpheus_challenges.model.json;

/**
 * This interface is used to register a new json model class to {@link
 * com.lenahartmann00.morpheus_challenges.logic.challenge.AbstractChallenge}. Such model classes are
 * used to by {@link com.google.gson.Gson} when sending http requests.<br> Note: The variable names
 * are used to match the attribute with the specific json object. So the attribute names cannot
 * differ from the json names unless a own deserializer {@link com.google.gson.JsonDeserializer} is
 * implemented.
 */
public interface JsonModel {

}