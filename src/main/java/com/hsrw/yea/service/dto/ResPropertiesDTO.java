package com.hsrw.yea.service.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.hsrw.yea.domain.ResProperties} entity.
 */
public class ResPropertiesDTO implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    private Integer communityId;

    @NotNull
    @Size(max = 255)
    private String communityName;

    @NotNull
    private Integer builderId;

    @NotNull
    @Size(max = 255)
    private String specialOffers;

    @NotNull
    @Size(max = 255)
    private String brochure;

    @NotNull
    private Integer floorPlanId;

    @Size(max = 20)
    private String latitude;

    @Size(max = 20)
    private String longitude;

    /**
     * County
     */
    @Size(max = 32)
    @ApiModelProperty(value = "County")
    private String county;

    /**
     * Heating/Cooling
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Heating/Cooling")
    private String heatsystem;

    /**
     * Status
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Status")
    private String liststatus;

    @Size(max = 100)
    private String liststatusflag;

    @Size(max = 100)
    private String carportcap;

    /**
     * Possession
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Possession")
    private String possession;

    /**
     * School 1 Name
     */
    @Size(max = 32)
    @ApiModelProperty(value = "School 1 Name")
    private String schoolname1;

    /**
     * Will Subdivide
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Will Subdivide")
    private String subdivide;

    /**
     * Allow AVM
     */
    @Size(max = 1)
    @ApiModelProperty(value = "Allow AVM")
    private String vowavmyn;

    /**
     * Present Use
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Present Use")
    private String presentuse;

    /**
     * Proposed Use
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Proposed Use")
    private String proposeduse;

    /**
     * Ranch Name
     */
    @Size(max = 15)
    @ApiModelProperty(value = "Ranch Name")
    private String ranchname;

    /**
     * Bedroom 2 Width
     */
    @ApiModelProperty(value = "Bedroom 2 Width")
    private Integer roombed2width;

    /**
     * Formal Dining Level
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Formal Dining Level")
    private String roomdininglevel;

    /**
     * Living 2 Width
     */
    @ApiModelProperty(value = "Living 2 Width")
    private Integer roomliving2width;

    /**
     * Study Level
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Study Level")
    private String roomstudylevel;

    /**
     * Area
     */
    @ApiModelProperty(value = "Area")
    private Integer area;

    @Size(max = 255)
    private String areatitle;

    /**
     * HOA Dues
     */
    @ApiModelProperty(value = "HOA Dues")
    private Integer assocfee;

    /**
     * Proposed Financing
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Proposed Financing")
    private String financeproposed;

    /**
     * Original List Price
     */
    @ApiModelProperty(value = "Original List Price")
    private Integer listpriceorig;

    /**
     * Map Coord
     */
    @Size(max = 5)
    @ApiModelProperty(value = "Map Coord")
    private String mapcoord;

    /**
     * School 2 Name
     */
    @Size(max = 32)
    @ApiModelProperty(value = "School 2 Name")
    private String schoolname2;

    /**
     * Garage Width
     */
    @ApiModelProperty(value = "Garage Width")
    private Integer roomgaragewidth;

    /**
     * Kitchen Other
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Kitchen Other")
    private String roomkitchendesc;

    /**
     * Living 1 Width
     */
    @ApiModelProperty(value = "Living 1 Width")
    private Integer roomliving1width;

    /**
     * Other Room 2 Width
     */
    @ApiModelProperty(value = "Other Room 2 Width")
    private Integer roomother2width;

    /**
     * SqFt
     */
    @ApiModelProperty(value = "SqFt")
    private Integer sqfttotal;

    /**
     * Listing Office Name
     */
    @Size(max = 100)
    @ApiModelProperty(value = "Listing Office Name")
    private String officelistOfficenam1;

    /**
     * School 3 Name
     */
    @Size(max = 32)
    @ApiModelProperty(value = "School 3 Name")
    private String schoolname3;

    /**
     * Zip Code
     */
    @Size(max = 25)
    @ApiModelProperty(value = "Zip Code")
    private String zipcode;

    /**
     * Barn 1 Length
     */
    @ApiModelProperty(value = "Barn 1 Length")
    private Integer barn1length;

    /**
     * Barn 3 Width
     */
    @ApiModelProperty(value = "Barn 3 Width")
    private Integer barn3width;

    /**
     * Bedroom 2 Length
     */
    @ApiModelProperty(value = "Bedroom 2 Length")
    private Integer roombed2length;

    /**
     * Bedroom 3 Length
     */
    @ApiModelProperty(value = "Bedroom 3 Length")
    private Integer roombed3length;

    /**
     * Other Room 1 Width
     */
    @ApiModelProperty(value = "Other Room 1 Width")
    private Integer roomother1width;

    /**
     * Listing Agent Name
     */
    @Size(max = 150)
    @ApiModelProperty(value = "Listing Agent Name")
    private String agentlistFullname;

    /**
     * Property Category
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Property Category")
    private String proptype;

    @NotNull
    @Size(max = 50)
    private String mlsProptype;

    /**
     * School 4 Name
     */
    @Size(max = 32)
    @ApiModelProperty(value = "School 4 Name")
    private String schoolname4;

    /**
     * Cultivated Acres
     */
    @ApiModelProperty(value = "Cultivated Acres")
    private BigDecimal acrescultivated;

    /**
     * Barn 2 Length
     */
    @ApiModelProperty(value = "Barn 2 Length")
    private Integer barn2length;

    /**
     * Barn 2 Width
     */
    @ApiModelProperty(value = "Barn 2 Width")
    private Integer barn2width;

    /**
     * Complex Name
     */
    @Size(max = 25)
    @ApiModelProperty(value = "Complex Name")
    private String complexname;

    /**
     * Bedroom 4 Length
     */
    @ApiModelProperty(value = "Bedroom 4 Length")
    private Integer roombed4length;

    /**
     * Bed/Bath Features
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Bed/Bath Features")
    private String roombedbathdesc;

    /**
     * Breakfast Width
     */
    @ApiModelProperty(value = "Breakfast Width")
    private Integer roombreakfastwidth;

    /**
     * Specialty Rooms
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Specialty Rooms")
    private String roomother;

    /**
     * Utility Length
     */
    @ApiModelProperty(value = "Utility Length")
    private Integer roomutilitylength;

    /**
     * Acres
     */
    @ApiModelProperty(value = "Acres")
    private BigDecimal acres;

    /**
     * Block
     */
    @Size(max = 7)
    @ApiModelProperty(value = "Block")
    private String block;

    /**
     * Directions
     */
    @Size(max = 150)
    @ApiModelProperty(value = "Directions")
    private String directions;

    /**
     * Subdivision
     */
    @Size(max = 40)
    @ApiModelProperty(value = "Subdivision")
    private String subdivision;

    /**
     * Year Built
     */
    @ApiModelProperty(value = "Year Built")
    private Integer yearbuilt;

    @NotNull
    @Size(max = 255)
    private String yearbuiltdetails;

    /**
     * AG Exemption
     */
    @Size(max = 1)
    @ApiModelProperty(value = "AG Exemption")
    private String agexemption;

    /**
     * Barn 1 Width
     */
    @ApiModelProperty(value = "Barn 1 Width")
    private Integer barn1width;

    /**
     * Barn 3 Length
     */
    @ApiModelProperty(value = "Barn 3 Length")
    private Integer barn3length;

    /**
     * Formal Dining Width
     */
    @ApiModelProperty(value = "Formal Dining Width")
    private Integer roomdiningwidth;

    /**
     * Study Width
     */
    @ApiModelProperty(value = "Study Width")
    private Integer roomstudywidth;

    /**
     * Soil
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Soil")
    private String soiltype;

    /**
     * Appraiser's Name
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Appraiser's Name")
    private String appraisername;

    /**
     * Low Price
     */
    @ApiModelProperty(value = "Low Price")
    private Integer listpricelow;

    /**
     * Map Page
     */
    @Size(max = 5)
    @ApiModelProperty(value = "Map Page")
    private String mappage;

    @NotNull
    @Size(max = 20)
    private String unitnumber;

    /**
     * Street Direction
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Street Direction")
    private String streetdir;

    /**
     * Street Type
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Street Type")
    private String streettype;

    /**
     * Sub Area
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Sub Area")
    private String subarea;

    @Size(max = 255)
    private String subareatitle;

    /**
     * # Half Baths
     */
    @ApiModelProperty(value = "# Half Baths")
    private Integer bathshalf;

    /**
     * Garage Length
     */
    @ApiModelProperty(value = "Garage Length")
    private Integer roomgaragelength;

    /**
     * Property Type
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Property Type")
    private String propsubtype;

    /**
     * # Bedrooms
     */
    @ApiModelProperty(value = "# Bedrooms")
    private Integer beds;

    /**
     * Master BR Width
     */
    @ApiModelProperty(value = "Master BR Width")
    private Integer roommasterbedwidth;

    /**
     * Study Length
     */
    @ApiModelProperty(value = "Study Length")
    private Integer roomstudylength;

    /**
     * Listing Agent ID
     */
    @Size(max = 20)
    @ApiModelProperty(value = "Listing Agent ID")
    private String agentlist;

    /**
     * Street Name
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Street Name")
    private String streetname;

    /**
     * Breakfast Length
     */
    @ApiModelProperty(value = "Breakfast Length")
    private Integer roombreakfastlength;

    /**
     * Kitchen Width
     */
    @ApiModelProperty(value = "Kitchen Width")
    private Integer roomkitchenwidth;

    /**
     * Type of Fence
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Type of Fence")
    private String fence;

    /**
     * Total Baths
     */
    @ApiModelProperty(value = "Total Baths")
    private BigDecimal bathstotal;

    /**
     * # Garage Spaces
     */
    @ApiModelProperty(value = "# Garage Spaces")
    private Integer garagecap;

    /**
     * List$/SqFt
     */
    @ApiModelProperty(value = "List$/SqFt")
    private BigDecimal sqftprice;

    /**
     * Style of House
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Style of House")
    private String style;

    /**
     * Exterior Features
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Exterior Features")
    private String exterior;

    /**
     * Foundation
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Foundation")
    private String foundation;

    /**
     * Interior Features
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Interior Features")
    private String interior;

    /**
     * Pool on Property
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Pool on Property")
    private String poolyn;

    @NotNull
    @Size(max = 255)
    private String poolFeature;

    /**
     * List Price
     */
    @ApiModelProperty(value = "List Price")
    private Integer listprice;

    /**
     * Range Pricing
     */
    @Size(max = 1)
    @ApiModelProperty(value = "Range Pricing")
    private String listpricerange;

    /**
     * MLS #
     */
    @NotNull
    @Size(max = 50)
    @ApiModelProperty(value = "MLS #", required = true)
    private String mlsnum;

    @NotNull
    private Integer matrixid;

    /**
     * Property Description
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Property Description")
    private String remarks;

    /**
     * State
     */
    @Size(max = 50)
    @ApiModelProperty(value = "State")
    private String state;

    /**
     * Roof
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Roof")
    private String roof;

    @NotNull
    @Size(max = 255)
    private String securityfeatures;

    @NotNull
    @Size(max = 255)
    private String utilitiesother;

    /**
     * Common Features
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Common Features")
    private String commonfeatures;

    /**
     * Construction
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Construction")
    private String construction;

    /**
     * Modified
     */
    @NotNull
    @ApiModelProperty(value = "Modified", required = true)
    private Instant modified;

    /**
     * # of Stories
     */
    @ApiModelProperty(value = "# of Stories")
    private Integer stories;

    /**
     * Formal Dining Length
     */
    @ApiModelProperty(value = "Formal Dining Length")
    private Integer roomdininglength;

    /**
     * Living 1 Length
     */
    @ApiModelProperty(value = "Living 1 Length")
    private Integer roomliving1length;

    /**
     * Open House Time
     */
    @Size(max = 25)
    @ApiModelProperty(value = "Open House Time")
    private String openhousetime;

    @NotNull
    @Size(max = 25)
    private String openhouseendtime;

    /**
     * Living 2 Length
     */
    @ApiModelProperty(value = "Living 2 Length")
    private Integer roomliving2length;

    /**
     * Lot Description
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Lot Description")
    private String lotdesc;

    /**
     * Open House Date
     */
    @ApiModelProperty(value = "Open House Date")
    private Instant openhousedate;

    /**
     * Master BR Length
     */
    @ApiModelProperty(value = "Master BR Length")
    private Integer roommasterbedlength;

    /**
     * Other Room 1 Length
     */
    @ApiModelProperty(value = "Other Room 1 Length")
    private Integer roomother1length;

    /**
     * Selling Office Name
     */
    @Size(max = 100)
    @ApiModelProperty(value = "Selling Office Name")
    private String officesellOfficenam2;

    /**
     * Lot Size/Acreage
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Lot Size/Acreage")
    private String lotsize;

    /**
     * Street Directional Suffix
     */
    @Size(max = 50)
    @ApiModelProperty(value = "Street Directional Suffix")
    private String streetdirsuffix;

    /**
     * Photo Count
     */
    @ApiModelProperty(value = "Photo Count")
    private Integer photocount;

    /**
     * School District
     */
    @Size(max = 32)
    @ApiModelProperty(value = "School District")
    private String schooldistrict;

    /**
     * Street/Box Number
     */
    @ApiModelProperty(value = "Street/Box Number")
    private Integer streetnum;

    /**
     * Street/Utilities
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Street/Utilities")
    private String utilities;

    /**
     * Kitchen Equipment
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Kitchen Equipment")
    private String equipment;

    /**
     * Bedroom 4 Width
     */
    @ApiModelProperty(value = "Bedroom 4 Width")
    private Integer roombed4width;

    /**
     * Kitchen Length
     */
    @ApiModelProperty(value = "Kitchen Length")
    private Integer roomkitchenlength;

    /**
     * City
     */
    @Size(max = 32)
    @ApiModelProperty(value = "City")
    private String city;

    /**
     * Parking/Garage
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Parking/Garage")
    private String garagedesc;

    /**
     * # Full Baths
     */
    @ApiModelProperty(value = "# Full Baths")
    private Integer bathsfull;

    /**
     * Bedroom 3 Width
     */
    @ApiModelProperty(value = "Bedroom 3 Width")
    private Integer roombed3width;

    /**
     * Utility Room
     */
    @Size(max = 255)
    @ApiModelProperty(value = "Utility Room")
    private String roomutildesc;

    /**
     * Utility Width
     */
    @ApiModelProperty(value = "Utility Width")
    private Integer roomutilitywidth;

    @NotNull
    @Size(max = 10)
    private String roomfullbathlength;

    @NotNull
    @Size(max = 10)
    private String roomfullbathwidth;

    @NotNull
    @Size(max = 10)
    private String roomhalfbathlength;

    @NotNull
    @Size(max = 10)
    private String roomhalfbathwidth;

    @NotNull
    @Size(max = 10)
    private String roomexerciselength;

    @NotNull
    @Size(max = 10)
    private String roomexercisewidth;

    @NotNull
    @Size(max = 10)
    private String roomstoragelength;

    @NotNull
    @Size(max = 10)
    private String roomstoragewidth;

    @NotNull
    @Size(max = 10)
    private String roomgamelength;

    @NotNull
    @Size(max = 10)
    private String roomgamewidth;

    @NotNull
    @Size(max = 10)
    private String roomguestlength;

    @NotNull
    @Size(max = 10)
    private String roomguestwidth;

    @NotNull
    @Size(max = 10)
    private String roomlibrarylength;

    @NotNull
    @Size(max = 10)
    private String roomlibrarywidth;

    @NotNull
    @Size(max = 10)
    private String roommedialength;

    @NotNull
    @Size(max = 10)
    private String roommediawidth;

    @NotNull
    @Size(max = 10)
    private String roommudlength;

    @NotNull
    @Size(max = 10)
    private String roommudwidth;

    @NotNull
    @Size(max = 10)
    private String roomofficelength;

    @NotNull
    @Size(max = 10)
    private String roomofficewidth;

    @NotNull
    @Size(max = 10)
    private String roomsaunalength;

    @NotNull
    @Size(max = 10)
    private String roomsaunawidth;

    @NotNull
    @Size(max = 10)
    private String roomsecondmasterlength;

    @NotNull
    @Size(max = 10)
    private String roomsecondmasterwidth;

    @NotNull
    @Size(max = 10)
    private String roomsunlength;

    @NotNull
    @Size(max = 10)
    private String roomsunwidth;

    @NotNull
    @Size(max = 10)
    private String roomspalength;

    @NotNull
    @Size(max = 10)
    private String roomspawidth;

    @NotNull
    @Size(max = 10)
    private String roomwinelength;

    @NotNull
    @Size(max = 10)
    private String roomwinewidth;

    @NotNull
    @Size(max = 255)
    private String juniorhighschoolname;

    @NotNull
    @Size(max = 255)
    private String primaryschoolname;

    @NotNull
    @Size(max = 255)
    private String seniorhighschoolname;

    @NotNull
    @Size(max = 255)
    private String associationfee;

    @NotNull
    @Size(max = 255)
    private String associationfeefrequency;

    @NotNull
    @Size(max = 255)
    private String constructionmaterials;

    @NotNull
    @Size(max = 255)
    private String heating;

    @NotNull
    @Size(max = 255)
    private String accessoryunittype;

    @NotNull
    @Size(max = 255)
    private String accessoryunityn;

    @NotNull
    @Size(max = 255)
    private String flooring;

    @NotNull
    @Size(max = 255)
    private String fireplacestotal;

    @NotNull
    @Size(max = 255)
    private String fireplacefeatures;

    @NotNull
    @Size(max = 255)
    private String securitysystemyn;

    @NotNull
    @Size(max = 255)
    private String greenbuildingcertification;

    @NotNull
    @Size(max = 255)
    private String greenenergyefficient;

    @NotNull
    @Size(max = 255)
    private String energysavingfeatures;

    @NotNull
    @Size(max = 255)
    private String lotnumber;

    @NotNull
    @Size(max = 255)
    private String lotsizearea;

    @NotNull
    @Size(max = 255)
    private String lotsizedimensions;

    @NotNull
    @Size(max = 255)
    private String easements;

    @NotNull
    @Size(max = 255)
    private String restrictions;

    @NotNull
    @Size(max = 255)
    private String washerdryerconnections;

    @NotNull
    @Size(max = 255)
    private String municipalutilitydistrictyn;

    @NotNull
    @Size(max = 255)
    private String associationfeeincludes;

    @NotNull
    @Size(max = 255)
    private String associationtype;

    @NotNull
    @Size(max = 255)
    private String barninformation;

    @NotNull
    @Size(max = 255)
    private String constructionmaterialswalls;

    @NotNull
    @Size(max = 255)
    private String countyorparish;

    @NotNull
    @Size(max = 255)
    private String exteriorbuildings;

    @NotNull
    @Size(max = 255)
    private String farmranchfeatures;

    @NotNull
    @Size(max = 255)
    private String fencedyardyn;

    @NotNull
    @Size(max = 255)
    private String financingproposed;

    @NotNull
    @Size(max = 255)
    private String handicapyn;

    @NotNull
    @Size(max = 255)
    private String numberoftanksandponds;

    @NotNull
    @Size(max = 255)
    private String parcelnumber;

    @NotNull
    @Size(max = 255)
    private String virtualtoururlunbranded;

    @NotNull
    @Size(max = 255)
    private String livingRoomFeature;

    @NotNull
    @Size(max = 255)
    private String masterBedRoomFeature;

    @NotNull
    @Size(max = 255)
    private String bedRoomFeature;

    @NotNull
    @Size(max = 255)
    private String diningRoomFeature;

    @NotNull
    @Size(max = 255)
    private String kitchenRoomFeature;

    @NotNull
    @Size(max = 255)
    private String breakfastRoomFeature;

    @NotNull
    @Size(max = 255)
    private String studyRoomFeature;

    @NotNull
    @Size(max = 255)
    private String utilityRoomFeature;

    @NotNull
    @Size(max = 255)
    private String fullBathRoomFeature;

    @NotNull
    @Size(max = 255)
    private String halfBathRoomFeature;

    @NotNull
    @Size(max = 255)
    private String exerciseRoomFeature;

    @NotNull
    @Size(max = 255)
    private String extraStorageRoomFeature;

    @NotNull
    @Size(max = 255)
    private String gameRoomFeature;

    @NotNull
    @Size(max = 255)
    private String guestRoomFeature;

    @NotNull
    @Size(max = 255)
    private String libraryRoomFeature;

    @NotNull
    @Size(max = 255)
    private String mediaRoomFeature;

    @NotNull
    @Size(max = 255)
    private String mudRoomFeature;

    @NotNull
    @Size(max = 255)
    private String officeRoomFeature;

    @NotNull
    @Size(max = 255)
    private String saunaRoomFeature;

    @NotNull
    @Size(max = 255)
    private String secondMasterRoomFeature;

    @NotNull
    @Size(max = 255)
    private String sunroomRoomFeature;

    @NotNull
    @Size(max = 255)
    private String spaRoomFeature;

    @NotNull
    @Size(max = 255)
    private String wineRoomFeature;

    @NotNull
    @Size(max = 255)
    private String otherRoomFeature;

    @NotNull
    @Size(max = 5)
    private String isLuxury;

    @NotNull
    @Size(max = 5)
    private String isMoveInReady;

    @Size(max = 255)
    private String photoUrl;

    @NotNull
    @Size(max = 255)
    private String photo1Url;

    @NotNull
    @Size(max = 255)
    private String photo2Url;

    @NotNull
    @Size(max = 255)
    private String photo3Url;

    @NotNull
    @Size(max = 255)
    private String photo4Url;

    @NotNull
    @Size(max = 255)
    private String photo5Url;

    @NotNull
    @Size(max = 255)
    private String photo6Url;

    @NotNull
    @Size(max = 255)
    private String photo7Url;

    @NotNull
    @Size(max = 255)
    private String photo8Url;

    @NotNull
    @Size(max = 255)
    private String photo9Url;

    @NotNull
    @Size(max = 255)
    private String photo10Url;

    @NotNull
    @Size(max = 255)
    private String photo11Url;

    @NotNull
    @Size(max = 255)
    private String photo12Url;

    @NotNull
    @Size(max = 255)
    private String photo13Url;

    @NotNull
    @Size(max = 255)
    private String photo14Url;

    @NotNull
    @Size(max = 255)
    private String photo15Url;

    @NotNull
    @Size(max = 255)
    private String photo16Url;

    @NotNull
    @Size(max = 255)
    private String photo17Url;

    @NotNull
    @Size(max = 255)
    private String photo18Url;

    @NotNull
    @Size(max = 255)
    private String photo19Url;

    @NotNull
    @Size(max = 255)
    private String photo20Url;

    @NotNull
    @Size(max = 255)
    private String photo21Url;

    @NotNull
    @Size(max = 255)
    private String photo22Url;

    @NotNull
    @Size(max = 255)
    private String photo23Url;

    @NotNull
    @Size(max = 255)
    private String photo24Url;

    @NotNull
    @Size(max = 255)
    private String photo25Url;

    @NotNull
    @Size(max = 255)
    private String photo26Url;

    @NotNull
    @Size(max = 255)
    private String photo27Url;

    @NotNull
    @Size(max = 255)
    private String photo28Url;

    @NotNull
    @Size(max = 255)
    private String photo29Url;

    @NotNull
    @Size(max = 255)
    private String photo30Url;

    @NotNull
    @Size(max = 255)
    private String photo31Url;

    @NotNull
    @Size(max = 255)
    private String photo32Url;

    @NotNull
    @Size(max = 255)
    private String photo33Url;

    @NotNull
    @Size(max = 255)
    private String photo34Url;

    @NotNull
    @Size(max = 255)
    private String photo35Url;

    @NotNull
    @Size(max = 255)
    private String photo36Url;

    @NotNull
    @Size(max = 255)
    private String photo37Url;

    @NotNull
    @Size(max = 255)
    private String photo38Url;

    @NotNull
    @Size(max = 255)
    private String photo39Url;

    @NotNull
    @Size(max = 255)
    private String photo40Url;

    private Instant created;

    @NotNull
    private Instant updated;

    @NotNull
    private Instant modifiedDate;

    @NotNull
    private Boolean imgDeleted;

    @Size(max = 100)
    private String retsServer;

    @NotNull
    @Size(max = 255)
    private String permalink;

    @NotNull
    @Size(max = 50)
    private String propertyTag;

    @NotNull
    private Integer buildentoryViews;

    @NotNull
    @Size(max = 1000)
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getBuilderId() {
        return builderId;
    }

    public void setBuilderId(Integer builderId) {
        this.builderId = builderId;
    }

    public String getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(String specialOffers) {
        this.specialOffers = specialOffers;
    }

    public String getBrochure() {
        return brochure;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure;
    }

    public Integer getFloorPlanId() {
        return floorPlanId;
    }

    public void setFloorPlanId(Integer floorPlanId) {
        this.floorPlanId = floorPlanId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHeatsystem() {
        return heatsystem;
    }

    public void setHeatsystem(String heatsystem) {
        this.heatsystem = heatsystem;
    }

    public String getListstatus() {
        return liststatus;
    }

    public void setListstatus(String liststatus) {
        this.liststatus = liststatus;
    }

    public String getListstatusflag() {
        return liststatusflag;
    }

    public void setListstatusflag(String liststatusflag) {
        this.liststatusflag = liststatusflag;
    }

    public String getCarportcap() {
        return carportcap;
    }

    public void setCarportcap(String carportcap) {
        this.carportcap = carportcap;
    }

    public String getPossession() {
        return possession;
    }

    public void setPossession(String possession) {
        this.possession = possession;
    }

    public String getSchoolname1() {
        return schoolname1;
    }

    public void setSchoolname1(String schoolname1) {
        this.schoolname1 = schoolname1;
    }

    public String getSubdivide() {
        return subdivide;
    }

    public void setSubdivide(String subdivide) {
        this.subdivide = subdivide;
    }

    public String getVowavmyn() {
        return vowavmyn;
    }

    public void setVowavmyn(String vowavmyn) {
        this.vowavmyn = vowavmyn;
    }

    public String getPresentuse() {
        return presentuse;
    }

    public void setPresentuse(String presentuse) {
        this.presentuse = presentuse;
    }

    public String getProposeduse() {
        return proposeduse;
    }

    public void setProposeduse(String proposeduse) {
        this.proposeduse = proposeduse;
    }

    public String getRanchname() {
        return ranchname;
    }

    public void setRanchname(String ranchname) {
        this.ranchname = ranchname;
    }

    public Integer getRoombed2width() {
        return roombed2width;
    }

    public void setRoombed2width(Integer roombed2width) {
        this.roombed2width = roombed2width;
    }

    public String getRoomdininglevel() {
        return roomdininglevel;
    }

    public void setRoomdininglevel(String roomdininglevel) {
        this.roomdininglevel = roomdininglevel;
    }

    public Integer getRoomliving2width() {
        return roomliving2width;
    }

    public void setRoomliving2width(Integer roomliving2width) {
        this.roomliving2width = roomliving2width;
    }

    public String getRoomstudylevel() {
        return roomstudylevel;
    }

    public void setRoomstudylevel(String roomstudylevel) {
        this.roomstudylevel = roomstudylevel;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreatitle() {
        return areatitle;
    }

    public void setAreatitle(String areatitle) {
        this.areatitle = areatitle;
    }

    public Integer getAssocfee() {
        return assocfee;
    }

    public void setAssocfee(Integer assocfee) {
        this.assocfee = assocfee;
    }

    public String getFinanceproposed() {
        return financeproposed;
    }

    public void setFinanceproposed(String financeproposed) {
        this.financeproposed = financeproposed;
    }

    public Integer getListpriceorig() {
        return listpriceorig;
    }

    public void setListpriceorig(Integer listpriceorig) {
        this.listpriceorig = listpriceorig;
    }

    public String getMapcoord() {
        return mapcoord;
    }

    public void setMapcoord(String mapcoord) {
        this.mapcoord = mapcoord;
    }

    public String getSchoolname2() {
        return schoolname2;
    }

    public void setSchoolname2(String schoolname2) {
        this.schoolname2 = schoolname2;
    }

    public Integer getRoomgaragewidth() {
        return roomgaragewidth;
    }

    public void setRoomgaragewidth(Integer roomgaragewidth) {
        this.roomgaragewidth = roomgaragewidth;
    }

    public String getRoomkitchendesc() {
        return roomkitchendesc;
    }

    public void setRoomkitchendesc(String roomkitchendesc) {
        this.roomkitchendesc = roomkitchendesc;
    }

    public Integer getRoomliving1width() {
        return roomliving1width;
    }

    public void setRoomliving1width(Integer roomliving1width) {
        this.roomliving1width = roomliving1width;
    }

    public Integer getRoomother2width() {
        return roomother2width;
    }

    public void setRoomother2width(Integer roomother2width) {
        this.roomother2width = roomother2width;
    }

    public Integer getSqfttotal() {
        return sqfttotal;
    }

    public void setSqfttotal(Integer sqfttotal) {
        this.sqfttotal = sqfttotal;
    }

    public String getOfficelistOfficenam1() {
        return officelistOfficenam1;
    }

    public void setOfficelistOfficenam1(String officelistOfficenam1) {
        this.officelistOfficenam1 = officelistOfficenam1;
    }

    public String getSchoolname3() {
        return schoolname3;
    }

    public void setSchoolname3(String schoolname3) {
        this.schoolname3 = schoolname3;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getBarn1length() {
        return barn1length;
    }

    public void setBarn1length(Integer barn1length) {
        this.barn1length = barn1length;
    }

    public Integer getBarn3width() {
        return barn3width;
    }

    public void setBarn3width(Integer barn3width) {
        this.barn3width = barn3width;
    }

    public Integer getRoombed2length() {
        return roombed2length;
    }

    public void setRoombed2length(Integer roombed2length) {
        this.roombed2length = roombed2length;
    }

    public Integer getRoombed3length() {
        return roombed3length;
    }

    public void setRoombed3length(Integer roombed3length) {
        this.roombed3length = roombed3length;
    }

    public Integer getRoomother1width() {
        return roomother1width;
    }

    public void setRoomother1width(Integer roomother1width) {
        this.roomother1width = roomother1width;
    }

    public String getAgentlistFullname() {
        return agentlistFullname;
    }

    public void setAgentlistFullname(String agentlistFullname) {
        this.agentlistFullname = agentlistFullname;
    }

    public String getProptype() {
        return proptype;
    }

    public void setProptype(String proptype) {
        this.proptype = proptype;
    }

    public String getMlsProptype() {
        return mlsProptype;
    }

    public void setMlsProptype(String mlsProptype) {
        this.mlsProptype = mlsProptype;
    }

    public String getSchoolname4() {
        return schoolname4;
    }

    public void setSchoolname4(String schoolname4) {
        this.schoolname4 = schoolname4;
    }

    public BigDecimal getAcrescultivated() {
        return acrescultivated;
    }

    public void setAcrescultivated(BigDecimal acrescultivated) {
        this.acrescultivated = acrescultivated;
    }

    public Integer getBarn2length() {
        return barn2length;
    }

    public void setBarn2length(Integer barn2length) {
        this.barn2length = barn2length;
    }

    public Integer getBarn2width() {
        return barn2width;
    }

    public void setBarn2width(Integer barn2width) {
        this.barn2width = barn2width;
    }

    public String getComplexname() {
        return complexname;
    }

    public void setComplexname(String complexname) {
        this.complexname = complexname;
    }

    public Integer getRoombed4length() {
        return roombed4length;
    }

    public void setRoombed4length(Integer roombed4length) {
        this.roombed4length = roombed4length;
    }

    public String getRoombedbathdesc() {
        return roombedbathdesc;
    }

    public void setRoombedbathdesc(String roombedbathdesc) {
        this.roombedbathdesc = roombedbathdesc;
    }

    public Integer getRoombreakfastwidth() {
        return roombreakfastwidth;
    }

    public void setRoombreakfastwidth(Integer roombreakfastwidth) {
        this.roombreakfastwidth = roombreakfastwidth;
    }

    public String getRoomother() {
        return roomother;
    }

    public void setRoomother(String roomother) {
        this.roomother = roomother;
    }

    public Integer getRoomutilitylength() {
        return roomutilitylength;
    }

    public void setRoomutilitylength(Integer roomutilitylength) {
        this.roomutilitylength = roomutilitylength;
    }

    public BigDecimal getAcres() {
        return acres;
    }

    public void setAcres(BigDecimal acres) {
        this.acres = acres;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public Integer getYearbuilt() {
        return yearbuilt;
    }

    public void setYearbuilt(Integer yearbuilt) {
        this.yearbuilt = yearbuilt;
    }

    public String getYearbuiltdetails() {
        return yearbuiltdetails;
    }

    public void setYearbuiltdetails(String yearbuiltdetails) {
        this.yearbuiltdetails = yearbuiltdetails;
    }

    public String getAgexemption() {
        return agexemption;
    }

    public void setAgexemption(String agexemption) {
        this.agexemption = agexemption;
    }

    public Integer getBarn1width() {
        return barn1width;
    }

    public void setBarn1width(Integer barn1width) {
        this.barn1width = barn1width;
    }

    public Integer getBarn3length() {
        return barn3length;
    }

    public void setBarn3length(Integer barn3length) {
        this.barn3length = barn3length;
    }

    public Integer getRoomdiningwidth() {
        return roomdiningwidth;
    }

    public void setRoomdiningwidth(Integer roomdiningwidth) {
        this.roomdiningwidth = roomdiningwidth;
    }

    public Integer getRoomstudywidth() {
        return roomstudywidth;
    }

    public void setRoomstudywidth(Integer roomstudywidth) {
        this.roomstudywidth = roomstudywidth;
    }

    public String getSoiltype() {
        return soiltype;
    }

    public void setSoiltype(String soiltype) {
        this.soiltype = soiltype;
    }

    public String getAppraisername() {
        return appraisername;
    }

    public void setAppraisername(String appraisername) {
        this.appraisername = appraisername;
    }

    public Integer getListpricelow() {
        return listpricelow;
    }

    public void setListpricelow(Integer listpricelow) {
        this.listpricelow = listpricelow;
    }

    public String getMappage() {
        return mappage;
    }

    public void setMappage(String mappage) {
        this.mappage = mappage;
    }

    public String getUnitnumber() {
        return unitnumber;
    }

    public void setUnitnumber(String unitnumber) {
        this.unitnumber = unitnumber;
    }

    public String getStreetdir() {
        return streetdir;
    }

    public void setStreetdir(String streetdir) {
        this.streetdir = streetdir;
    }

    public String getStreettype() {
        return streettype;
    }

    public void setStreettype(String streettype) {
        this.streettype = streettype;
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public String getSubareatitle() {
        return subareatitle;
    }

    public void setSubareatitle(String subareatitle) {
        this.subareatitle = subareatitle;
    }

    public Integer getBathshalf() {
        return bathshalf;
    }

    public void setBathshalf(Integer bathshalf) {
        this.bathshalf = bathshalf;
    }

    public Integer getRoomgaragelength() {
        return roomgaragelength;
    }

    public void setRoomgaragelength(Integer roomgaragelength) {
        this.roomgaragelength = roomgaragelength;
    }

    public String getPropsubtype() {
        return propsubtype;
    }

    public void setPropsubtype(String propsubtype) {
        this.propsubtype = propsubtype;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getRoommasterbedwidth() {
        return roommasterbedwidth;
    }

    public void setRoommasterbedwidth(Integer roommasterbedwidth) {
        this.roommasterbedwidth = roommasterbedwidth;
    }

    public Integer getRoomstudylength() {
        return roomstudylength;
    }

    public void setRoomstudylength(Integer roomstudylength) {
        this.roomstudylength = roomstudylength;
    }

    public String getAgentlist() {
        return agentlist;
    }

    public void setAgentlist(String agentlist) {
        this.agentlist = agentlist;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public Integer getRoombreakfastlength() {
        return roombreakfastlength;
    }

    public void setRoombreakfastlength(Integer roombreakfastlength) {
        this.roombreakfastlength = roombreakfastlength;
    }

    public Integer getRoomkitchenwidth() {
        return roomkitchenwidth;
    }

    public void setRoomkitchenwidth(Integer roomkitchenwidth) {
        this.roomkitchenwidth = roomkitchenwidth;
    }

    public String getFence() {
        return fence;
    }

    public void setFence(String fence) {
        this.fence = fence;
    }

    public BigDecimal getBathstotal() {
        return bathstotal;
    }

    public void setBathstotal(BigDecimal bathstotal) {
        this.bathstotal = bathstotal;
    }

    public Integer getGaragecap() {
        return garagecap;
    }

    public void setGaragecap(Integer garagecap) {
        this.garagecap = garagecap;
    }

    public BigDecimal getSqftprice() {
        return sqftprice;
    }

    public void setSqftprice(BigDecimal sqftprice) {
        this.sqftprice = sqftprice;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPoolyn() {
        return poolyn;
    }

    public void setPoolyn(String poolyn) {
        this.poolyn = poolyn;
    }

    public String getPoolFeature() {
        return poolFeature;
    }

    public void setPoolFeature(String poolFeature) {
        this.poolFeature = poolFeature;
    }

    public Integer getListprice() {
        return listprice;
    }

    public void setListprice(Integer listprice) {
        this.listprice = listprice;
    }

    public String getListpricerange() {
        return listpricerange;
    }

    public void setListpricerange(String listpricerange) {
        this.listpricerange = listpricerange;
    }

    public String getMlsnum() {
        return mlsnum;
    }

    public void setMlsnum(String mlsnum) {
        this.mlsnum = mlsnum;
    }

    public Integer getMatrixid() {
        return matrixid;
    }

    public void setMatrixid(Integer matrixid) {
        this.matrixid = matrixid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getSecurityfeatures() {
        return securityfeatures;
    }

    public void setSecurityfeatures(String securityfeatures) {
        this.securityfeatures = securityfeatures;
    }

    public String getUtilitiesother() {
        return utilitiesother;
    }

    public void setUtilitiesother(String utilitiesother) {
        this.utilitiesother = utilitiesother;
    }

    public String getCommonfeatures() {
        return commonfeatures;
    }

    public void setCommonfeatures(String commonfeatures) {
        this.commonfeatures = commonfeatures;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public Integer getStories() {
        return stories;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public Integer getRoomdininglength() {
        return roomdininglength;
    }

    public void setRoomdininglength(Integer roomdininglength) {
        this.roomdininglength = roomdininglength;
    }

    public Integer getRoomliving1length() {
        return roomliving1length;
    }

    public void setRoomliving1length(Integer roomliving1length) {
        this.roomliving1length = roomliving1length;
    }

    public String getOpenhousetime() {
        return openhousetime;
    }

    public void setOpenhousetime(String openhousetime) {
        this.openhousetime = openhousetime;
    }

    public String getOpenhouseendtime() {
        return openhouseendtime;
    }

    public void setOpenhouseendtime(String openhouseendtime) {
        this.openhouseendtime = openhouseendtime;
    }

    public Integer getRoomliving2length() {
        return roomliving2length;
    }

    public void setRoomliving2length(Integer roomliving2length) {
        this.roomliving2length = roomliving2length;
    }

    public String getLotdesc() {
        return lotdesc;
    }

    public void setLotdesc(String lotdesc) {
        this.lotdesc = lotdesc;
    }

    public Instant getOpenhousedate() {
        return openhousedate;
    }

    public void setOpenhousedate(Instant openhousedate) {
        this.openhousedate = openhousedate;
    }

    public Integer getRoommasterbedlength() {
        return roommasterbedlength;
    }

    public void setRoommasterbedlength(Integer roommasterbedlength) {
        this.roommasterbedlength = roommasterbedlength;
    }

    public Integer getRoomother1length() {
        return roomother1length;
    }

    public void setRoomother1length(Integer roomother1length) {
        this.roomother1length = roomother1length;
    }

    public String getOfficesellOfficenam2() {
        return officesellOfficenam2;
    }

    public void setOfficesellOfficenam2(String officesellOfficenam2) {
        this.officesellOfficenam2 = officesellOfficenam2;
    }

    public String getLotsize() {
        return lotsize;
    }

    public void setLotsize(String lotsize) {
        this.lotsize = lotsize;
    }

    public String getStreetdirsuffix() {
        return streetdirsuffix;
    }

    public void setStreetdirsuffix(String streetdirsuffix) {
        this.streetdirsuffix = streetdirsuffix;
    }

    public Integer getPhotocount() {
        return photocount;
    }

    public void setPhotocount(Integer photocount) {
        this.photocount = photocount;
    }

    public String getSchooldistrict() {
        return schooldistrict;
    }

    public void setSchooldistrict(String schooldistrict) {
        this.schooldistrict = schooldistrict;
    }

    public Integer getStreetnum() {
        return streetnum;
    }

    public void setStreetnum(Integer streetnum) {
        this.streetnum = streetnum;
    }

    public String getUtilities() {
        return utilities;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getRoombed4width() {
        return roombed4width;
    }

    public void setRoombed4width(Integer roombed4width) {
        this.roombed4width = roombed4width;
    }

    public Integer getRoomkitchenlength() {
        return roomkitchenlength;
    }

    public void setRoomkitchenlength(Integer roomkitchenlength) {
        this.roomkitchenlength = roomkitchenlength;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGaragedesc() {
        return garagedesc;
    }

    public void setGaragedesc(String garagedesc) {
        this.garagedesc = garagedesc;
    }

    public Integer getBathsfull() {
        return bathsfull;
    }

    public void setBathsfull(Integer bathsfull) {
        this.bathsfull = bathsfull;
    }

    public Integer getRoombed3width() {
        return roombed3width;
    }

    public void setRoombed3width(Integer roombed3width) {
        this.roombed3width = roombed3width;
    }

    public String getRoomutildesc() {
        return roomutildesc;
    }

    public void setRoomutildesc(String roomutildesc) {
        this.roomutildesc = roomutildesc;
    }

    public Integer getRoomutilitywidth() {
        return roomutilitywidth;
    }

    public void setRoomutilitywidth(Integer roomutilitywidth) {
        this.roomutilitywidth = roomutilitywidth;
    }

    public String getRoomfullbathlength() {
        return roomfullbathlength;
    }

    public void setRoomfullbathlength(String roomfullbathlength) {
        this.roomfullbathlength = roomfullbathlength;
    }

    public String getRoomfullbathwidth() {
        return roomfullbathwidth;
    }

    public void setRoomfullbathwidth(String roomfullbathwidth) {
        this.roomfullbathwidth = roomfullbathwidth;
    }

    public String getRoomhalfbathlength() {
        return roomhalfbathlength;
    }

    public void setRoomhalfbathlength(String roomhalfbathlength) {
        this.roomhalfbathlength = roomhalfbathlength;
    }

    public String getRoomhalfbathwidth() {
        return roomhalfbathwidth;
    }

    public void setRoomhalfbathwidth(String roomhalfbathwidth) {
        this.roomhalfbathwidth = roomhalfbathwidth;
    }

    public String getRoomexerciselength() {
        return roomexerciselength;
    }

    public void setRoomexerciselength(String roomexerciselength) {
        this.roomexerciselength = roomexerciselength;
    }

    public String getRoomexercisewidth() {
        return roomexercisewidth;
    }

    public void setRoomexercisewidth(String roomexercisewidth) {
        this.roomexercisewidth = roomexercisewidth;
    }

    public String getRoomstoragelength() {
        return roomstoragelength;
    }

    public void setRoomstoragelength(String roomstoragelength) {
        this.roomstoragelength = roomstoragelength;
    }

    public String getRoomstoragewidth() {
        return roomstoragewidth;
    }

    public void setRoomstoragewidth(String roomstoragewidth) {
        this.roomstoragewidth = roomstoragewidth;
    }

    public String getRoomgamelength() {
        return roomgamelength;
    }

    public void setRoomgamelength(String roomgamelength) {
        this.roomgamelength = roomgamelength;
    }

    public String getRoomgamewidth() {
        return roomgamewidth;
    }

    public void setRoomgamewidth(String roomgamewidth) {
        this.roomgamewidth = roomgamewidth;
    }

    public String getRoomguestlength() {
        return roomguestlength;
    }

    public void setRoomguestlength(String roomguestlength) {
        this.roomguestlength = roomguestlength;
    }

    public String getRoomguestwidth() {
        return roomguestwidth;
    }

    public void setRoomguestwidth(String roomguestwidth) {
        this.roomguestwidth = roomguestwidth;
    }

    public String getRoomlibrarylength() {
        return roomlibrarylength;
    }

    public void setRoomlibrarylength(String roomlibrarylength) {
        this.roomlibrarylength = roomlibrarylength;
    }

    public String getRoomlibrarywidth() {
        return roomlibrarywidth;
    }

    public void setRoomlibrarywidth(String roomlibrarywidth) {
        this.roomlibrarywidth = roomlibrarywidth;
    }

    public String getRoommedialength() {
        return roommedialength;
    }

    public void setRoommedialength(String roommedialength) {
        this.roommedialength = roommedialength;
    }

    public String getRoommediawidth() {
        return roommediawidth;
    }

    public void setRoommediawidth(String roommediawidth) {
        this.roommediawidth = roommediawidth;
    }

    public String getRoommudlength() {
        return roommudlength;
    }

    public void setRoommudlength(String roommudlength) {
        this.roommudlength = roommudlength;
    }

    public String getRoommudwidth() {
        return roommudwidth;
    }

    public void setRoommudwidth(String roommudwidth) {
        this.roommudwidth = roommudwidth;
    }

    public String getRoomofficelength() {
        return roomofficelength;
    }

    public void setRoomofficelength(String roomofficelength) {
        this.roomofficelength = roomofficelength;
    }

    public String getRoomofficewidth() {
        return roomofficewidth;
    }

    public void setRoomofficewidth(String roomofficewidth) {
        this.roomofficewidth = roomofficewidth;
    }

    public String getRoomsaunalength() {
        return roomsaunalength;
    }

    public void setRoomsaunalength(String roomsaunalength) {
        this.roomsaunalength = roomsaunalength;
    }

    public String getRoomsaunawidth() {
        return roomsaunawidth;
    }

    public void setRoomsaunawidth(String roomsaunawidth) {
        this.roomsaunawidth = roomsaunawidth;
    }

    public String getRoomsecondmasterlength() {
        return roomsecondmasterlength;
    }

    public void setRoomsecondmasterlength(String roomsecondmasterlength) {
        this.roomsecondmasterlength = roomsecondmasterlength;
    }

    public String getRoomsecondmasterwidth() {
        return roomsecondmasterwidth;
    }

    public void setRoomsecondmasterwidth(String roomsecondmasterwidth) {
        this.roomsecondmasterwidth = roomsecondmasterwidth;
    }

    public String getRoomsunlength() {
        return roomsunlength;
    }

    public void setRoomsunlength(String roomsunlength) {
        this.roomsunlength = roomsunlength;
    }

    public String getRoomsunwidth() {
        return roomsunwidth;
    }

    public void setRoomsunwidth(String roomsunwidth) {
        this.roomsunwidth = roomsunwidth;
    }

    public String getRoomspalength() {
        return roomspalength;
    }

    public void setRoomspalength(String roomspalength) {
        this.roomspalength = roomspalength;
    }

    public String getRoomspawidth() {
        return roomspawidth;
    }

    public void setRoomspawidth(String roomspawidth) {
        this.roomspawidth = roomspawidth;
    }

    public String getRoomwinelength() {
        return roomwinelength;
    }

    public void setRoomwinelength(String roomwinelength) {
        this.roomwinelength = roomwinelength;
    }

    public String getRoomwinewidth() {
        return roomwinewidth;
    }

    public void setRoomwinewidth(String roomwinewidth) {
        this.roomwinewidth = roomwinewidth;
    }

    public String getJuniorhighschoolname() {
        return juniorhighschoolname;
    }

    public void setJuniorhighschoolname(String juniorhighschoolname) {
        this.juniorhighschoolname = juniorhighschoolname;
    }

    public String getPrimaryschoolname() {
        return primaryschoolname;
    }

    public void setPrimaryschoolname(String primaryschoolname) {
        this.primaryschoolname = primaryschoolname;
    }

    public String getSeniorhighschoolname() {
        return seniorhighschoolname;
    }

    public void setSeniorhighschoolname(String seniorhighschoolname) {
        this.seniorhighschoolname = seniorhighschoolname;
    }

    public String getAssociationfee() {
        return associationfee;
    }

    public void setAssociationfee(String associationfee) {
        this.associationfee = associationfee;
    }

    public String getAssociationfeefrequency() {
        return associationfeefrequency;
    }

    public void setAssociationfeefrequency(String associationfeefrequency) {
        this.associationfeefrequency = associationfeefrequency;
    }

    public String getConstructionmaterials() {
        return constructionmaterials;
    }

    public void setConstructionmaterials(String constructionmaterials) {
        this.constructionmaterials = constructionmaterials;
    }

    public String getHeating() {
        return heating;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public String getAccessoryunittype() {
        return accessoryunittype;
    }

    public void setAccessoryunittype(String accessoryunittype) {
        this.accessoryunittype = accessoryunittype;
    }

    public String getAccessoryunityn() {
        return accessoryunityn;
    }

    public void setAccessoryunityn(String accessoryunityn) {
        this.accessoryunityn = accessoryunityn;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getFireplacestotal() {
        return fireplacestotal;
    }

    public void setFireplacestotal(String fireplacestotal) {
        this.fireplacestotal = fireplacestotal;
    }

    public String getFireplacefeatures() {
        return fireplacefeatures;
    }

    public void setFireplacefeatures(String fireplacefeatures) {
        this.fireplacefeatures = fireplacefeatures;
    }

    public String getSecuritysystemyn() {
        return securitysystemyn;
    }

    public void setSecuritysystemyn(String securitysystemyn) {
        this.securitysystemyn = securitysystemyn;
    }

    public String getGreenbuildingcertification() {
        return greenbuildingcertification;
    }

    public void setGreenbuildingcertification(String greenbuildingcertification) {
        this.greenbuildingcertification = greenbuildingcertification;
    }

    public String getGreenenergyefficient() {
        return greenenergyefficient;
    }

    public void setGreenenergyefficient(String greenenergyefficient) {
        this.greenenergyefficient = greenenergyefficient;
    }

    public String getEnergysavingfeatures() {
        return energysavingfeatures;
    }

    public void setEnergysavingfeatures(String energysavingfeatures) {
        this.energysavingfeatures = energysavingfeatures;
    }

    public String getLotnumber() {
        return lotnumber;
    }

    public void setLotnumber(String lotnumber) {
        this.lotnumber = lotnumber;
    }

    public String getLotsizearea() {
        return lotsizearea;
    }

    public void setLotsizearea(String lotsizearea) {
        this.lotsizearea = lotsizearea;
    }

    public String getLotsizedimensions() {
        return lotsizedimensions;
    }

    public void setLotsizedimensions(String lotsizedimensions) {
        this.lotsizedimensions = lotsizedimensions;
    }

    public String getEasements() {
        return easements;
    }

    public void setEasements(String easements) {
        this.easements = easements;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getWasherdryerconnections() {
        return washerdryerconnections;
    }

    public void setWasherdryerconnections(String washerdryerconnections) {
        this.washerdryerconnections = washerdryerconnections;
    }

    public String getMunicipalutilitydistrictyn() {
        return municipalutilitydistrictyn;
    }

    public void setMunicipalutilitydistrictyn(String municipalutilitydistrictyn) {
        this.municipalutilitydistrictyn = municipalutilitydistrictyn;
    }

    public String getAssociationfeeincludes() {
        return associationfeeincludes;
    }

    public void setAssociationfeeincludes(String associationfeeincludes) {
        this.associationfeeincludes = associationfeeincludes;
    }

    public String getAssociationtype() {
        return associationtype;
    }

    public void setAssociationtype(String associationtype) {
        this.associationtype = associationtype;
    }

    public String getBarninformation() {
        return barninformation;
    }

    public void setBarninformation(String barninformation) {
        this.barninformation = barninformation;
    }

    public String getConstructionmaterialswalls() {
        return constructionmaterialswalls;
    }

    public void setConstructionmaterialswalls(String constructionmaterialswalls) {
        this.constructionmaterialswalls = constructionmaterialswalls;
    }

    public String getCountyorparish() {
        return countyorparish;
    }

    public void setCountyorparish(String countyorparish) {
        this.countyorparish = countyorparish;
    }

    public String getExteriorbuildings() {
        return exteriorbuildings;
    }

    public void setExteriorbuildings(String exteriorbuildings) {
        this.exteriorbuildings = exteriorbuildings;
    }

    public String getFarmranchfeatures() {
        return farmranchfeatures;
    }

    public void setFarmranchfeatures(String farmranchfeatures) {
        this.farmranchfeatures = farmranchfeatures;
    }

    public String getFencedyardyn() {
        return fencedyardyn;
    }

    public void setFencedyardyn(String fencedyardyn) {
        this.fencedyardyn = fencedyardyn;
    }

    public String getFinancingproposed() {
        return financingproposed;
    }

    public void setFinancingproposed(String financingproposed) {
        this.financingproposed = financingproposed;
    }

    public String getHandicapyn() {
        return handicapyn;
    }

    public void setHandicapyn(String handicapyn) {
        this.handicapyn = handicapyn;
    }

    public String getNumberoftanksandponds() {
        return numberoftanksandponds;
    }

    public void setNumberoftanksandponds(String numberoftanksandponds) {
        this.numberoftanksandponds = numberoftanksandponds;
    }

    public String getParcelnumber() {
        return parcelnumber;
    }

    public void setParcelnumber(String parcelnumber) {
        this.parcelnumber = parcelnumber;
    }

    public String getVirtualtoururlunbranded() {
        return virtualtoururlunbranded;
    }

    public void setVirtualtoururlunbranded(String virtualtoururlunbranded) {
        this.virtualtoururlunbranded = virtualtoururlunbranded;
    }

    public String getLivingRoomFeature() {
        return livingRoomFeature;
    }

    public void setLivingRoomFeature(String livingRoomFeature) {
        this.livingRoomFeature = livingRoomFeature;
    }

    public String getMasterBedRoomFeature() {
        return masterBedRoomFeature;
    }

    public void setMasterBedRoomFeature(String masterBedRoomFeature) {
        this.masterBedRoomFeature = masterBedRoomFeature;
    }

    public String getBedRoomFeature() {
        return bedRoomFeature;
    }

    public void setBedRoomFeature(String bedRoomFeature) {
        this.bedRoomFeature = bedRoomFeature;
    }

    public String getDiningRoomFeature() {
        return diningRoomFeature;
    }

    public void setDiningRoomFeature(String diningRoomFeature) {
        this.diningRoomFeature = diningRoomFeature;
    }

    public String getKitchenRoomFeature() {
        return kitchenRoomFeature;
    }

    public void setKitchenRoomFeature(String kitchenRoomFeature) {
        this.kitchenRoomFeature = kitchenRoomFeature;
    }

    public String getBreakfastRoomFeature() {
        return breakfastRoomFeature;
    }

    public void setBreakfastRoomFeature(String breakfastRoomFeature) {
        this.breakfastRoomFeature = breakfastRoomFeature;
    }

    public String getStudyRoomFeature() {
        return studyRoomFeature;
    }

    public void setStudyRoomFeature(String studyRoomFeature) {
        this.studyRoomFeature = studyRoomFeature;
    }

    public String getUtilityRoomFeature() {
        return utilityRoomFeature;
    }

    public void setUtilityRoomFeature(String utilityRoomFeature) {
        this.utilityRoomFeature = utilityRoomFeature;
    }

    public String getFullBathRoomFeature() {
        return fullBathRoomFeature;
    }

    public void setFullBathRoomFeature(String fullBathRoomFeature) {
        this.fullBathRoomFeature = fullBathRoomFeature;
    }

    public String getHalfBathRoomFeature() {
        return halfBathRoomFeature;
    }

    public void setHalfBathRoomFeature(String halfBathRoomFeature) {
        this.halfBathRoomFeature = halfBathRoomFeature;
    }

    public String getExerciseRoomFeature() {
        return exerciseRoomFeature;
    }

    public void setExerciseRoomFeature(String exerciseRoomFeature) {
        this.exerciseRoomFeature = exerciseRoomFeature;
    }

    public String getExtraStorageRoomFeature() {
        return extraStorageRoomFeature;
    }

    public void setExtraStorageRoomFeature(String extraStorageRoomFeature) {
        this.extraStorageRoomFeature = extraStorageRoomFeature;
    }

    public String getGameRoomFeature() {
        return gameRoomFeature;
    }

    public void setGameRoomFeature(String gameRoomFeature) {
        this.gameRoomFeature = gameRoomFeature;
    }

    public String getGuestRoomFeature() {
        return guestRoomFeature;
    }

    public void setGuestRoomFeature(String guestRoomFeature) {
        this.guestRoomFeature = guestRoomFeature;
    }

    public String getLibraryRoomFeature() {
        return libraryRoomFeature;
    }

    public void setLibraryRoomFeature(String libraryRoomFeature) {
        this.libraryRoomFeature = libraryRoomFeature;
    }

    public String getMediaRoomFeature() {
        return mediaRoomFeature;
    }

    public void setMediaRoomFeature(String mediaRoomFeature) {
        this.mediaRoomFeature = mediaRoomFeature;
    }

    public String getMudRoomFeature() {
        return mudRoomFeature;
    }

    public void setMudRoomFeature(String mudRoomFeature) {
        this.mudRoomFeature = mudRoomFeature;
    }

    public String getOfficeRoomFeature() {
        return officeRoomFeature;
    }

    public void setOfficeRoomFeature(String officeRoomFeature) {
        this.officeRoomFeature = officeRoomFeature;
    }

    public String getSaunaRoomFeature() {
        return saunaRoomFeature;
    }

    public void setSaunaRoomFeature(String saunaRoomFeature) {
        this.saunaRoomFeature = saunaRoomFeature;
    }

    public String getSecondMasterRoomFeature() {
        return secondMasterRoomFeature;
    }

    public void setSecondMasterRoomFeature(String secondMasterRoomFeature) {
        this.secondMasterRoomFeature = secondMasterRoomFeature;
    }

    public String getSunroomRoomFeature() {
        return sunroomRoomFeature;
    }

    public void setSunroomRoomFeature(String sunroomRoomFeature) {
        this.sunroomRoomFeature = sunroomRoomFeature;
    }

    public String getSpaRoomFeature() {
        return spaRoomFeature;
    }

    public void setSpaRoomFeature(String spaRoomFeature) {
        this.spaRoomFeature = spaRoomFeature;
    }

    public String getWineRoomFeature() {
        return wineRoomFeature;
    }

    public void setWineRoomFeature(String wineRoomFeature) {
        this.wineRoomFeature = wineRoomFeature;
    }

    public String getOtherRoomFeature() {
        return otherRoomFeature;
    }

    public void setOtherRoomFeature(String otherRoomFeature) {
        this.otherRoomFeature = otherRoomFeature;
    }

    public String getIsLuxury() {
        return isLuxury;
    }

    public void setIsLuxury(String isLuxury) {
        this.isLuxury = isLuxury;
    }

    public String getIsMoveInReady() {
        return isMoveInReady;
    }

    public void setIsMoveInReady(String isMoveInReady) {
        this.isMoveInReady = isMoveInReady;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhoto1Url() {
        return photo1Url;
    }

    public void setPhoto1Url(String photo1Url) {
        this.photo1Url = photo1Url;
    }

    public String getPhoto2Url() {
        return photo2Url;
    }

    public void setPhoto2Url(String photo2Url) {
        this.photo2Url = photo2Url;
    }

    public String getPhoto3Url() {
        return photo3Url;
    }

    public void setPhoto3Url(String photo3Url) {
        this.photo3Url = photo3Url;
    }

    public String getPhoto4Url() {
        return photo4Url;
    }

    public void setPhoto4Url(String photo4Url) {
        this.photo4Url = photo4Url;
    }

    public String getPhoto5Url() {
        return photo5Url;
    }

    public void setPhoto5Url(String photo5Url) {
        this.photo5Url = photo5Url;
    }

    public String getPhoto6Url() {
        return photo6Url;
    }

    public void setPhoto6Url(String photo6Url) {
        this.photo6Url = photo6Url;
    }

    public String getPhoto7Url() {
        return photo7Url;
    }

    public void setPhoto7Url(String photo7Url) {
        this.photo7Url = photo7Url;
    }

    public String getPhoto8Url() {
        return photo8Url;
    }

    public void setPhoto8Url(String photo8Url) {
        this.photo8Url = photo8Url;
    }

    public String getPhoto9Url() {
        return photo9Url;
    }

    public void setPhoto9Url(String photo9Url) {
        this.photo9Url = photo9Url;
    }

    public String getPhoto10Url() {
        return photo10Url;
    }

    public void setPhoto10Url(String photo10Url) {
        this.photo10Url = photo10Url;
    }

    public String getPhoto11Url() {
        return photo11Url;
    }

    public void setPhoto11Url(String photo11Url) {
        this.photo11Url = photo11Url;
    }

    public String getPhoto12Url() {
        return photo12Url;
    }

    public void setPhoto12Url(String photo12Url) {
        this.photo12Url = photo12Url;
    }

    public String getPhoto13Url() {
        return photo13Url;
    }

    public void setPhoto13Url(String photo13Url) {
        this.photo13Url = photo13Url;
    }

    public String getPhoto14Url() {
        return photo14Url;
    }

    public void setPhoto14Url(String photo14Url) {
        this.photo14Url = photo14Url;
    }

    public String getPhoto15Url() {
        return photo15Url;
    }

    public void setPhoto15Url(String photo15Url) {
        this.photo15Url = photo15Url;
    }

    public String getPhoto16Url() {
        return photo16Url;
    }

    public void setPhoto16Url(String photo16Url) {
        this.photo16Url = photo16Url;
    }

    public String getPhoto17Url() {
        return photo17Url;
    }

    public void setPhoto17Url(String photo17Url) {
        this.photo17Url = photo17Url;
    }

    public String getPhoto18Url() {
        return photo18Url;
    }

    public void setPhoto18Url(String photo18Url) {
        this.photo18Url = photo18Url;
    }

    public String getPhoto19Url() {
        return photo19Url;
    }

    public void setPhoto19Url(String photo19Url) {
        this.photo19Url = photo19Url;
    }

    public String getPhoto20Url() {
        return photo20Url;
    }

    public void setPhoto20Url(String photo20Url) {
        this.photo20Url = photo20Url;
    }

    public String getPhoto21Url() {
        return photo21Url;
    }

    public void setPhoto21Url(String photo21Url) {
        this.photo21Url = photo21Url;
    }

    public String getPhoto22Url() {
        return photo22Url;
    }

    public void setPhoto22Url(String photo22Url) {
        this.photo22Url = photo22Url;
    }

    public String getPhoto23Url() {
        return photo23Url;
    }

    public void setPhoto23Url(String photo23Url) {
        this.photo23Url = photo23Url;
    }

    public String getPhoto24Url() {
        return photo24Url;
    }

    public void setPhoto24Url(String photo24Url) {
        this.photo24Url = photo24Url;
    }

    public String getPhoto25Url() {
        return photo25Url;
    }

    public void setPhoto25Url(String photo25Url) {
        this.photo25Url = photo25Url;
    }

    public String getPhoto26Url() {
        return photo26Url;
    }

    public void setPhoto26Url(String photo26Url) {
        this.photo26Url = photo26Url;
    }

    public String getPhoto27Url() {
        return photo27Url;
    }

    public void setPhoto27Url(String photo27Url) {
        this.photo27Url = photo27Url;
    }

    public String getPhoto28Url() {
        return photo28Url;
    }

    public void setPhoto28Url(String photo28Url) {
        this.photo28Url = photo28Url;
    }

    public String getPhoto29Url() {
        return photo29Url;
    }

    public void setPhoto29Url(String photo29Url) {
        this.photo29Url = photo29Url;
    }

    public String getPhoto30Url() {
        return photo30Url;
    }

    public void setPhoto30Url(String photo30Url) {
        this.photo30Url = photo30Url;
    }

    public String getPhoto31Url() {
        return photo31Url;
    }

    public void setPhoto31Url(String photo31Url) {
        this.photo31Url = photo31Url;
    }

    public String getPhoto32Url() {
        return photo32Url;
    }

    public void setPhoto32Url(String photo32Url) {
        this.photo32Url = photo32Url;
    }

    public String getPhoto33Url() {
        return photo33Url;
    }

    public void setPhoto33Url(String photo33Url) {
        this.photo33Url = photo33Url;
    }

    public String getPhoto34Url() {
        return photo34Url;
    }

    public void setPhoto34Url(String photo34Url) {
        this.photo34Url = photo34Url;
    }

    public String getPhoto35Url() {
        return photo35Url;
    }

    public void setPhoto35Url(String photo35Url) {
        this.photo35Url = photo35Url;
    }

    public String getPhoto36Url() {
        return photo36Url;
    }

    public void setPhoto36Url(String photo36Url) {
        this.photo36Url = photo36Url;
    }

    public String getPhoto37Url() {
        return photo37Url;
    }

    public void setPhoto37Url(String photo37Url) {
        this.photo37Url = photo37Url;
    }

    public String getPhoto38Url() {
        return photo38Url;
    }

    public void setPhoto38Url(String photo38Url) {
        this.photo38Url = photo38Url;
    }

    public String getPhoto39Url() {
        return photo39Url;
    }

    public void setPhoto39Url(String photo39Url) {
        this.photo39Url = photo39Url;
    }

    public String getPhoto40Url() {
        return photo40Url;
    }

    public void setPhoto40Url(String photo40Url) {
        this.photo40Url = photo40Url;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getImgDeleted() {
        return imgDeleted;
    }

    public void setImgDeleted(Boolean imgDeleted) {
        this.imgDeleted = imgDeleted;
    }

    public String getRetsServer() {
        return retsServer;
    }

    public void setRetsServer(String retsServer) {
        this.retsServer = retsServer;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPropertyTag() {
        return propertyTag;
    }

    public void setPropertyTag(String propertyTag) {
        this.propertyTag = propertyTag;
    }

    public Integer getBuildentoryViews() {
        return buildentoryViews;
    }

    public void setBuildentoryViews(Integer buildentoryViews) {
        this.buildentoryViews = buildentoryViews;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResPropertiesDTO)) {
            return false;
        }

        ResPropertiesDTO resPropertiesDTO = (ResPropertiesDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, resPropertiesDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResPropertiesDTO{" +
            "id=" + getId() +
            ", communityId=" + getCommunityId() +
            ", communityName='" + getCommunityName() + "'" +
            ", builderId=" + getBuilderId() +
            ", specialOffers='" + getSpecialOffers() + "'" +
            ", brochure='" + getBrochure() + "'" +
            ", floorPlanId=" + getFloorPlanId() +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", county='" + getCounty() + "'" +
            ", heatsystem='" + getHeatsystem() + "'" +
            ", liststatus='" + getListstatus() + "'" +
            ", liststatusflag='" + getListstatusflag() + "'" +
            ", carportcap='" + getCarportcap() + "'" +
            ", possession='" + getPossession() + "'" +
            ", schoolname1='" + getSchoolname1() + "'" +
            ", subdivide='" + getSubdivide() + "'" +
            ", vowavmyn='" + getVowavmyn() + "'" +
            ", presentuse='" + getPresentuse() + "'" +
            ", proposeduse='" + getProposeduse() + "'" +
            ", ranchname='" + getRanchname() + "'" +
            ", roombed2width=" + getRoombed2width() +
            ", roomdininglevel='" + getRoomdininglevel() + "'" +
            ", roomliving2width=" + getRoomliving2width() +
            ", roomstudylevel='" + getRoomstudylevel() + "'" +
            ", area=" + getArea() +
            ", areatitle='" + getAreatitle() + "'" +
            ", assocfee=" + getAssocfee() +
            ", financeproposed='" + getFinanceproposed() + "'" +
            ", listpriceorig=" + getListpriceorig() +
            ", mapcoord='" + getMapcoord() + "'" +
            ", schoolname2='" + getSchoolname2() + "'" +
            ", roomgaragewidth=" + getRoomgaragewidth() +
            ", roomkitchendesc='" + getRoomkitchendesc() + "'" +
            ", roomliving1width=" + getRoomliving1width() +
            ", roomother2width=" + getRoomother2width() +
            ", sqfttotal=" + getSqfttotal() +
            ", officelistOfficenam1='" + getOfficelistOfficenam1() + "'" +
            ", schoolname3='" + getSchoolname3() + "'" +
            ", zipcode='" + getZipcode() + "'" +
            ", barn1length=" + getBarn1length() +
            ", barn3width=" + getBarn3width() +
            ", roombed2length=" + getRoombed2length() +
            ", roombed3length=" + getRoombed3length() +
            ", roomother1width=" + getRoomother1width() +
            ", agentlistFullname='" + getAgentlistFullname() + "'" +
            ", proptype='" + getProptype() + "'" +
            ", mlsProptype='" + getMlsProptype() + "'" +
            ", schoolname4='" + getSchoolname4() + "'" +
            ", acrescultivated=" + getAcrescultivated() +
            ", barn2length=" + getBarn2length() +
            ", barn2width=" + getBarn2width() +
            ", complexname='" + getComplexname() + "'" +
            ", roombed4length=" + getRoombed4length() +
            ", roombedbathdesc='" + getRoombedbathdesc() + "'" +
            ", roombreakfastwidth=" + getRoombreakfastwidth() +
            ", roomother='" + getRoomother() + "'" +
            ", roomutilitylength=" + getRoomutilitylength() +
            ", acres=" + getAcres() +
            ", block='" + getBlock() + "'" +
            ", directions='" + getDirections() + "'" +
            ", subdivision='" + getSubdivision() + "'" +
            ", yearbuilt=" + getYearbuilt() +
            ", yearbuiltdetails='" + getYearbuiltdetails() + "'" +
            ", agexemption='" + getAgexemption() + "'" +
            ", barn1width=" + getBarn1width() +
            ", barn3length=" + getBarn3length() +
            ", roomdiningwidth=" + getRoomdiningwidth() +
            ", roomstudywidth=" + getRoomstudywidth() +
            ", soiltype='" + getSoiltype() + "'" +
            ", appraisername='" + getAppraisername() + "'" +
            ", listpricelow=" + getListpricelow() +
            ", mappage='" + getMappage() + "'" +
            ", unitnumber='" + getUnitnumber() + "'" +
            ", streetdir='" + getStreetdir() + "'" +
            ", streettype='" + getStreettype() + "'" +
            ", subarea='" + getSubarea() + "'" +
            ", subareatitle='" + getSubareatitle() + "'" +
            ", bathshalf=" + getBathshalf() +
            ", roomgaragelength=" + getRoomgaragelength() +
            ", propsubtype='" + getPropsubtype() + "'" +
            ", beds=" + getBeds() +
            ", roommasterbedwidth=" + getRoommasterbedwidth() +
            ", roomstudylength=" + getRoomstudylength() +
            ", agentlist='" + getAgentlist() + "'" +
            ", streetname='" + getStreetname() + "'" +
            ", roombreakfastlength=" + getRoombreakfastlength() +
            ", roomkitchenwidth=" + getRoomkitchenwidth() +
            ", fence='" + getFence() + "'" +
            ", bathstotal=" + getBathstotal() +
            ", garagecap=" + getGaragecap() +
            ", sqftprice=" + getSqftprice() +
            ", style='" + getStyle() + "'" +
            ", exterior='" + getExterior() + "'" +
            ", foundation='" + getFoundation() + "'" +
            ", interior='" + getInterior() + "'" +
            ", poolyn='" + getPoolyn() + "'" +
            ", poolFeature='" + getPoolFeature() + "'" +
            ", listprice=" + getListprice() +
            ", listpricerange='" + getListpricerange() + "'" +
            ", mlsnum='" + getMlsnum() + "'" +
            ", matrixid=" + getMatrixid() +
            ", remarks='" + getRemarks() + "'" +
            ", state='" + getState() + "'" +
            ", roof='" + getRoof() + "'" +
            ", securityfeatures='" + getSecurityfeatures() + "'" +
            ", utilitiesother='" + getUtilitiesother() + "'" +
            ", commonfeatures='" + getCommonfeatures() + "'" +
            ", construction='" + getConstruction() + "'" +
            ", modified='" + getModified() + "'" +
            ", stories=" + getStories() +
            ", roomdininglength=" + getRoomdininglength() +
            ", roomliving1length=" + getRoomliving1length() +
            ", openhousetime='" + getOpenhousetime() + "'" +
            ", openhouseendtime='" + getOpenhouseendtime() + "'" +
            ", roomliving2length=" + getRoomliving2length() +
            ", lotdesc='" + getLotdesc() + "'" +
            ", openhousedate='" + getOpenhousedate() + "'" +
            ", roommasterbedlength=" + getRoommasterbedlength() +
            ", roomother1length=" + getRoomother1length() +
            ", officesellOfficenam2='" + getOfficesellOfficenam2() + "'" +
            ", lotsize='" + getLotsize() + "'" +
            ", streetdirsuffix='" + getStreetdirsuffix() + "'" +
            ", photocount=" + getPhotocount() +
            ", schooldistrict='" + getSchooldistrict() + "'" +
            ", streetnum=" + getStreetnum() +
            ", utilities='" + getUtilities() + "'" +
            ", equipment='" + getEquipment() + "'" +
            ", roombed4width=" + getRoombed4width() +
            ", roomkitchenlength=" + getRoomkitchenlength() +
            ", city='" + getCity() + "'" +
            ", garagedesc='" + getGaragedesc() + "'" +
            ", bathsfull=" + getBathsfull() +
            ", roombed3width=" + getRoombed3width() +
            ", roomutildesc='" + getRoomutildesc() + "'" +
            ", roomutilitywidth=" + getRoomutilitywidth() +
            ", roomfullbathlength='" + getRoomfullbathlength() + "'" +
            ", roomfullbathwidth='" + getRoomfullbathwidth() + "'" +
            ", roomhalfbathlength='" + getRoomhalfbathlength() + "'" +
            ", roomhalfbathwidth='" + getRoomhalfbathwidth() + "'" +
            ", roomexerciselength='" + getRoomexerciselength() + "'" +
            ", roomexercisewidth='" + getRoomexercisewidth() + "'" +
            ", roomstoragelength='" + getRoomstoragelength() + "'" +
            ", roomstoragewidth='" + getRoomstoragewidth() + "'" +
            ", roomgamelength='" + getRoomgamelength() + "'" +
            ", roomgamewidth='" + getRoomgamewidth() + "'" +
            ", roomguestlength='" + getRoomguestlength() + "'" +
            ", roomguestwidth='" + getRoomguestwidth() + "'" +
            ", roomlibrarylength='" + getRoomlibrarylength() + "'" +
            ", roomlibrarywidth='" + getRoomlibrarywidth() + "'" +
            ", roommedialength='" + getRoommedialength() + "'" +
            ", roommediawidth='" + getRoommediawidth() + "'" +
            ", roommudlength='" + getRoommudlength() + "'" +
            ", roommudwidth='" + getRoommudwidth() + "'" +
            ", roomofficelength='" + getRoomofficelength() + "'" +
            ", roomofficewidth='" + getRoomofficewidth() + "'" +
            ", roomsaunalength='" + getRoomsaunalength() + "'" +
            ", roomsaunawidth='" + getRoomsaunawidth() + "'" +
            ", roomsecondmasterlength='" + getRoomsecondmasterlength() + "'" +
            ", roomsecondmasterwidth='" + getRoomsecondmasterwidth() + "'" +
            ", roomsunlength='" + getRoomsunlength() + "'" +
            ", roomsunwidth='" + getRoomsunwidth() + "'" +
            ", roomspalength='" + getRoomspalength() + "'" +
            ", roomspawidth='" + getRoomspawidth() + "'" +
            ", roomwinelength='" + getRoomwinelength() + "'" +
            ", roomwinewidth='" + getRoomwinewidth() + "'" +
            ", juniorhighschoolname='" + getJuniorhighschoolname() + "'" +
            ", primaryschoolname='" + getPrimaryschoolname() + "'" +
            ", seniorhighschoolname='" + getSeniorhighschoolname() + "'" +
            ", associationfee='" + getAssociationfee() + "'" +
            ", associationfeefrequency='" + getAssociationfeefrequency() + "'" +
            ", constructionmaterials='" + getConstructionmaterials() + "'" +
            ", heating='" + getHeating() + "'" +
            ", accessoryunittype='" + getAccessoryunittype() + "'" +
            ", accessoryunityn='" + getAccessoryunityn() + "'" +
            ", flooring='" + getFlooring() + "'" +
            ", fireplacestotal='" + getFireplacestotal() + "'" +
            ", fireplacefeatures='" + getFireplacefeatures() + "'" +
            ", securitysystemyn='" + getSecuritysystemyn() + "'" +
            ", greenbuildingcertification='" + getGreenbuildingcertification() + "'" +
            ", greenenergyefficient='" + getGreenenergyefficient() + "'" +
            ", energysavingfeatures='" + getEnergysavingfeatures() + "'" +
            ", lotnumber='" + getLotnumber() + "'" +
            ", lotsizearea='" + getLotsizearea() + "'" +
            ", lotsizedimensions='" + getLotsizedimensions() + "'" +
            ", easements='" + getEasements() + "'" +
            ", restrictions='" + getRestrictions() + "'" +
            ", washerdryerconnections='" + getWasherdryerconnections() + "'" +
            ", municipalutilitydistrictyn='" + getMunicipalutilitydistrictyn() + "'" +
            ", associationfeeincludes='" + getAssociationfeeincludes() + "'" +
            ", associationtype='" + getAssociationtype() + "'" +
            ", barninformation='" + getBarninformation() + "'" +
            ", constructionmaterialswalls='" + getConstructionmaterialswalls() + "'" +
            ", countyorparish='" + getCountyorparish() + "'" +
            ", exteriorbuildings='" + getExteriorbuildings() + "'" +
            ", farmranchfeatures='" + getFarmranchfeatures() + "'" +
            ", fencedyardyn='" + getFencedyardyn() + "'" +
            ", financingproposed='" + getFinancingproposed() + "'" +
            ", handicapyn='" + getHandicapyn() + "'" +
            ", numberoftanksandponds='" + getNumberoftanksandponds() + "'" +
            ", parcelnumber='" + getParcelnumber() + "'" +
            ", virtualtoururlunbranded='" + getVirtualtoururlunbranded() + "'" +
            ", livingRoomFeature='" + getLivingRoomFeature() + "'" +
            ", masterBedRoomFeature='" + getMasterBedRoomFeature() + "'" +
            ", bedRoomFeature='" + getBedRoomFeature() + "'" +
            ", diningRoomFeature='" + getDiningRoomFeature() + "'" +
            ", kitchenRoomFeature='" + getKitchenRoomFeature() + "'" +
            ", breakfastRoomFeature='" + getBreakfastRoomFeature() + "'" +
            ", studyRoomFeature='" + getStudyRoomFeature() + "'" +
            ", utilityRoomFeature='" + getUtilityRoomFeature() + "'" +
            ", fullBathRoomFeature='" + getFullBathRoomFeature() + "'" +
            ", halfBathRoomFeature='" + getHalfBathRoomFeature() + "'" +
            ", exerciseRoomFeature='" + getExerciseRoomFeature() + "'" +
            ", extraStorageRoomFeature='" + getExtraStorageRoomFeature() + "'" +
            ", gameRoomFeature='" + getGameRoomFeature() + "'" +
            ", guestRoomFeature='" + getGuestRoomFeature() + "'" +
            ", libraryRoomFeature='" + getLibraryRoomFeature() + "'" +
            ", mediaRoomFeature='" + getMediaRoomFeature() + "'" +
            ", mudRoomFeature='" + getMudRoomFeature() + "'" +
            ", officeRoomFeature='" + getOfficeRoomFeature() + "'" +
            ", saunaRoomFeature='" + getSaunaRoomFeature() + "'" +
            ", secondMasterRoomFeature='" + getSecondMasterRoomFeature() + "'" +
            ", sunroomRoomFeature='" + getSunroomRoomFeature() + "'" +
            ", spaRoomFeature='" + getSpaRoomFeature() + "'" +
            ", wineRoomFeature='" + getWineRoomFeature() + "'" +
            ", otherRoomFeature='" + getOtherRoomFeature() + "'" +
            ", isLuxury='" + getIsLuxury() + "'" +
            ", isMoveInReady='" + getIsMoveInReady() + "'" +
            ", photoUrl='" + getPhotoUrl() + "'" +
            ", photo1Url='" + getPhoto1Url() + "'" +
            ", photo2Url='" + getPhoto2Url() + "'" +
            ", photo3Url='" + getPhoto3Url() + "'" +
            ", photo4Url='" + getPhoto4Url() + "'" +
            ", photo5Url='" + getPhoto5Url() + "'" +
            ", photo6Url='" + getPhoto6Url() + "'" +
            ", photo7Url='" + getPhoto7Url() + "'" +
            ", photo8Url='" + getPhoto8Url() + "'" +
            ", photo9Url='" + getPhoto9Url() + "'" +
            ", photo10Url='" + getPhoto10Url() + "'" +
            ", photo11Url='" + getPhoto11Url() + "'" +
            ", photo12Url='" + getPhoto12Url() + "'" +
            ", photo13Url='" + getPhoto13Url() + "'" +
            ", photo14Url='" + getPhoto14Url() + "'" +
            ", photo15Url='" + getPhoto15Url() + "'" +
            ", photo16Url='" + getPhoto16Url() + "'" +
            ", photo17Url='" + getPhoto17Url() + "'" +
            ", photo18Url='" + getPhoto18Url() + "'" +
            ", photo19Url='" + getPhoto19Url() + "'" +
            ", photo20Url='" + getPhoto20Url() + "'" +
            ", photo21Url='" + getPhoto21Url() + "'" +
            ", photo22Url='" + getPhoto22Url() + "'" +
            ", photo23Url='" + getPhoto23Url() + "'" +
            ", photo24Url='" + getPhoto24Url() + "'" +
            ", photo25Url='" + getPhoto25Url() + "'" +
            ", photo26Url='" + getPhoto26Url() + "'" +
            ", photo27Url='" + getPhoto27Url() + "'" +
            ", photo28Url='" + getPhoto28Url() + "'" +
            ", photo29Url='" + getPhoto29Url() + "'" +
            ", photo30Url='" + getPhoto30Url() + "'" +
            ", photo31Url='" + getPhoto31Url() + "'" +
            ", photo32Url='" + getPhoto32Url() + "'" +
            ", photo33Url='" + getPhoto33Url() + "'" +
            ", photo34Url='" + getPhoto34Url() + "'" +
            ", photo35Url='" + getPhoto35Url() + "'" +
            ", photo36Url='" + getPhoto36Url() + "'" +
            ", photo37Url='" + getPhoto37Url() + "'" +
            ", photo38Url='" + getPhoto38Url() + "'" +
            ", photo39Url='" + getPhoto39Url() + "'" +
            ", photo40Url='" + getPhoto40Url() + "'" +
            ", created='" + getCreated() + "'" +
            ", updated='" + getUpdated() + "'" +
            ", modifiedDate='" + getModifiedDate() + "'" +
            ", imgDeleted='" + getImgDeleted() + "'" +
            ", retsServer='" + getRetsServer() + "'" +
            ", permalink='" + getPermalink() + "'" +
            ", propertyTag='" + getPropertyTag() + "'" +
            ", buildentoryViews=" + getBuildentoryViews() +
            ", location='" + getLocation() + "'" +
            "}";
    }
}
