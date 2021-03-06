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
 * service object
 */
@ApiModel(description = "service object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-06-28T23:21:07.436+01:00")
public class GetCorporationsCorporationIdOutpostsOutpostIdService {
  @SerializedName("discount_per_good_standing")
  private Double discountPerGoodStanding = null;

  @SerializedName("minimum_standing")
  private Double minimumStanding = null;

  /**
   * service_name string
   */
  @JsonAdapter(ServiceNameEnum.Adapter.class)
  public enum ServiceNameEnum {
    BOUNTY_MISSIONS("Bounty Missions"),
    
    ASSASSINATION_MISSIONS("Assassination Missions"),
    
    COURIER_MISSIONS("Courier Missions"),
    
    INTERBUS("Interbus"),
    
    REPROCESSING_PLANT("Reprocessing Plant"),
    
    REFINERY("Refinery"),
    
    MARKET("Market"),
    
    BLACK_MARKET("Black Market"),
    
    STOCK_EXCHANGE("Stock Exchange"),
    
    CLONING("Cloning"),
    
    SURGERY("Surgery"),
    
    DNA_THERAPY("DNA Therapy"),
    
    REPAIR_FACILITIES("Repair Facilities"),
    
    FACTORY("Factory"),
    
    LABORATORY("Laboratory"),
    
    GAMBLING("Gambling"),
    
    FITTING("Fitting"),
    
    PAINTSHOP("Paintshop"),
    
    NEWS("News"),
    
    STORAGE("Storage"),
    
    INSURANCE("Insurance"),
    
    DOCKING("Docking"),
    
    OFFICE_RENTAL("Office Rental"),
    
    JUMP_CLONE_FACILITY("Jump Clone Facility"),
    
    LOYALTY_POINT_STORE("Loyalty Point Store"),
    
    NAVY_OFFICES("Navy Offices"),
    
    SECURITY_OFFICE("Security Office");

    private String value;

    ServiceNameEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ServiceNameEnum fromValue(String text) {
      for (ServiceNameEnum b : ServiceNameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ServiceNameEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ServiceNameEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ServiceNameEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ServiceNameEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("service_name")
  private ServiceNameEnum serviceName = null;

  @SerializedName("surcharge_per_bad_standing")
  private Double surchargePerBadStanding = null;

  public GetCorporationsCorporationIdOutpostsOutpostIdService discountPerGoodStanding(Double discountPerGoodStanding) {
    this.discountPerGoodStanding = discountPerGoodStanding;
    return this;
  }

   /**
   * discount_per_good_standing number
   * @return discountPerGoodStanding
  **/
  @ApiModelProperty(required = true, value = "discount_per_good_standing number")
  public Double getDiscountPerGoodStanding() {
    return discountPerGoodStanding;
  }

  public void setDiscountPerGoodStanding(Double discountPerGoodStanding) {
    this.discountPerGoodStanding = discountPerGoodStanding;
  }

  public GetCorporationsCorporationIdOutpostsOutpostIdService minimumStanding(Double minimumStanding) {
    this.minimumStanding = minimumStanding;
    return this;
  }

   /**
   * minimum_standing number
   * @return minimumStanding
  **/
  @ApiModelProperty(required = true, value = "minimum_standing number")
  public Double getMinimumStanding() {
    return minimumStanding;
  }

  public void setMinimumStanding(Double minimumStanding) {
    this.minimumStanding = minimumStanding;
  }

  public GetCorporationsCorporationIdOutpostsOutpostIdService serviceName(ServiceNameEnum serviceName) {
    this.serviceName = serviceName;
    return this;
  }

   /**
   * service_name string
   * @return serviceName
  **/
  @ApiModelProperty(required = true, value = "service_name string")
  public ServiceNameEnum getServiceName() {
    return serviceName;
  }

  public void setServiceName(ServiceNameEnum serviceName) {
    this.serviceName = serviceName;
  }

  public GetCorporationsCorporationIdOutpostsOutpostIdService surchargePerBadStanding(Double surchargePerBadStanding) {
    this.surchargePerBadStanding = surchargePerBadStanding;
    return this;
  }

   /**
   * surcharge_per_bad_standing number
   * @return surchargePerBadStanding
  **/
  @ApiModelProperty(required = true, value = "surcharge_per_bad_standing number")
  public Double getSurchargePerBadStanding() {
    return surchargePerBadStanding;
  }

  public void setSurchargePerBadStanding(Double surchargePerBadStanding) {
    this.surchargePerBadStanding = surchargePerBadStanding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdOutpostsOutpostIdService getCorporationsCorporationIdOutpostsOutpostIdService = (GetCorporationsCorporationIdOutpostsOutpostIdService) o;
    return Objects.equals(this.discountPerGoodStanding, getCorporationsCorporationIdOutpostsOutpostIdService.discountPerGoodStanding) &&
        Objects.equals(this.minimumStanding, getCorporationsCorporationIdOutpostsOutpostIdService.minimumStanding) &&
        Objects.equals(this.serviceName, getCorporationsCorporationIdOutpostsOutpostIdService.serviceName) &&
        Objects.equals(this.surchargePerBadStanding, getCorporationsCorporationIdOutpostsOutpostIdService.surchargePerBadStanding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discountPerGoodStanding, minimumStanding, serviceName, surchargePerBadStanding);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdOutpostsOutpostIdService {\n");
    
    sb.append("    discountPerGoodStanding: ").append(toIndentedString(discountPerGoodStanding)).append("\n");
    sb.append("    minimumStanding: ").append(toIndentedString(minimumStanding)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    surchargePerBadStanding: ").append(toIndentedString(surchargePerBadStanding)).append("\n");
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

