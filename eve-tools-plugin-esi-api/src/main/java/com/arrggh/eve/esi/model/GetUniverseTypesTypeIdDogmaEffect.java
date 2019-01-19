/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 0.8.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.arrggh.eve.esi.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * dogma_effect object
 */
@ApiModel(description = "dogma_effect object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class GetUniverseTypesTypeIdDogmaEffect {
  @SerializedName("effect_id")
  private Integer effectId = null;

  @SerializedName("is_default")
  private Boolean isDefault = null;

  public GetUniverseTypesTypeIdDogmaEffect effectId(Integer effectId) {
    this.effectId = effectId;
    return this;
  }

   /**
   * effect_id integer
   * @return effectId
  **/
  @ApiModelProperty(required = true, value = "effect_id integer")
  public Integer getEffectId() {
    return effectId;
  }

  public void setEffectId(Integer effectId) {
    this.effectId = effectId;
  }

  public GetUniverseTypesTypeIdDogmaEffect isDefault(Boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

   /**
   * is_default boolean
   * @return isDefault
  **/
  @ApiModelProperty(required = true, value = "is_default boolean")
  public Boolean isIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Boolean isDefault) {
    this.isDefault = isDefault;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseTypesTypeIdDogmaEffect getUniverseTypesTypeIdDogmaEffect = (GetUniverseTypesTypeIdDogmaEffect) o;
    return Objects.equals(this.effectId, getUniverseTypesTypeIdDogmaEffect.effectId) &&
        Objects.equals(this.isDefault, getUniverseTypesTypeIdDogmaEffect.isDefault);
  }

  @Override
  public int hashCode() {
    return Objects.hash(effectId, isDefault);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseTypesTypeIdDogmaEffect {\n");
    
    sb.append("    effectId: ").append(toIndentedString(effectId)).append("\n");
    sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

