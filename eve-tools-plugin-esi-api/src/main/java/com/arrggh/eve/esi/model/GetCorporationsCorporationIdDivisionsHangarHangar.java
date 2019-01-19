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
 * hangar object
 */
@ApiModel(description = "hangar object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class GetCorporationsCorporationIdDivisionsHangarHangar {
  @SerializedName("division")
  private Integer division = null;

  @SerializedName("name")
  private String name = null;

  public GetCorporationsCorporationIdDivisionsHangarHangar division(Integer division) {
    this.division = division;
    return this;
  }

   /**
   * division integer
   * minimum: 1
   * maximum: 7
   * @return division
  **/
  @ApiModelProperty(value = "division integer")
  public Integer getDivision() {
    return division;
  }

  public void setDivision(Integer division) {
    this.division = division;
  }

  public GetCorporationsCorporationIdDivisionsHangarHangar name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name string
   * @return name
  **/
  @ApiModelProperty(value = "name string")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdDivisionsHangarHangar getCorporationsCorporationIdDivisionsHangarHangar = (GetCorporationsCorporationIdDivisionsHangarHangar) o;
    return Objects.equals(this.division, getCorporationsCorporationIdDivisionsHangarHangar.division) &&
        Objects.equals(this.name, getCorporationsCorporationIdDivisionsHangarHangar.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(division, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdDivisionsHangarHangar {\n");
    
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

