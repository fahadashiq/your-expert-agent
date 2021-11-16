package com.hsrw.yea.domain;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A ResProperties.
 */
@Entity
@Table(name = "res_properties")
public class ResProperties implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "community_id", nullable = false)
    private Integer communityId;

    @NotNull
    @Size(max = 255)
    @Column(name = "community_name", length = 255, nullable = false)
    private String communityName;

    @NotNull
    @Column(name = "builder_id", nullable = false)
    private Integer builderId;

    @NotNull
    @Size(max = 255)
    @Column(name = "special_offers", length = 255, nullable = false)
    private String specialOffers;

    @NotNull
    @Size(max = 255)
    @Column(name = "brochure", length = 255, nullable = false)
    private String brochure;

    @NotNull
    @Column(name = "floor_plan_id", nullable = false)
    private Integer floorPlanId;

    @Size(max = 20)
    @Column(name = "latitude", length = 20)
    private String latitude;

    @Size(max = 20)
    @Column(name = "longitude", length = 20)
    private String longitude;

    /**
     * County
     */
    @ApiModelProperty(value = "County")
    @Size(max = 32)
    @Column(name = "county", length = 32)
    private String county;

    /**
     * Heating/Cooling
     */
    @ApiModelProperty(value = "Heating/Cooling")
    @Size(max = 255)
    @Column(name = "heatsystem", length = 255)
    private String heatsystem;

    /**
     * Status
     */
    @ApiModelProperty(value = "Status")
    @Size(max = 50)
    @Column(name = "liststatus", length = 50)
    private String liststatus;

    @Size(max = 100)
    @Column(name = "liststatusflag", length = 100)
    private String liststatusflag;

    @Size(max = 100)
    @Column(name = "carportcap", length = 100)
    private String carportcap;

    /**
     * Possession
     */
    @ApiModelProperty(value = "Possession")
    @Size(max = 255)
    @Column(name = "possession", length = 255)
    private String possession;

    /**
     * School 1 Name
     */
    @ApiModelProperty(value = "School 1 Name")
    @Size(max = 32)
    @Column(name = "schoolname1", length = 32)
    private String schoolname1;

    /**
     * Will Subdivide
     */
    @ApiModelProperty(value = "Will Subdivide")
    @Size(max = 50)
    @Column(name = "subdivide", length = 50)
    private String subdivide;

    /**
     * Allow AVM
     */
    @ApiModelProperty(value = "Allow AVM")
    @Size(max = 1)
    @Column(name = "vowavmyn", length = 1)
    private String vowavmyn;

    /**
     * Present Use
     */
    @ApiModelProperty(value = "Present Use")
    @Size(max = 255)
    @Column(name = "presentuse", length = 255)
    private String presentuse;

    /**
     * Proposed Use
     */
    @ApiModelProperty(value = "Proposed Use")
    @Size(max = 255)
    @Column(name = "proposeduse", length = 255)
    private String proposeduse;

    /**
     * Ranch Name
     */
    @ApiModelProperty(value = "Ranch Name")
    @Size(max = 15)
    @Column(name = "ranchname", length = 15)
    private String ranchname;

    /**
     * Bedroom 2 Width
     */
    @ApiModelProperty(value = "Bedroom 2 Width")
    @Column(name = "roombed2width")
    private Integer roombed2width;

    /**
     * Formal Dining Level
     */
    @ApiModelProperty(value = "Formal Dining Level")
    @Size(max = 50)
    @Column(name = "roomdininglevel", length = 50)
    private String roomdininglevel;

    /**
     * Living 2 Width
     */
    @ApiModelProperty(value = "Living 2 Width")
    @Column(name = "roomliving2width")
    private Integer roomliving2width;

    /**
     * Study Level
     */
    @ApiModelProperty(value = "Study Level")
    @Size(max = 50)
    @Column(name = "roomstudylevel", length = 50)
    private String roomstudylevel;

    /**
     * Area
     */
    @ApiModelProperty(value = "Area")
    @Column(name = "area")
    private Integer area;

    @Size(max = 255)
    @Column(name = "areatitle", length = 255)
    private String areatitle;

    /**
     * HOA Dues
     */
    @ApiModelProperty(value = "HOA Dues")
    @Column(name = "assocfee")
    private Integer assocfee;

    /**
     * Proposed Financing
     */
    @ApiModelProperty(value = "Proposed Financing")
    @Size(max = 255)
    @Column(name = "financeproposed", length = 255)
    private String financeproposed;

    /**
     * Original List Price
     */
    @ApiModelProperty(value = "Original List Price")
    @Column(name = "listpriceorig")
    private Integer listpriceorig;

    /**
     * Map Coord
     */
    @ApiModelProperty(value = "Map Coord")
    @Size(max = 5)
    @Column(name = "mapcoord", length = 5)
    private String mapcoord;

    /**
     * School 2 Name
     */
    @ApiModelProperty(value = "School 2 Name")
    @Size(max = 32)
    @Column(name = "schoolname2", length = 32)
    private String schoolname2;

    /**
     * Garage Width
     */
    @ApiModelProperty(value = "Garage Width")
    @Column(name = "roomgaragewidth")
    private Integer roomgaragewidth;

    /**
     * Kitchen Other
     */
    @ApiModelProperty(value = "Kitchen Other")
    @Size(max = 255)
    @Column(name = "roomkitchendesc", length = 255)
    private String roomkitchendesc;

    /**
     * Living 1 Width
     */
    @ApiModelProperty(value = "Living 1 Width")
    @Column(name = "roomliving1width")
    private Integer roomliving1width;

    /**
     * Other Room 2 Width
     */
    @ApiModelProperty(value = "Other Room 2 Width")
    @Column(name = "roomother2width")
    private Integer roomother2width;

    /**
     * SqFt
     */
    @ApiModelProperty(value = "SqFt")
    @Column(name = "sqfttotal")
    private Integer sqfttotal;

    /**
     * Listing Office Name
     */
    @ApiModelProperty(value = "Listing Office Name")
    @Size(max = 100)
    @Column(name = "officelist_officenam1", length = 100)
    private String officelistOfficenam1;

    /**
     * School 3 Name
     */
    @ApiModelProperty(value = "School 3 Name")
    @Size(max = 32)
    @Column(name = "schoolname3", length = 32)
    private String schoolname3;

    /**
     * Zip Code
     */
    @ApiModelProperty(value = "Zip Code")
    @Size(max = 25)
    @Column(name = "zipcode", length = 25)
    private String zipcode;

    /**
     * Barn 1 Length
     */
    @ApiModelProperty(value = "Barn 1 Length")
    @Column(name = "barn1length")
    private Integer barn1length;

    /**
     * Barn 3 Width
     */
    @ApiModelProperty(value = "Barn 3 Width")
    @Column(name = "barn3width")
    private Integer barn3width;

    /**
     * Bedroom 2 Length
     */
    @ApiModelProperty(value = "Bedroom 2 Length")
    @Column(name = "roombed2length")
    private Integer roombed2length;

    /**
     * Bedroom 3 Length
     */
    @ApiModelProperty(value = "Bedroom 3 Length")
    @Column(name = "roombed3length")
    private Integer roombed3length;

    /**
     * Other Room 1 Width
     */
    @ApiModelProperty(value = "Other Room 1 Width")
    @Column(name = "roomother1width")
    private Integer roomother1width;

    /**
     * Listing Agent Name
     */
    @ApiModelProperty(value = "Listing Agent Name")
    @Size(max = 150)
    @Column(name = "agentlist_fullname", length = 150)
    private String agentlistFullname;

    /**
     * Property Category
     */
    @ApiModelProperty(value = "Property Category")
    @Size(max = 50)
    @Column(name = "proptype", length = 50)
    private String proptype;

    @NotNull
    @Size(max = 50)
    @Column(name = "mls_proptype", length = 50, nullable = false)
    private String mlsProptype;

    /**
     * School 4 Name
     */
    @ApiModelProperty(value = "School 4 Name")
    @Size(max = 32)
    @Column(name = "schoolname4", length = 32)
    private String schoolname4;

    /**
     * Cultivated Acres
     */
    @ApiModelProperty(value = "Cultivated Acres")
    @Column(name = "acrescultivated", precision = 21, scale = 2)
    private BigDecimal acrescultivated;

    /**
     * Barn 2 Length
     */
    @ApiModelProperty(value = "Barn 2 Length")
    @Column(name = "barn2length")
    private Integer barn2length;

    /**
     * Barn 2 Width
     */
    @ApiModelProperty(value = "Barn 2 Width")
    @Column(name = "barn2width")
    private Integer barn2width;

    /**
     * Complex Name
     */
    @ApiModelProperty(value = "Complex Name")
    @Size(max = 25)
    @Column(name = "complexname", length = 25)
    private String complexname;

    /**
     * Bedroom 4 Length
     */
    @ApiModelProperty(value = "Bedroom 4 Length")
    @Column(name = "roombed4length")
    private Integer roombed4length;

    /**
     * Bed/Bath Features
     */
    @ApiModelProperty(value = "Bed/Bath Features")
    @Size(max = 255)
    @Column(name = "roombedbathdesc", length = 255)
    private String roombedbathdesc;

    /**
     * Breakfast Width
     */
    @ApiModelProperty(value = "Breakfast Width")
    @Column(name = "roombreakfastwidth")
    private Integer roombreakfastwidth;

    /**
     * Specialty Rooms
     */
    @ApiModelProperty(value = "Specialty Rooms")
    @Size(max = 255)
    @Column(name = "roomother", length = 255)
    private String roomother;

    /**
     * Utility Length
     */
    @ApiModelProperty(value = "Utility Length")
    @Column(name = "roomutilitylength")
    private Integer roomutilitylength;

    /**
     * Acres
     */
    @ApiModelProperty(value = "Acres")
    @Column(name = "acres", precision = 21, scale = 2)
    private BigDecimal acres;

    /**
     * Block
     */
    @ApiModelProperty(value = "Block")
    @Size(max = 7)
    @Column(name = "block", length = 7)
    private String block;

    /**
     * Directions
     */
    @ApiModelProperty(value = "Directions")
    @Size(max = 150)
    @Column(name = "directions", length = 150)
    private String directions;

    /**
     * Subdivision
     */
    @ApiModelProperty(value = "Subdivision")
    @Size(max = 40)
    @Column(name = "subdivision", length = 40)
    private String subdivision;

    /**
     * Year Built
     */
    @ApiModelProperty(value = "Year Built")
    @Column(name = "yearbuilt")
    private Integer yearbuilt;

    @NotNull
    @Size(max = 255)
    @Column(name = "yearbuiltdetails", length = 255, nullable = false)
    private String yearbuiltdetails;

    /**
     * AG Exemption
     */
    @ApiModelProperty(value = "AG Exemption")
    @Size(max = 1)
    @Column(name = "agexemption", length = 1)
    private String agexemption;

    /**
     * Barn 1 Width
     */
    @ApiModelProperty(value = "Barn 1 Width")
    @Column(name = "barn1width")
    private Integer barn1width;

    /**
     * Barn 3 Length
     */
    @ApiModelProperty(value = "Barn 3 Length")
    @Column(name = "barn3length")
    private Integer barn3length;

    /**
     * Formal Dining Width
     */
    @ApiModelProperty(value = "Formal Dining Width")
    @Column(name = "roomdiningwidth")
    private Integer roomdiningwidth;

    /**
     * Study Width
     */
    @ApiModelProperty(value = "Study Width")
    @Column(name = "roomstudywidth")
    private Integer roomstudywidth;

    /**
     * Soil
     */
    @ApiModelProperty(value = "Soil")
    @Size(max = 255)
    @Column(name = "soiltype", length = 255)
    private String soiltype;

    /**
     * Appraiser's Name
     */
    @ApiModelProperty(value = "Appraiser's Name")
    @Size(max = 50)
    @Column(name = "appraisername", length = 50)
    private String appraisername;

    /**
     * Low Price
     */
    @ApiModelProperty(value = "Low Price")
    @Column(name = "listpricelow")
    private Integer listpricelow;

    /**
     * Map Page
     */
    @ApiModelProperty(value = "Map Page")
    @Size(max = 5)
    @Column(name = "mappage", length = 5)
    private String mappage;

    @NotNull
    @Size(max = 20)
    @Column(name = "unitnumber", length = 20, nullable = false)
    private String unitnumber;

    /**
     * Street Direction
     */
    @ApiModelProperty(value = "Street Direction")
    @Size(max = 50)
    @Column(name = "streetdir", length = 50)
    private String streetdir;

    /**
     * Street Type
     */
    @ApiModelProperty(value = "Street Type")
    @Size(max = 50)
    @Column(name = "streettype", length = 50)
    private String streettype;

    /**
     * Sub Area
     */
    @ApiModelProperty(value = "Sub Area")
    @Size(max = 50)
    @Column(name = "subarea", length = 50)
    private String subarea;

    @Size(max = 255)
    @Column(name = "subareatitle", length = 255)
    private String subareatitle;

    /**
     * # Half Baths
     */
    @ApiModelProperty(value = "# Half Baths")
    @Column(name = "bathshalf")
    private Integer bathshalf;

    /**
     * Garage Length
     */
    @ApiModelProperty(value = "Garage Length")
    @Column(name = "roomgaragelength")
    private Integer roomgaragelength;

    /**
     * Property Type
     */
    @ApiModelProperty(value = "Property Type")
    @Size(max = 50)
    @Column(name = "propsubtype", length = 50)
    private String propsubtype;

    /**
     * # Bedrooms
     */
    @ApiModelProperty(value = "# Bedrooms")
    @Column(name = "beds")
    private Integer beds;

    /**
     * Master BR Width
     */
    @ApiModelProperty(value = "Master BR Width")
    @Column(name = "roommasterbedwidth")
    private Integer roommasterbedwidth;

    /**
     * Study Length
     */
    @ApiModelProperty(value = "Study Length")
    @Column(name = "roomstudylength")
    private Integer roomstudylength;

    /**
     * Listing Agent ID
     */
    @ApiModelProperty(value = "Listing Agent ID")
    @Size(max = 20)
    @Column(name = "agentlist", length = 20)
    private String agentlist;

    /**
     * Street Name
     */
    @ApiModelProperty(value = "Street Name")
    @Size(max = 50)
    @Column(name = "streetname", length = 50)
    private String streetname;

    /**
     * Breakfast Length
     */
    @ApiModelProperty(value = "Breakfast Length")
    @Column(name = "roombreakfastlength")
    private Integer roombreakfastlength;

    /**
     * Kitchen Width
     */
    @ApiModelProperty(value = "Kitchen Width")
    @Column(name = "roomkitchenwidth")
    private Integer roomkitchenwidth;

    /**
     * Type of Fence
     */
    @ApiModelProperty(value = "Type of Fence")
    @Size(max = 255)
    @Column(name = "fence", length = 255)
    private String fence;

    /**
     * Total Baths
     */
    @ApiModelProperty(value = "Total Baths")
    @Column(name = "bathstotal", precision = 21, scale = 2)
    private BigDecimal bathstotal;

    /**
     * # Garage Spaces
     */
    @ApiModelProperty(value = "# Garage Spaces")
    @Column(name = "garagecap")
    private Integer garagecap;

    /**
     * List$/SqFt
     */
    @ApiModelProperty(value = "List$/SqFt")
    @Column(name = "sqftprice", precision = 21, scale = 2)
    private BigDecimal sqftprice;

    /**
     * Style of House
     */
    @ApiModelProperty(value = "Style of House")
    @Size(max = 255)
    @Column(name = "style", length = 255)
    private String style;

    /**
     * Exterior Features
     */
    @ApiModelProperty(value = "Exterior Features")
    @Size(max = 255)
    @Column(name = "exterior", length = 255)
    private String exterior;

    /**
     * Foundation
     */
    @ApiModelProperty(value = "Foundation")
    @Size(max = 255)
    @Column(name = "foundation", length = 255)
    private String foundation;

    /**
     * Interior Features
     */
    @ApiModelProperty(value = "Interior Features")
    @Size(max = 255)
    @Column(name = "interior", length = 255)
    private String interior;

    /**
     * Pool on Property
     */
    @ApiModelProperty(value = "Pool on Property")
    @Size(max = 255)
    @Column(name = "poolyn", length = 255)
    private String poolyn;

    @NotNull
    @Size(max = 255)
    @Column(name = "pool_feature", length = 255, nullable = false)
    private String poolFeature;

    /**
     * List Price
     */
    @ApiModelProperty(value = "List Price")
    @Column(name = "listprice")
    private Integer listprice;

    /**
     * Range Pricing
     */
    @ApiModelProperty(value = "Range Pricing")
    @Size(max = 1)
    @Column(name = "listpricerange", length = 1)
    private String listpricerange;

    /**
     * MLS #
     */
    @ApiModelProperty(value = "MLS #", required = true)
    @NotNull
    @Size(max = 50)
    @Column(name = "mlsnum", length = 50, nullable = false)
    private String mlsnum;

    @NotNull
    @Column(name = "matrixid", nullable = false)
    private Integer matrixid;

    /**
     * Property Description
     */
    @ApiModelProperty(value = "Property Description")
    @Size(max = 255)
    @Column(name = "remarks", length = 255)
    private String remarks;

    /**
     * State
     */
    @ApiModelProperty(value = "State")
    @Size(max = 50)
    @Column(name = "state", length = 50)
    private String state;

    /**
     * Roof
     */
    @ApiModelProperty(value = "Roof")
    @Size(max = 255)
    @Column(name = "roof", length = 255)
    private String roof;

    @NotNull
    @Size(max = 255)
    @Column(name = "securityfeatures", length = 255, nullable = false)
    private String securityfeatures;

    @NotNull
    @Size(max = 255)
    @Column(name = "utilitiesother", length = 255, nullable = false)
    private String utilitiesother;

    /**
     * Common Features
     */
    @ApiModelProperty(value = "Common Features")
    @Size(max = 255)
    @Column(name = "commonfeatures", length = 255)
    private String commonfeatures;

    /**
     * Construction
     */
    @ApiModelProperty(value = "Construction")
    @Size(max = 255)
    @Column(name = "construction", length = 255)
    private String construction;

    /**
     * Modified
     */
    @ApiModelProperty(value = "Modified", required = true)
    @NotNull
    @Column(name = "modified", nullable = false)
    private Instant modified;

    /**
     * # of Stories
     */
    @ApiModelProperty(value = "# of Stories")
    @Column(name = "stories")
    private Integer stories;

    /**
     * Formal Dining Length
     */
    @ApiModelProperty(value = "Formal Dining Length")
    @Column(name = "roomdininglength")
    private Integer roomdininglength;

    /**
     * Living 1 Length
     */
    @ApiModelProperty(value = "Living 1 Length")
    @Column(name = "roomliving1length")
    private Integer roomliving1length;

    /**
     * Open House Time
     */
    @ApiModelProperty(value = "Open House Time")
    @Size(max = 25)
    @Column(name = "openhousetime", length = 25)
    private String openhousetime;

    @NotNull
    @Size(max = 25)
    @Column(name = "openhouseendtime", length = 25, nullable = false)
    private String openhouseendtime;

    /**
     * Living 2 Length
     */
    @ApiModelProperty(value = "Living 2 Length")
    @Column(name = "roomliving2length")
    private Integer roomliving2length;

    /**
     * Lot Description
     */
    @ApiModelProperty(value = "Lot Description")
    @Size(max = 255)
    @Column(name = "lotdesc", length = 255)
    private String lotdesc;

    /**
     * Open House Date
     */
    @ApiModelProperty(value = "Open House Date")
    @Column(name = "openhousedate")
    private Instant openhousedate;

    /**
     * Master BR Length
     */
    @ApiModelProperty(value = "Master BR Length")
    @Column(name = "roommasterbedlength")
    private Integer roommasterbedlength;

    /**
     * Other Room 1 Length
     */
    @ApiModelProperty(value = "Other Room 1 Length")
    @Column(name = "roomother1length")
    private Integer roomother1length;

    /**
     * Selling Office Name
     */
    @ApiModelProperty(value = "Selling Office Name")
    @Size(max = 100)
    @Column(name = "officesell_officenam2", length = 100)
    private String officesellOfficenam2;

    /**
     * Lot Size/Acreage
     */
    @ApiModelProperty(value = "Lot Size/Acreage")
    @Size(max = 50)
    @Column(name = "lotsize", length = 50)
    private String lotsize;

    /**
     * Street Directional Suffix
     */
    @ApiModelProperty(value = "Street Directional Suffix")
    @Size(max = 50)
    @Column(name = "streetdirsuffix", length = 50)
    private String streetdirsuffix;

    /**
     * Photo Count
     */
    @ApiModelProperty(value = "Photo Count")
    @Column(name = "photocount")
    private Integer photocount;

    /**
     * School District
     */
    @ApiModelProperty(value = "School District")
    @Size(max = 32)
    @Column(name = "schooldistrict", length = 32)
    private String schooldistrict;

    /**
     * Street/Box Number
     */
    @ApiModelProperty(value = "Street/Box Number")
    @Column(name = "streetnum")
    private Integer streetnum;

    /**
     * Street/Utilities
     */
    @ApiModelProperty(value = "Street/Utilities")
    @Size(max = 255)
    @Column(name = "utilities", length = 255)
    private String utilities;

    /**
     * Kitchen Equipment
     */
    @ApiModelProperty(value = "Kitchen Equipment")
    @Size(max = 255)
    @Column(name = "equipment", length = 255)
    private String equipment;

    /**
     * Bedroom 4 Width
     */
    @ApiModelProperty(value = "Bedroom 4 Width")
    @Column(name = "roombed4width")
    private Integer roombed4width;

    /**
     * Kitchen Length
     */
    @ApiModelProperty(value = "Kitchen Length")
    @Column(name = "roomkitchenlength")
    private Integer roomkitchenlength;

    /**
     * City
     */
    @ApiModelProperty(value = "City")
    @Size(max = 32)
    @Column(name = "city", length = 32)
    private String city;

    /**
     * Parking/Garage
     */
    @ApiModelProperty(value = "Parking/Garage")
    @Size(max = 255)
    @Column(name = "garagedesc", length = 255)
    private String garagedesc;

    /**
     * # Full Baths
     */
    @ApiModelProperty(value = "# Full Baths")
    @Column(name = "bathsfull")
    private Integer bathsfull;

    /**
     * Bedroom 3 Width
     */
    @ApiModelProperty(value = "Bedroom 3 Width")
    @Column(name = "roombed3width")
    private Integer roombed3width;

    /**
     * Utility Room
     */
    @ApiModelProperty(value = "Utility Room")
    @Size(max = 255)
    @Column(name = "roomutildesc", length = 255)
    private String roomutildesc;

    /**
     * Utility Width
     */
    @ApiModelProperty(value = "Utility Width")
    @Column(name = "roomutilitywidth")
    private Integer roomutilitywidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomfullbathlength", length = 10, nullable = false)
    private String roomfullbathlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomfullbathwidth", length = 10, nullable = false)
    private String roomfullbathwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomhalfbathlength", length = 10, nullable = false)
    private String roomhalfbathlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomhalfbathwidth", length = 10, nullable = false)
    private String roomhalfbathwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomexerciselength", length = 10, nullable = false)
    private String roomexerciselength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomexercisewidth", length = 10, nullable = false)
    private String roomexercisewidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomstoragelength", length = 10, nullable = false)
    private String roomstoragelength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomstoragewidth", length = 10, nullable = false)
    private String roomstoragewidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomgamelength", length = 10, nullable = false)
    private String roomgamelength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomgamewidth", length = 10, nullable = false)
    private String roomgamewidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomguestlength", length = 10, nullable = false)
    private String roomguestlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomguestwidth", length = 10, nullable = false)
    private String roomguestwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomlibrarylength", length = 10, nullable = false)
    private String roomlibrarylength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomlibrarywidth", length = 10, nullable = false)
    private String roomlibrarywidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roommedialength", length = 10, nullable = false)
    private String roommedialength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roommediawidth", length = 10, nullable = false)
    private String roommediawidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roommudlength", length = 10, nullable = false)
    private String roommudlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roommudwidth", length = 10, nullable = false)
    private String roommudwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomofficelength", length = 10, nullable = false)
    private String roomofficelength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomofficewidth", length = 10, nullable = false)
    private String roomofficewidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsaunalength", length = 10, nullable = false)
    private String roomsaunalength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsaunawidth", length = 10, nullable = false)
    private String roomsaunawidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsecondmasterlength", length = 10, nullable = false)
    private String roomsecondmasterlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsecondmasterwidth", length = 10, nullable = false)
    private String roomsecondmasterwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsunlength", length = 10, nullable = false)
    private String roomsunlength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomsunwidth", length = 10, nullable = false)
    private String roomsunwidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomspalength", length = 10, nullable = false)
    private String roomspalength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomspawidth", length = 10, nullable = false)
    private String roomspawidth;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomwinelength", length = 10, nullable = false)
    private String roomwinelength;

    @NotNull
    @Size(max = 10)
    @Column(name = "roomwinewidth", length = 10, nullable = false)
    private String roomwinewidth;

    @NotNull
    @Size(max = 255)
    @Column(name = "juniorhighschoolname", length = 255, nullable = false)
    private String juniorhighschoolname;

    @NotNull
    @Size(max = 255)
    @Column(name = "primaryschoolname", length = 255, nullable = false)
    private String primaryschoolname;

    @NotNull
    @Size(max = 255)
    @Column(name = "seniorhighschoolname", length = 255, nullable = false)
    private String seniorhighschoolname;

    @NotNull
    @Size(max = 255)
    @Column(name = "associationfee", length = 255, nullable = false)
    private String associationfee;

    @NotNull
    @Size(max = 255)
    @Column(name = "associationfeefrequency", length = 255, nullable = false)
    private String associationfeefrequency;

    @NotNull
    @Size(max = 255)
    @Column(name = "constructionmaterials", length = 255, nullable = false)
    private String constructionmaterials;

    @NotNull
    @Size(max = 255)
    @Column(name = "heating", length = 255, nullable = false)
    private String heating;

    @NotNull
    @Size(max = 255)
    @Column(name = "accessoryunittype", length = 255, nullable = false)
    private String accessoryunittype;

    @NotNull
    @Size(max = 255)
    @Column(name = "accessoryunityn", length = 255, nullable = false)
    private String accessoryunityn;

    @NotNull
    @Size(max = 255)
    @Column(name = "flooring", length = 255, nullable = false)
    private String flooring;

    @NotNull
    @Size(max = 255)
    @Column(name = "fireplacestotal", length = 255, nullable = false)
    private String fireplacestotal;

    @NotNull
    @Size(max = 255)
    @Column(name = "fireplacefeatures", length = 255, nullable = false)
    private String fireplacefeatures;

    @NotNull
    @Size(max = 255)
    @Column(name = "securitysystemyn", length = 255, nullable = false)
    private String securitysystemyn;

    @NotNull
    @Size(max = 255)
    @Column(name = "greenbuildingcertification", length = 255, nullable = false)
    private String greenbuildingcertification;

    @NotNull
    @Size(max = 255)
    @Column(name = "greenenergyefficient", length = 255, nullable = false)
    private String greenenergyefficient;

    @NotNull
    @Size(max = 255)
    @Column(name = "energysavingfeatures", length = 255, nullable = false)
    private String energysavingfeatures;

    @NotNull
    @Size(max = 255)
    @Column(name = "lotnumber", length = 255, nullable = false)
    private String lotnumber;

    @NotNull
    @Size(max = 255)
    @Column(name = "lotsizearea", length = 255, nullable = false)
    private String lotsizearea;

    @NotNull
    @Size(max = 255)
    @Column(name = "lotsizedimensions", length = 255, nullable = false)
    private String lotsizedimensions;

    @NotNull
    @Size(max = 255)
    @Column(name = "easements", length = 255, nullable = false)
    private String easements;

    @NotNull
    @Size(max = 255)
    @Column(name = "restrictions", length = 255, nullable = false)
    private String restrictions;

    @NotNull
    @Size(max = 255)
    @Column(name = "washerdryerconnections", length = 255, nullable = false)
    private String washerdryerconnections;

    @NotNull
    @Size(max = 255)
    @Column(name = "municipalutilitydistrictyn", length = 255, nullable = false)
    private String municipalutilitydistrictyn;

    @NotNull
    @Size(max = 255)
    @Column(name = "associationfeeincludes", length = 255, nullable = false)
    private String associationfeeincludes;

    @NotNull
    @Size(max = 255)
    @Column(name = "associationtype", length = 255, nullable = false)
    private String associationtype;

    @NotNull
    @Size(max = 255)
    @Column(name = "barninformation", length = 255, nullable = false)
    private String barninformation;

    @NotNull
    @Size(max = 255)
    @Column(name = "constructionmaterialswalls", length = 255, nullable = false)
    private String constructionmaterialswalls;

    @NotNull
    @Size(max = 255)
    @Column(name = "countyorparish", length = 255, nullable = false)
    private String countyorparish;

    @NotNull
    @Size(max = 255)
    @Column(name = "exteriorbuildings", length = 255, nullable = false)
    private String exteriorbuildings;

    @NotNull
    @Size(max = 255)
    @Column(name = "farmranchfeatures", length = 255, nullable = false)
    private String farmranchfeatures;

    @NotNull
    @Size(max = 255)
    @Column(name = "fencedyardyn", length = 255, nullable = false)
    private String fencedyardyn;

    @NotNull
    @Size(max = 255)
    @Column(name = "financingproposed", length = 255, nullable = false)
    private String financingproposed;

    @NotNull
    @Size(max = 255)
    @Column(name = "handicapyn", length = 255, nullable = false)
    private String handicapyn;

    @NotNull
    @Size(max = 255)
    @Column(name = "numberoftanksandponds", length = 255, nullable = false)
    private String numberoftanksandponds;

    @NotNull
    @Size(max = 255)
    @Column(name = "parcelnumber", length = 255, nullable = false)
    private String parcelnumber;

    @NotNull
    @Size(max = 255)
    @Column(name = "virtualtoururlunbranded", length = 255, nullable = false)
    private String virtualtoururlunbranded;

    @NotNull
    @Size(max = 255)
    @Column(name = "living_room_feature", length = 255, nullable = false)
    private String livingRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "master_bed_room_feature", length = 255, nullable = false)
    private String masterBedRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "bed_room_feature", length = 255, nullable = false)
    private String bedRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "dining_room_feature", length = 255, nullable = false)
    private String diningRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "kitchen_room_feature", length = 255, nullable = false)
    private String kitchenRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "breakfast_room_feature", length = 255, nullable = false)
    private String breakfastRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "study_room_feature", length = 255, nullable = false)
    private String studyRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "utility_room_feature", length = 255, nullable = false)
    private String utilityRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "full_bath_room_feature", length = 255, nullable = false)
    private String fullBathRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "half_bath_room_feature", length = 255, nullable = false)
    private String halfBathRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "exercise_room_feature", length = 255, nullable = false)
    private String exerciseRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "extra_storage_room_feature", length = 255, nullable = false)
    private String extraStorageRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "game_room_feature", length = 255, nullable = false)
    private String gameRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "guest_room_feature", length = 255, nullable = false)
    private String guestRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "library_room_feature", length = 255, nullable = false)
    private String libraryRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "media_room_feature", length = 255, nullable = false)
    private String mediaRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "mud_room_feature", length = 255, nullable = false)
    private String mudRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "office_room_feature", length = 255, nullable = false)
    private String officeRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "sauna_room_feature", length = 255, nullable = false)
    private String saunaRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "second_master_room_feature", length = 255, nullable = false)
    private String secondMasterRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "sunroom_room_feature", length = 255, nullable = false)
    private String sunroomRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "spa_room_feature", length = 255, nullable = false)
    private String spaRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "wine_room_feature", length = 255, nullable = false)
    private String wineRoomFeature;

    @NotNull
    @Size(max = 255)
    @Column(name = "other_room_feature", length = 255, nullable = false)
    private String otherRoomFeature;

    @NotNull
    @Size(max = 5)
    @Column(name = "is_luxury", length = 5, nullable = false)
    private String isLuxury;

    @NotNull
    @Size(max = 5)
    @Column(name = "is_move_in_ready", length = 5, nullable = false)
    private String isMoveInReady;

    @Size(max = 255)
    @Column(name = "photo_url", length = 255)
    private String photoUrl;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo1_url", length = 255, nullable = false)
    private String photo1Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo2_url", length = 255, nullable = false)
    private String photo2Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo3_url", length = 255, nullable = false)
    private String photo3Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo4_url", length = 255, nullable = false)
    private String photo4Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo5_url", length = 255, nullable = false)
    private String photo5Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo6_url", length = 255, nullable = false)
    private String photo6Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo7_url", length = 255, nullable = false)
    private String photo7Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo8_url", length = 255, nullable = false)
    private String photo8Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo9_url", length = 255, nullable = false)
    private String photo9Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo10_url", length = 255, nullable = false)
    private String photo10Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo11_url", length = 255, nullable = false)
    private String photo11Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo12_url", length = 255, nullable = false)
    private String photo12Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo13_url", length = 255, nullable = false)
    private String photo13Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo14_url", length = 255, nullable = false)
    private String photo14Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo15_url", length = 255, nullable = false)
    private String photo15Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo16_url", length = 255, nullable = false)
    private String photo16Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo17_url", length = 255, nullable = false)
    private String photo17Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo18_url", length = 255, nullable = false)
    private String photo18Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo19_url", length = 255, nullable = false)
    private String photo19Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo20_url", length = 255, nullable = false)
    private String photo20Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo21_url", length = 255, nullable = false)
    private String photo21Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo22_url", length = 255, nullable = false)
    private String photo22Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo23_url", length = 255, nullable = false)
    private String photo23Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo24_url", length = 255, nullable = false)
    private String photo24Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo25_url", length = 255, nullable = false)
    private String photo25Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo26_url", length = 255, nullable = false)
    private String photo26Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo27_url", length = 255, nullable = false)
    private String photo27Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo28_url", length = 255, nullable = false)
    private String photo28Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo29_url", length = 255, nullable = false)
    private String photo29Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo30_url", length = 255, nullable = false)
    private String photo30Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo31_url", length = 255, nullable = false)
    private String photo31Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo32_url", length = 255, nullable = false)
    private String photo32Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo33_url", length = 255, nullable = false)
    private String photo33Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo34_url", length = 255, nullable = false)
    private String photo34Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo35_url", length = 255, nullable = false)
    private String photo35Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo36_url", length = 255, nullable = false)
    private String photo36Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo37_url", length = 255, nullable = false)
    private String photo37Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo38_url", length = 255, nullable = false)
    private String photo38Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo39_url", length = 255, nullable = false)
    private String photo39Url;

    @NotNull
    @Size(max = 255)
    @Column(name = "photo40_url", length = 255, nullable = false)
    private String photo40Url;

    @Column(name = "created")
    private Instant created;

    @NotNull
    @Column(name = "updated", nullable = false)
    private Instant updated;

    @NotNull
    @Column(name = "modified_date", nullable = false)
    private Instant modifiedDate;

    @NotNull
    @Column(name = "img_deleted", nullable = false)
    private Boolean imgDeleted;

    @Size(max = 100)
    @Column(name = "rets_server", length = 100)
    private String retsServer;

    @NotNull
    @Size(max = 255)
    @Column(name = "permalink", length = 255, nullable = false)
    private String permalink;

    @NotNull
    @Size(max = 50)
    @Column(name = "property_tag", length = 50, nullable = false)
    private String propertyTag;

    @NotNull
    @Column(name = "buildentory_views", nullable = false)
    private Integer buildentoryViews;

    @NotNull
    @Size(max = 1000)
    @Column(name = "location", length = 1000, nullable = false)
    private String location;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ResProperties id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return this.communityId;
    }

    public ResProperties communityId(Integer communityId) {
        this.setCommunityId(communityId);
        return this;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return this.communityName;
    }

    public ResProperties communityName(String communityName) {
        this.setCommunityName(communityName);
        return this;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Integer getBuilderId() {
        return this.builderId;
    }

    public ResProperties builderId(Integer builderId) {
        this.setBuilderId(builderId);
        return this;
    }

    public void setBuilderId(Integer builderId) {
        this.builderId = builderId;
    }

    public String getSpecialOffers() {
        return this.specialOffers;
    }

    public ResProperties specialOffers(String specialOffers) {
        this.setSpecialOffers(specialOffers);
        return this;
    }

    public void setSpecialOffers(String specialOffers) {
        this.specialOffers = specialOffers;
    }

    public String getBrochure() {
        return this.brochure;
    }

    public ResProperties brochure(String brochure) {
        this.setBrochure(brochure);
        return this;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure;
    }

    public Integer getFloorPlanId() {
        return this.floorPlanId;
    }

    public ResProperties floorPlanId(Integer floorPlanId) {
        this.setFloorPlanId(floorPlanId);
        return this;
    }

    public void setFloorPlanId(Integer floorPlanId) {
        this.floorPlanId = floorPlanId;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public ResProperties latitude(String latitude) {
        this.setLatitude(latitude);
        return this;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public ResProperties longitude(String longitude) {
        this.setLongitude(longitude);
        return this;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCounty() {
        return this.county;
    }

    public ResProperties county(String county) {
        this.setCounty(county);
        return this;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getHeatsystem() {
        return this.heatsystem;
    }

    public ResProperties heatsystem(String heatsystem) {
        this.setHeatsystem(heatsystem);
        return this;
    }

    public void setHeatsystem(String heatsystem) {
        this.heatsystem = heatsystem;
    }

    public String getListstatus() {
        return this.liststatus;
    }

    public ResProperties liststatus(String liststatus) {
        this.setListstatus(liststatus);
        return this;
    }

    public void setListstatus(String liststatus) {
        this.liststatus = liststatus;
    }

    public String getListstatusflag() {
        return this.liststatusflag;
    }

    public ResProperties liststatusflag(String liststatusflag) {
        this.setListstatusflag(liststatusflag);
        return this;
    }

    public void setListstatusflag(String liststatusflag) {
        this.liststatusflag = liststatusflag;
    }

    public String getCarportcap() {
        return this.carportcap;
    }

    public ResProperties carportcap(String carportcap) {
        this.setCarportcap(carportcap);
        return this;
    }

    public void setCarportcap(String carportcap) {
        this.carportcap = carportcap;
    }

    public String getPossession() {
        return this.possession;
    }

    public ResProperties possession(String possession) {
        this.setPossession(possession);
        return this;
    }

    public void setPossession(String possession) {
        this.possession = possession;
    }

    public String getSchoolname1() {
        return this.schoolname1;
    }

    public ResProperties schoolname1(String schoolname1) {
        this.setSchoolname1(schoolname1);
        return this;
    }

    public void setSchoolname1(String schoolname1) {
        this.schoolname1 = schoolname1;
    }

    public String getSubdivide() {
        return this.subdivide;
    }

    public ResProperties subdivide(String subdivide) {
        this.setSubdivide(subdivide);
        return this;
    }

    public void setSubdivide(String subdivide) {
        this.subdivide = subdivide;
    }

    public String getVowavmyn() {
        return this.vowavmyn;
    }

    public ResProperties vowavmyn(String vowavmyn) {
        this.setVowavmyn(vowavmyn);
        return this;
    }

    public void setVowavmyn(String vowavmyn) {
        this.vowavmyn = vowavmyn;
    }

    public String getPresentuse() {
        return this.presentuse;
    }

    public ResProperties presentuse(String presentuse) {
        this.setPresentuse(presentuse);
        return this;
    }

    public void setPresentuse(String presentuse) {
        this.presentuse = presentuse;
    }

    public String getProposeduse() {
        return this.proposeduse;
    }

    public ResProperties proposeduse(String proposeduse) {
        this.setProposeduse(proposeduse);
        return this;
    }

    public void setProposeduse(String proposeduse) {
        this.proposeduse = proposeduse;
    }

    public String getRanchname() {
        return this.ranchname;
    }

    public ResProperties ranchname(String ranchname) {
        this.setRanchname(ranchname);
        return this;
    }

    public void setRanchname(String ranchname) {
        this.ranchname = ranchname;
    }

    public Integer getRoombed2width() {
        return this.roombed2width;
    }

    public ResProperties roombed2width(Integer roombed2width) {
        this.setRoombed2width(roombed2width);
        return this;
    }

    public void setRoombed2width(Integer roombed2width) {
        this.roombed2width = roombed2width;
    }

    public String getRoomdininglevel() {
        return this.roomdininglevel;
    }

    public ResProperties roomdininglevel(String roomdininglevel) {
        this.setRoomdininglevel(roomdininglevel);
        return this;
    }

    public void setRoomdininglevel(String roomdininglevel) {
        this.roomdininglevel = roomdininglevel;
    }

    public Integer getRoomliving2width() {
        return this.roomliving2width;
    }

    public ResProperties roomliving2width(Integer roomliving2width) {
        this.setRoomliving2width(roomliving2width);
        return this;
    }

    public void setRoomliving2width(Integer roomliving2width) {
        this.roomliving2width = roomliving2width;
    }

    public String getRoomstudylevel() {
        return this.roomstudylevel;
    }

    public ResProperties roomstudylevel(String roomstudylevel) {
        this.setRoomstudylevel(roomstudylevel);
        return this;
    }

    public void setRoomstudylevel(String roomstudylevel) {
        this.roomstudylevel = roomstudylevel;
    }

    public Integer getArea() {
        return this.area;
    }

    public ResProperties area(Integer area) {
        this.setArea(area);
        return this;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getAreatitle() {
        return this.areatitle;
    }

    public ResProperties areatitle(String areatitle) {
        this.setAreatitle(areatitle);
        return this;
    }

    public void setAreatitle(String areatitle) {
        this.areatitle = areatitle;
    }

    public Integer getAssocfee() {
        return this.assocfee;
    }

    public ResProperties assocfee(Integer assocfee) {
        this.setAssocfee(assocfee);
        return this;
    }

    public void setAssocfee(Integer assocfee) {
        this.assocfee = assocfee;
    }

    public String getFinanceproposed() {
        return this.financeproposed;
    }

    public ResProperties financeproposed(String financeproposed) {
        this.setFinanceproposed(financeproposed);
        return this;
    }

    public void setFinanceproposed(String financeproposed) {
        this.financeproposed = financeproposed;
    }

    public Integer getListpriceorig() {
        return this.listpriceorig;
    }

    public ResProperties listpriceorig(Integer listpriceorig) {
        this.setListpriceorig(listpriceorig);
        return this;
    }

    public void setListpriceorig(Integer listpriceorig) {
        this.listpriceorig = listpriceorig;
    }

    public String getMapcoord() {
        return this.mapcoord;
    }

    public ResProperties mapcoord(String mapcoord) {
        this.setMapcoord(mapcoord);
        return this;
    }

    public void setMapcoord(String mapcoord) {
        this.mapcoord = mapcoord;
    }

    public String getSchoolname2() {
        return this.schoolname2;
    }

    public ResProperties schoolname2(String schoolname2) {
        this.setSchoolname2(schoolname2);
        return this;
    }

    public void setSchoolname2(String schoolname2) {
        this.schoolname2 = schoolname2;
    }

    public Integer getRoomgaragewidth() {
        return this.roomgaragewidth;
    }

    public ResProperties roomgaragewidth(Integer roomgaragewidth) {
        this.setRoomgaragewidth(roomgaragewidth);
        return this;
    }

    public void setRoomgaragewidth(Integer roomgaragewidth) {
        this.roomgaragewidth = roomgaragewidth;
    }

    public String getRoomkitchendesc() {
        return this.roomkitchendesc;
    }

    public ResProperties roomkitchendesc(String roomkitchendesc) {
        this.setRoomkitchendesc(roomkitchendesc);
        return this;
    }

    public void setRoomkitchendesc(String roomkitchendesc) {
        this.roomkitchendesc = roomkitchendesc;
    }

    public Integer getRoomliving1width() {
        return this.roomliving1width;
    }

    public ResProperties roomliving1width(Integer roomliving1width) {
        this.setRoomliving1width(roomliving1width);
        return this;
    }

    public void setRoomliving1width(Integer roomliving1width) {
        this.roomliving1width = roomliving1width;
    }

    public Integer getRoomother2width() {
        return this.roomother2width;
    }

    public ResProperties roomother2width(Integer roomother2width) {
        this.setRoomother2width(roomother2width);
        return this;
    }

    public void setRoomother2width(Integer roomother2width) {
        this.roomother2width = roomother2width;
    }

    public Integer getSqfttotal() {
        return this.sqfttotal;
    }

    public ResProperties sqfttotal(Integer sqfttotal) {
        this.setSqfttotal(sqfttotal);
        return this;
    }

    public void setSqfttotal(Integer sqfttotal) {
        this.sqfttotal = sqfttotal;
    }

    public String getOfficelistOfficenam1() {
        return this.officelistOfficenam1;
    }

    public ResProperties officelistOfficenam1(String officelistOfficenam1) {
        this.setOfficelistOfficenam1(officelistOfficenam1);
        return this;
    }

    public void setOfficelistOfficenam1(String officelistOfficenam1) {
        this.officelistOfficenam1 = officelistOfficenam1;
    }

    public String getSchoolname3() {
        return this.schoolname3;
    }

    public ResProperties schoolname3(String schoolname3) {
        this.setSchoolname3(schoolname3);
        return this;
    }

    public void setSchoolname3(String schoolname3) {
        this.schoolname3 = schoolname3;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public ResProperties zipcode(String zipcode) {
        this.setZipcode(zipcode);
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getBarn1length() {
        return this.barn1length;
    }

    public ResProperties barn1length(Integer barn1length) {
        this.setBarn1length(barn1length);
        return this;
    }

    public void setBarn1length(Integer barn1length) {
        this.barn1length = barn1length;
    }

    public Integer getBarn3width() {
        return this.barn3width;
    }

    public ResProperties barn3width(Integer barn3width) {
        this.setBarn3width(barn3width);
        return this;
    }

    public void setBarn3width(Integer barn3width) {
        this.barn3width = barn3width;
    }

    public Integer getRoombed2length() {
        return this.roombed2length;
    }

    public ResProperties roombed2length(Integer roombed2length) {
        this.setRoombed2length(roombed2length);
        return this;
    }

    public void setRoombed2length(Integer roombed2length) {
        this.roombed2length = roombed2length;
    }

    public Integer getRoombed3length() {
        return this.roombed3length;
    }

    public ResProperties roombed3length(Integer roombed3length) {
        this.setRoombed3length(roombed3length);
        return this;
    }

    public void setRoombed3length(Integer roombed3length) {
        this.roombed3length = roombed3length;
    }

    public Integer getRoomother1width() {
        return this.roomother1width;
    }

    public ResProperties roomother1width(Integer roomother1width) {
        this.setRoomother1width(roomother1width);
        return this;
    }

    public void setRoomother1width(Integer roomother1width) {
        this.roomother1width = roomother1width;
    }

    public String getAgentlistFullname() {
        return this.agentlistFullname;
    }

    public ResProperties agentlistFullname(String agentlistFullname) {
        this.setAgentlistFullname(agentlistFullname);
        return this;
    }

    public void setAgentlistFullname(String agentlistFullname) {
        this.agentlistFullname = agentlistFullname;
    }

    public String getProptype() {
        return this.proptype;
    }

    public ResProperties proptype(String proptype) {
        this.setProptype(proptype);
        return this;
    }

    public void setProptype(String proptype) {
        this.proptype = proptype;
    }

    public String getMlsProptype() {
        return this.mlsProptype;
    }

    public ResProperties mlsProptype(String mlsProptype) {
        this.setMlsProptype(mlsProptype);
        return this;
    }

    public void setMlsProptype(String mlsProptype) {
        this.mlsProptype = mlsProptype;
    }

    public String getSchoolname4() {
        return this.schoolname4;
    }

    public ResProperties schoolname4(String schoolname4) {
        this.setSchoolname4(schoolname4);
        return this;
    }

    public void setSchoolname4(String schoolname4) {
        this.schoolname4 = schoolname4;
    }

    public BigDecimal getAcrescultivated() {
        return this.acrescultivated;
    }

    public ResProperties acrescultivated(BigDecimal acrescultivated) {
        this.setAcrescultivated(acrescultivated);
        return this;
    }

    public void setAcrescultivated(BigDecimal acrescultivated) {
        this.acrescultivated = acrescultivated;
    }

    public Integer getBarn2length() {
        return this.barn2length;
    }

    public ResProperties barn2length(Integer barn2length) {
        this.setBarn2length(barn2length);
        return this;
    }

    public void setBarn2length(Integer barn2length) {
        this.barn2length = barn2length;
    }

    public Integer getBarn2width() {
        return this.barn2width;
    }

    public ResProperties barn2width(Integer barn2width) {
        this.setBarn2width(barn2width);
        return this;
    }

    public void setBarn2width(Integer barn2width) {
        this.barn2width = barn2width;
    }

    public String getComplexname() {
        return this.complexname;
    }

    public ResProperties complexname(String complexname) {
        this.setComplexname(complexname);
        return this;
    }

    public void setComplexname(String complexname) {
        this.complexname = complexname;
    }

    public Integer getRoombed4length() {
        return this.roombed4length;
    }

    public ResProperties roombed4length(Integer roombed4length) {
        this.setRoombed4length(roombed4length);
        return this;
    }

    public void setRoombed4length(Integer roombed4length) {
        this.roombed4length = roombed4length;
    }

    public String getRoombedbathdesc() {
        return this.roombedbathdesc;
    }

    public ResProperties roombedbathdesc(String roombedbathdesc) {
        this.setRoombedbathdesc(roombedbathdesc);
        return this;
    }

    public void setRoombedbathdesc(String roombedbathdesc) {
        this.roombedbathdesc = roombedbathdesc;
    }

    public Integer getRoombreakfastwidth() {
        return this.roombreakfastwidth;
    }

    public ResProperties roombreakfastwidth(Integer roombreakfastwidth) {
        this.setRoombreakfastwidth(roombreakfastwidth);
        return this;
    }

    public void setRoombreakfastwidth(Integer roombreakfastwidth) {
        this.roombreakfastwidth = roombreakfastwidth;
    }

    public String getRoomother() {
        return this.roomother;
    }

    public ResProperties roomother(String roomother) {
        this.setRoomother(roomother);
        return this;
    }

    public void setRoomother(String roomother) {
        this.roomother = roomother;
    }

    public Integer getRoomutilitylength() {
        return this.roomutilitylength;
    }

    public ResProperties roomutilitylength(Integer roomutilitylength) {
        this.setRoomutilitylength(roomutilitylength);
        return this;
    }

    public void setRoomutilitylength(Integer roomutilitylength) {
        this.roomutilitylength = roomutilitylength;
    }

    public BigDecimal getAcres() {
        return this.acres;
    }

    public ResProperties acres(BigDecimal acres) {
        this.setAcres(acres);
        return this;
    }

    public void setAcres(BigDecimal acres) {
        this.acres = acres;
    }

    public String getBlock() {
        return this.block;
    }

    public ResProperties block(String block) {
        this.setBlock(block);
        return this;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getDirections() {
        return this.directions;
    }

    public ResProperties directions(String directions) {
        this.setDirections(directions);
        return this;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getSubdivision() {
        return this.subdivision;
    }

    public ResProperties subdivision(String subdivision) {
        this.setSubdivision(subdivision);
        return this;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public Integer getYearbuilt() {
        return this.yearbuilt;
    }

    public ResProperties yearbuilt(Integer yearbuilt) {
        this.setYearbuilt(yearbuilt);
        return this;
    }

    public void setYearbuilt(Integer yearbuilt) {
        this.yearbuilt = yearbuilt;
    }

    public String getYearbuiltdetails() {
        return this.yearbuiltdetails;
    }

    public ResProperties yearbuiltdetails(String yearbuiltdetails) {
        this.setYearbuiltdetails(yearbuiltdetails);
        return this;
    }

    public void setYearbuiltdetails(String yearbuiltdetails) {
        this.yearbuiltdetails = yearbuiltdetails;
    }

    public String getAgexemption() {
        return this.agexemption;
    }

    public ResProperties agexemption(String agexemption) {
        this.setAgexemption(agexemption);
        return this;
    }

    public void setAgexemption(String agexemption) {
        this.agexemption = agexemption;
    }

    public Integer getBarn1width() {
        return this.barn1width;
    }

    public ResProperties barn1width(Integer barn1width) {
        this.setBarn1width(barn1width);
        return this;
    }

    public void setBarn1width(Integer barn1width) {
        this.barn1width = barn1width;
    }

    public Integer getBarn3length() {
        return this.barn3length;
    }

    public ResProperties barn3length(Integer barn3length) {
        this.setBarn3length(barn3length);
        return this;
    }

    public void setBarn3length(Integer barn3length) {
        this.barn3length = barn3length;
    }

    public Integer getRoomdiningwidth() {
        return this.roomdiningwidth;
    }

    public ResProperties roomdiningwidth(Integer roomdiningwidth) {
        this.setRoomdiningwidth(roomdiningwidth);
        return this;
    }

    public void setRoomdiningwidth(Integer roomdiningwidth) {
        this.roomdiningwidth = roomdiningwidth;
    }

    public Integer getRoomstudywidth() {
        return this.roomstudywidth;
    }

    public ResProperties roomstudywidth(Integer roomstudywidth) {
        this.setRoomstudywidth(roomstudywidth);
        return this;
    }

    public void setRoomstudywidth(Integer roomstudywidth) {
        this.roomstudywidth = roomstudywidth;
    }

    public String getSoiltype() {
        return this.soiltype;
    }

    public ResProperties soiltype(String soiltype) {
        this.setSoiltype(soiltype);
        return this;
    }

    public void setSoiltype(String soiltype) {
        this.soiltype = soiltype;
    }

    public String getAppraisername() {
        return this.appraisername;
    }

    public ResProperties appraisername(String appraisername) {
        this.setAppraisername(appraisername);
        return this;
    }

    public void setAppraisername(String appraisername) {
        this.appraisername = appraisername;
    }

    public Integer getListpricelow() {
        return this.listpricelow;
    }

    public ResProperties listpricelow(Integer listpricelow) {
        this.setListpricelow(listpricelow);
        return this;
    }

    public void setListpricelow(Integer listpricelow) {
        this.listpricelow = listpricelow;
    }

    public String getMappage() {
        return this.mappage;
    }

    public ResProperties mappage(String mappage) {
        this.setMappage(mappage);
        return this;
    }

    public void setMappage(String mappage) {
        this.mappage = mappage;
    }

    public String getUnitnumber() {
        return this.unitnumber;
    }

    public ResProperties unitnumber(String unitnumber) {
        this.setUnitnumber(unitnumber);
        return this;
    }

    public void setUnitnumber(String unitnumber) {
        this.unitnumber = unitnumber;
    }

    public String getStreetdir() {
        return this.streetdir;
    }

    public ResProperties streetdir(String streetdir) {
        this.setStreetdir(streetdir);
        return this;
    }

    public void setStreetdir(String streetdir) {
        this.streetdir = streetdir;
    }

    public String getStreettype() {
        return this.streettype;
    }

    public ResProperties streettype(String streettype) {
        this.setStreettype(streettype);
        return this;
    }

    public void setStreettype(String streettype) {
        this.streettype = streettype;
    }

    public String getSubarea() {
        return this.subarea;
    }

    public ResProperties subarea(String subarea) {
        this.setSubarea(subarea);
        return this;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public String getSubareatitle() {
        return this.subareatitle;
    }

    public ResProperties subareatitle(String subareatitle) {
        this.setSubareatitle(subareatitle);
        return this;
    }

    public void setSubareatitle(String subareatitle) {
        this.subareatitle = subareatitle;
    }

    public Integer getBathshalf() {
        return this.bathshalf;
    }

    public ResProperties bathshalf(Integer bathshalf) {
        this.setBathshalf(bathshalf);
        return this;
    }

    public void setBathshalf(Integer bathshalf) {
        this.bathshalf = bathshalf;
    }

    public Integer getRoomgaragelength() {
        return this.roomgaragelength;
    }

    public ResProperties roomgaragelength(Integer roomgaragelength) {
        this.setRoomgaragelength(roomgaragelength);
        return this;
    }

    public void setRoomgaragelength(Integer roomgaragelength) {
        this.roomgaragelength = roomgaragelength;
    }

    public String getPropsubtype() {
        return this.propsubtype;
    }

    public ResProperties propsubtype(String propsubtype) {
        this.setPropsubtype(propsubtype);
        return this;
    }

    public void setPropsubtype(String propsubtype) {
        this.propsubtype = propsubtype;
    }

    public Integer getBeds() {
        return this.beds;
    }

    public ResProperties beds(Integer beds) {
        this.setBeds(beds);
        return this;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getRoommasterbedwidth() {
        return this.roommasterbedwidth;
    }

    public ResProperties roommasterbedwidth(Integer roommasterbedwidth) {
        this.setRoommasterbedwidth(roommasterbedwidth);
        return this;
    }

    public void setRoommasterbedwidth(Integer roommasterbedwidth) {
        this.roommasterbedwidth = roommasterbedwidth;
    }

    public Integer getRoomstudylength() {
        return this.roomstudylength;
    }

    public ResProperties roomstudylength(Integer roomstudylength) {
        this.setRoomstudylength(roomstudylength);
        return this;
    }

    public void setRoomstudylength(Integer roomstudylength) {
        this.roomstudylength = roomstudylength;
    }

    public String getAgentlist() {
        return this.agentlist;
    }

    public ResProperties agentlist(String agentlist) {
        this.setAgentlist(agentlist);
        return this;
    }

    public void setAgentlist(String agentlist) {
        this.agentlist = agentlist;
    }

    public String getStreetname() {
        return this.streetname;
    }

    public ResProperties streetname(String streetname) {
        this.setStreetname(streetname);
        return this;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public Integer getRoombreakfastlength() {
        return this.roombreakfastlength;
    }

    public ResProperties roombreakfastlength(Integer roombreakfastlength) {
        this.setRoombreakfastlength(roombreakfastlength);
        return this;
    }

    public void setRoombreakfastlength(Integer roombreakfastlength) {
        this.roombreakfastlength = roombreakfastlength;
    }

    public Integer getRoomkitchenwidth() {
        return this.roomkitchenwidth;
    }

    public ResProperties roomkitchenwidth(Integer roomkitchenwidth) {
        this.setRoomkitchenwidth(roomkitchenwidth);
        return this;
    }

    public void setRoomkitchenwidth(Integer roomkitchenwidth) {
        this.roomkitchenwidth = roomkitchenwidth;
    }

    public String getFence() {
        return this.fence;
    }

    public ResProperties fence(String fence) {
        this.setFence(fence);
        return this;
    }

    public void setFence(String fence) {
        this.fence = fence;
    }

    public BigDecimal getBathstotal() {
        return this.bathstotal;
    }

    public ResProperties bathstotal(BigDecimal bathstotal) {
        this.setBathstotal(bathstotal);
        return this;
    }

    public void setBathstotal(BigDecimal bathstotal) {
        this.bathstotal = bathstotal;
    }

    public Integer getGaragecap() {
        return this.garagecap;
    }

    public ResProperties garagecap(Integer garagecap) {
        this.setGaragecap(garagecap);
        return this;
    }

    public void setGaragecap(Integer garagecap) {
        this.garagecap = garagecap;
    }

    public BigDecimal getSqftprice() {
        return this.sqftprice;
    }

    public ResProperties sqftprice(BigDecimal sqftprice) {
        this.setSqftprice(sqftprice);
        return this;
    }

    public void setSqftprice(BigDecimal sqftprice) {
        this.sqftprice = sqftprice;
    }

    public String getStyle() {
        return this.style;
    }

    public ResProperties style(String style) {
        this.setStyle(style);
        return this;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getExterior() {
        return this.exterior;
    }

    public ResProperties exterior(String exterior) {
        this.setExterior(exterior);
        return this;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getFoundation() {
        return this.foundation;
    }

    public ResProperties foundation(String foundation) {
        this.setFoundation(foundation);
        return this;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getInterior() {
        return this.interior;
    }

    public ResProperties interior(String interior) {
        this.setInterior(interior);
        return this;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getPoolyn() {
        return this.poolyn;
    }

    public ResProperties poolyn(String poolyn) {
        this.setPoolyn(poolyn);
        return this;
    }

    public void setPoolyn(String poolyn) {
        this.poolyn = poolyn;
    }

    public String getPoolFeature() {
        return this.poolFeature;
    }

    public ResProperties poolFeature(String poolFeature) {
        this.setPoolFeature(poolFeature);
        return this;
    }

    public void setPoolFeature(String poolFeature) {
        this.poolFeature = poolFeature;
    }

    public Integer getListprice() {
        return this.listprice;
    }

    public ResProperties listprice(Integer listprice) {
        this.setListprice(listprice);
        return this;
    }

    public void setListprice(Integer listprice) {
        this.listprice = listprice;
    }

    public String getListpricerange() {
        return this.listpricerange;
    }

    public ResProperties listpricerange(String listpricerange) {
        this.setListpricerange(listpricerange);
        return this;
    }

    public void setListpricerange(String listpricerange) {
        this.listpricerange = listpricerange;
    }

    public String getMlsnum() {
        return this.mlsnum;
    }

    public ResProperties mlsnum(String mlsnum) {
        this.setMlsnum(mlsnum);
        return this;
    }

    public void setMlsnum(String mlsnum) {
        this.mlsnum = mlsnum;
    }

    public Integer getMatrixid() {
        return this.matrixid;
    }

    public ResProperties matrixid(Integer matrixid) {
        this.setMatrixid(matrixid);
        return this;
    }

    public void setMatrixid(Integer matrixid) {
        this.matrixid = matrixid;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public ResProperties remarks(String remarks) {
        this.setRemarks(remarks);
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return this.state;
    }

    public ResProperties state(String state) {
        this.setState(state);
        return this;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoof() {
        return this.roof;
    }

    public ResProperties roof(String roof) {
        this.setRoof(roof);
        return this;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getSecurityfeatures() {
        return this.securityfeatures;
    }

    public ResProperties securityfeatures(String securityfeatures) {
        this.setSecurityfeatures(securityfeatures);
        return this;
    }

    public void setSecurityfeatures(String securityfeatures) {
        this.securityfeatures = securityfeatures;
    }

    public String getUtilitiesother() {
        return this.utilitiesother;
    }

    public ResProperties utilitiesother(String utilitiesother) {
        this.setUtilitiesother(utilitiesother);
        return this;
    }

    public void setUtilitiesother(String utilitiesother) {
        this.utilitiesother = utilitiesother;
    }

    public String getCommonfeatures() {
        return this.commonfeatures;
    }

    public ResProperties commonfeatures(String commonfeatures) {
        this.setCommonfeatures(commonfeatures);
        return this;
    }

    public void setCommonfeatures(String commonfeatures) {
        this.commonfeatures = commonfeatures;
    }

    public String getConstruction() {
        return this.construction;
    }

    public ResProperties construction(String construction) {
        this.setConstruction(construction);
        return this;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Instant getModified() {
        return this.modified;
    }

    public ResProperties modified(Instant modified) {
        this.setModified(modified);
        return this;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public Integer getStories() {
        return this.stories;
    }

    public ResProperties stories(Integer stories) {
        this.setStories(stories);
        return this;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public Integer getRoomdininglength() {
        return this.roomdininglength;
    }

    public ResProperties roomdininglength(Integer roomdininglength) {
        this.setRoomdininglength(roomdininglength);
        return this;
    }

    public void setRoomdininglength(Integer roomdininglength) {
        this.roomdininglength = roomdininglength;
    }

    public Integer getRoomliving1length() {
        return this.roomliving1length;
    }

    public ResProperties roomliving1length(Integer roomliving1length) {
        this.setRoomliving1length(roomliving1length);
        return this;
    }

    public void setRoomliving1length(Integer roomliving1length) {
        this.roomliving1length = roomliving1length;
    }

    public String getOpenhousetime() {
        return this.openhousetime;
    }

    public ResProperties openhousetime(String openhousetime) {
        this.setOpenhousetime(openhousetime);
        return this;
    }

    public void setOpenhousetime(String openhousetime) {
        this.openhousetime = openhousetime;
    }

    public String getOpenhouseendtime() {
        return this.openhouseendtime;
    }

    public ResProperties openhouseendtime(String openhouseendtime) {
        this.setOpenhouseendtime(openhouseendtime);
        return this;
    }

    public void setOpenhouseendtime(String openhouseendtime) {
        this.openhouseendtime = openhouseendtime;
    }

    public Integer getRoomliving2length() {
        return this.roomliving2length;
    }

    public ResProperties roomliving2length(Integer roomliving2length) {
        this.setRoomliving2length(roomliving2length);
        return this;
    }

    public void setRoomliving2length(Integer roomliving2length) {
        this.roomliving2length = roomliving2length;
    }

    public String getLotdesc() {
        return this.lotdesc;
    }

    public ResProperties lotdesc(String lotdesc) {
        this.setLotdesc(lotdesc);
        return this;
    }

    public void setLotdesc(String lotdesc) {
        this.lotdesc = lotdesc;
    }

    public Instant getOpenhousedate() {
        return this.openhousedate;
    }

    public ResProperties openhousedate(Instant openhousedate) {
        this.setOpenhousedate(openhousedate);
        return this;
    }

    public void setOpenhousedate(Instant openhousedate) {
        this.openhousedate = openhousedate;
    }

    public Integer getRoommasterbedlength() {
        return this.roommasterbedlength;
    }

    public ResProperties roommasterbedlength(Integer roommasterbedlength) {
        this.setRoommasterbedlength(roommasterbedlength);
        return this;
    }

    public void setRoommasterbedlength(Integer roommasterbedlength) {
        this.roommasterbedlength = roommasterbedlength;
    }

    public Integer getRoomother1length() {
        return this.roomother1length;
    }

    public ResProperties roomother1length(Integer roomother1length) {
        this.setRoomother1length(roomother1length);
        return this;
    }

    public void setRoomother1length(Integer roomother1length) {
        this.roomother1length = roomother1length;
    }

    public String getOfficesellOfficenam2() {
        return this.officesellOfficenam2;
    }

    public ResProperties officesellOfficenam2(String officesellOfficenam2) {
        this.setOfficesellOfficenam2(officesellOfficenam2);
        return this;
    }

    public void setOfficesellOfficenam2(String officesellOfficenam2) {
        this.officesellOfficenam2 = officesellOfficenam2;
    }

    public String getLotsize() {
        return this.lotsize;
    }

    public ResProperties lotsize(String lotsize) {
        this.setLotsize(lotsize);
        return this;
    }

    public void setLotsize(String lotsize) {
        this.lotsize = lotsize;
    }

    public String getStreetdirsuffix() {
        return this.streetdirsuffix;
    }

    public ResProperties streetdirsuffix(String streetdirsuffix) {
        this.setStreetdirsuffix(streetdirsuffix);
        return this;
    }

    public void setStreetdirsuffix(String streetdirsuffix) {
        this.streetdirsuffix = streetdirsuffix;
    }

    public Integer getPhotocount() {
        return this.photocount;
    }

    public ResProperties photocount(Integer photocount) {
        this.setPhotocount(photocount);
        return this;
    }

    public void setPhotocount(Integer photocount) {
        this.photocount = photocount;
    }

    public String getSchooldistrict() {
        return this.schooldistrict;
    }

    public ResProperties schooldistrict(String schooldistrict) {
        this.setSchooldistrict(schooldistrict);
        return this;
    }

    public void setSchooldistrict(String schooldistrict) {
        this.schooldistrict = schooldistrict;
    }

    public Integer getStreetnum() {
        return this.streetnum;
    }

    public ResProperties streetnum(Integer streetnum) {
        this.setStreetnum(streetnum);
        return this;
    }

    public void setStreetnum(Integer streetnum) {
        this.streetnum = streetnum;
    }

    public String getUtilities() {
        return this.utilities;
    }

    public ResProperties utilities(String utilities) {
        this.setUtilities(utilities);
        return this;
    }

    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }

    public String getEquipment() {
        return this.equipment;
    }

    public ResProperties equipment(String equipment) {
        this.setEquipment(equipment);
        return this;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Integer getRoombed4width() {
        return this.roombed4width;
    }

    public ResProperties roombed4width(Integer roombed4width) {
        this.setRoombed4width(roombed4width);
        return this;
    }

    public void setRoombed4width(Integer roombed4width) {
        this.roombed4width = roombed4width;
    }

    public Integer getRoomkitchenlength() {
        return this.roomkitchenlength;
    }

    public ResProperties roomkitchenlength(Integer roomkitchenlength) {
        this.setRoomkitchenlength(roomkitchenlength);
        return this;
    }

    public void setRoomkitchenlength(Integer roomkitchenlength) {
        this.roomkitchenlength = roomkitchenlength;
    }

    public String getCity() {
        return this.city;
    }

    public ResProperties city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGaragedesc() {
        return this.garagedesc;
    }

    public ResProperties garagedesc(String garagedesc) {
        this.setGaragedesc(garagedesc);
        return this;
    }

    public void setGaragedesc(String garagedesc) {
        this.garagedesc = garagedesc;
    }

    public Integer getBathsfull() {
        return this.bathsfull;
    }

    public ResProperties bathsfull(Integer bathsfull) {
        this.setBathsfull(bathsfull);
        return this;
    }

    public void setBathsfull(Integer bathsfull) {
        this.bathsfull = bathsfull;
    }

    public Integer getRoombed3width() {
        return this.roombed3width;
    }

    public ResProperties roombed3width(Integer roombed3width) {
        this.setRoombed3width(roombed3width);
        return this;
    }

    public void setRoombed3width(Integer roombed3width) {
        this.roombed3width = roombed3width;
    }

    public String getRoomutildesc() {
        return this.roomutildesc;
    }

    public ResProperties roomutildesc(String roomutildesc) {
        this.setRoomutildesc(roomutildesc);
        return this;
    }

    public void setRoomutildesc(String roomutildesc) {
        this.roomutildesc = roomutildesc;
    }

    public Integer getRoomutilitywidth() {
        return this.roomutilitywidth;
    }

    public ResProperties roomutilitywidth(Integer roomutilitywidth) {
        this.setRoomutilitywidth(roomutilitywidth);
        return this;
    }

    public void setRoomutilitywidth(Integer roomutilitywidth) {
        this.roomutilitywidth = roomutilitywidth;
    }

    public String getRoomfullbathlength() {
        return this.roomfullbathlength;
    }

    public ResProperties roomfullbathlength(String roomfullbathlength) {
        this.setRoomfullbathlength(roomfullbathlength);
        return this;
    }

    public void setRoomfullbathlength(String roomfullbathlength) {
        this.roomfullbathlength = roomfullbathlength;
    }

    public String getRoomfullbathwidth() {
        return this.roomfullbathwidth;
    }

    public ResProperties roomfullbathwidth(String roomfullbathwidth) {
        this.setRoomfullbathwidth(roomfullbathwidth);
        return this;
    }

    public void setRoomfullbathwidth(String roomfullbathwidth) {
        this.roomfullbathwidth = roomfullbathwidth;
    }

    public String getRoomhalfbathlength() {
        return this.roomhalfbathlength;
    }

    public ResProperties roomhalfbathlength(String roomhalfbathlength) {
        this.setRoomhalfbathlength(roomhalfbathlength);
        return this;
    }

    public void setRoomhalfbathlength(String roomhalfbathlength) {
        this.roomhalfbathlength = roomhalfbathlength;
    }

    public String getRoomhalfbathwidth() {
        return this.roomhalfbathwidth;
    }

    public ResProperties roomhalfbathwidth(String roomhalfbathwidth) {
        this.setRoomhalfbathwidth(roomhalfbathwidth);
        return this;
    }

    public void setRoomhalfbathwidth(String roomhalfbathwidth) {
        this.roomhalfbathwidth = roomhalfbathwidth;
    }

    public String getRoomexerciselength() {
        return this.roomexerciselength;
    }

    public ResProperties roomexerciselength(String roomexerciselength) {
        this.setRoomexerciselength(roomexerciselength);
        return this;
    }

    public void setRoomexerciselength(String roomexerciselength) {
        this.roomexerciselength = roomexerciselength;
    }

    public String getRoomexercisewidth() {
        return this.roomexercisewidth;
    }

    public ResProperties roomexercisewidth(String roomexercisewidth) {
        this.setRoomexercisewidth(roomexercisewidth);
        return this;
    }

    public void setRoomexercisewidth(String roomexercisewidth) {
        this.roomexercisewidth = roomexercisewidth;
    }

    public String getRoomstoragelength() {
        return this.roomstoragelength;
    }

    public ResProperties roomstoragelength(String roomstoragelength) {
        this.setRoomstoragelength(roomstoragelength);
        return this;
    }

    public void setRoomstoragelength(String roomstoragelength) {
        this.roomstoragelength = roomstoragelength;
    }

    public String getRoomstoragewidth() {
        return this.roomstoragewidth;
    }

    public ResProperties roomstoragewidth(String roomstoragewidth) {
        this.setRoomstoragewidth(roomstoragewidth);
        return this;
    }

    public void setRoomstoragewidth(String roomstoragewidth) {
        this.roomstoragewidth = roomstoragewidth;
    }

    public String getRoomgamelength() {
        return this.roomgamelength;
    }

    public ResProperties roomgamelength(String roomgamelength) {
        this.setRoomgamelength(roomgamelength);
        return this;
    }

    public void setRoomgamelength(String roomgamelength) {
        this.roomgamelength = roomgamelength;
    }

    public String getRoomgamewidth() {
        return this.roomgamewidth;
    }

    public ResProperties roomgamewidth(String roomgamewidth) {
        this.setRoomgamewidth(roomgamewidth);
        return this;
    }

    public void setRoomgamewidth(String roomgamewidth) {
        this.roomgamewidth = roomgamewidth;
    }

    public String getRoomguestlength() {
        return this.roomguestlength;
    }

    public ResProperties roomguestlength(String roomguestlength) {
        this.setRoomguestlength(roomguestlength);
        return this;
    }

    public void setRoomguestlength(String roomguestlength) {
        this.roomguestlength = roomguestlength;
    }

    public String getRoomguestwidth() {
        return this.roomguestwidth;
    }

    public ResProperties roomguestwidth(String roomguestwidth) {
        this.setRoomguestwidth(roomguestwidth);
        return this;
    }

    public void setRoomguestwidth(String roomguestwidth) {
        this.roomguestwidth = roomguestwidth;
    }

    public String getRoomlibrarylength() {
        return this.roomlibrarylength;
    }

    public ResProperties roomlibrarylength(String roomlibrarylength) {
        this.setRoomlibrarylength(roomlibrarylength);
        return this;
    }

    public void setRoomlibrarylength(String roomlibrarylength) {
        this.roomlibrarylength = roomlibrarylength;
    }

    public String getRoomlibrarywidth() {
        return this.roomlibrarywidth;
    }

    public ResProperties roomlibrarywidth(String roomlibrarywidth) {
        this.setRoomlibrarywidth(roomlibrarywidth);
        return this;
    }

    public void setRoomlibrarywidth(String roomlibrarywidth) {
        this.roomlibrarywidth = roomlibrarywidth;
    }

    public String getRoommedialength() {
        return this.roommedialength;
    }

    public ResProperties roommedialength(String roommedialength) {
        this.setRoommedialength(roommedialength);
        return this;
    }

    public void setRoommedialength(String roommedialength) {
        this.roommedialength = roommedialength;
    }

    public String getRoommediawidth() {
        return this.roommediawidth;
    }

    public ResProperties roommediawidth(String roommediawidth) {
        this.setRoommediawidth(roommediawidth);
        return this;
    }

    public void setRoommediawidth(String roommediawidth) {
        this.roommediawidth = roommediawidth;
    }

    public String getRoommudlength() {
        return this.roommudlength;
    }

    public ResProperties roommudlength(String roommudlength) {
        this.setRoommudlength(roommudlength);
        return this;
    }

    public void setRoommudlength(String roommudlength) {
        this.roommudlength = roommudlength;
    }

    public String getRoommudwidth() {
        return this.roommudwidth;
    }

    public ResProperties roommudwidth(String roommudwidth) {
        this.setRoommudwidth(roommudwidth);
        return this;
    }

    public void setRoommudwidth(String roommudwidth) {
        this.roommudwidth = roommudwidth;
    }

    public String getRoomofficelength() {
        return this.roomofficelength;
    }

    public ResProperties roomofficelength(String roomofficelength) {
        this.setRoomofficelength(roomofficelength);
        return this;
    }

    public void setRoomofficelength(String roomofficelength) {
        this.roomofficelength = roomofficelength;
    }

    public String getRoomofficewidth() {
        return this.roomofficewidth;
    }

    public ResProperties roomofficewidth(String roomofficewidth) {
        this.setRoomofficewidth(roomofficewidth);
        return this;
    }

    public void setRoomofficewidth(String roomofficewidth) {
        this.roomofficewidth = roomofficewidth;
    }

    public String getRoomsaunalength() {
        return this.roomsaunalength;
    }

    public ResProperties roomsaunalength(String roomsaunalength) {
        this.setRoomsaunalength(roomsaunalength);
        return this;
    }

    public void setRoomsaunalength(String roomsaunalength) {
        this.roomsaunalength = roomsaunalength;
    }

    public String getRoomsaunawidth() {
        return this.roomsaunawidth;
    }

    public ResProperties roomsaunawidth(String roomsaunawidth) {
        this.setRoomsaunawidth(roomsaunawidth);
        return this;
    }

    public void setRoomsaunawidth(String roomsaunawidth) {
        this.roomsaunawidth = roomsaunawidth;
    }

    public String getRoomsecondmasterlength() {
        return this.roomsecondmasterlength;
    }

    public ResProperties roomsecondmasterlength(String roomsecondmasterlength) {
        this.setRoomsecondmasterlength(roomsecondmasterlength);
        return this;
    }

    public void setRoomsecondmasterlength(String roomsecondmasterlength) {
        this.roomsecondmasterlength = roomsecondmasterlength;
    }

    public String getRoomsecondmasterwidth() {
        return this.roomsecondmasterwidth;
    }

    public ResProperties roomsecondmasterwidth(String roomsecondmasterwidth) {
        this.setRoomsecondmasterwidth(roomsecondmasterwidth);
        return this;
    }

    public void setRoomsecondmasterwidth(String roomsecondmasterwidth) {
        this.roomsecondmasterwidth = roomsecondmasterwidth;
    }

    public String getRoomsunlength() {
        return this.roomsunlength;
    }

    public ResProperties roomsunlength(String roomsunlength) {
        this.setRoomsunlength(roomsunlength);
        return this;
    }

    public void setRoomsunlength(String roomsunlength) {
        this.roomsunlength = roomsunlength;
    }

    public String getRoomsunwidth() {
        return this.roomsunwidth;
    }

    public ResProperties roomsunwidth(String roomsunwidth) {
        this.setRoomsunwidth(roomsunwidth);
        return this;
    }

    public void setRoomsunwidth(String roomsunwidth) {
        this.roomsunwidth = roomsunwidth;
    }

    public String getRoomspalength() {
        return this.roomspalength;
    }

    public ResProperties roomspalength(String roomspalength) {
        this.setRoomspalength(roomspalength);
        return this;
    }

    public void setRoomspalength(String roomspalength) {
        this.roomspalength = roomspalength;
    }

    public String getRoomspawidth() {
        return this.roomspawidth;
    }

    public ResProperties roomspawidth(String roomspawidth) {
        this.setRoomspawidth(roomspawidth);
        return this;
    }

    public void setRoomspawidth(String roomspawidth) {
        this.roomspawidth = roomspawidth;
    }

    public String getRoomwinelength() {
        return this.roomwinelength;
    }

    public ResProperties roomwinelength(String roomwinelength) {
        this.setRoomwinelength(roomwinelength);
        return this;
    }

    public void setRoomwinelength(String roomwinelength) {
        this.roomwinelength = roomwinelength;
    }

    public String getRoomwinewidth() {
        return this.roomwinewidth;
    }

    public ResProperties roomwinewidth(String roomwinewidth) {
        this.setRoomwinewidth(roomwinewidth);
        return this;
    }

    public void setRoomwinewidth(String roomwinewidth) {
        this.roomwinewidth = roomwinewidth;
    }

    public String getJuniorhighschoolname() {
        return this.juniorhighschoolname;
    }

    public ResProperties juniorhighschoolname(String juniorhighschoolname) {
        this.setJuniorhighschoolname(juniorhighschoolname);
        return this;
    }

    public void setJuniorhighschoolname(String juniorhighschoolname) {
        this.juniorhighschoolname = juniorhighschoolname;
    }

    public String getPrimaryschoolname() {
        return this.primaryschoolname;
    }

    public ResProperties primaryschoolname(String primaryschoolname) {
        this.setPrimaryschoolname(primaryschoolname);
        return this;
    }

    public void setPrimaryschoolname(String primaryschoolname) {
        this.primaryschoolname = primaryschoolname;
    }

    public String getSeniorhighschoolname() {
        return this.seniorhighschoolname;
    }

    public ResProperties seniorhighschoolname(String seniorhighschoolname) {
        this.setSeniorhighschoolname(seniorhighschoolname);
        return this;
    }

    public void setSeniorhighschoolname(String seniorhighschoolname) {
        this.seniorhighschoolname = seniorhighschoolname;
    }

    public String getAssociationfee() {
        return this.associationfee;
    }

    public ResProperties associationfee(String associationfee) {
        this.setAssociationfee(associationfee);
        return this;
    }

    public void setAssociationfee(String associationfee) {
        this.associationfee = associationfee;
    }

    public String getAssociationfeefrequency() {
        return this.associationfeefrequency;
    }

    public ResProperties associationfeefrequency(String associationfeefrequency) {
        this.setAssociationfeefrequency(associationfeefrequency);
        return this;
    }

    public void setAssociationfeefrequency(String associationfeefrequency) {
        this.associationfeefrequency = associationfeefrequency;
    }

    public String getConstructionmaterials() {
        return this.constructionmaterials;
    }

    public ResProperties constructionmaterials(String constructionmaterials) {
        this.setConstructionmaterials(constructionmaterials);
        return this;
    }

    public void setConstructionmaterials(String constructionmaterials) {
        this.constructionmaterials = constructionmaterials;
    }

    public String getHeating() {
        return this.heating;
    }

    public ResProperties heating(String heating) {
        this.setHeating(heating);
        return this;
    }

    public void setHeating(String heating) {
        this.heating = heating;
    }

    public String getAccessoryunittype() {
        return this.accessoryunittype;
    }

    public ResProperties accessoryunittype(String accessoryunittype) {
        this.setAccessoryunittype(accessoryunittype);
        return this;
    }

    public void setAccessoryunittype(String accessoryunittype) {
        this.accessoryunittype = accessoryunittype;
    }

    public String getAccessoryunityn() {
        return this.accessoryunityn;
    }

    public ResProperties accessoryunityn(String accessoryunityn) {
        this.setAccessoryunityn(accessoryunityn);
        return this;
    }

    public void setAccessoryunityn(String accessoryunityn) {
        this.accessoryunityn = accessoryunityn;
    }

    public String getFlooring() {
        return this.flooring;
    }

    public ResProperties flooring(String flooring) {
        this.setFlooring(flooring);
        return this;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getFireplacestotal() {
        return this.fireplacestotal;
    }

    public ResProperties fireplacestotal(String fireplacestotal) {
        this.setFireplacestotal(fireplacestotal);
        return this;
    }

    public void setFireplacestotal(String fireplacestotal) {
        this.fireplacestotal = fireplacestotal;
    }

    public String getFireplacefeatures() {
        return this.fireplacefeatures;
    }

    public ResProperties fireplacefeatures(String fireplacefeatures) {
        this.setFireplacefeatures(fireplacefeatures);
        return this;
    }

    public void setFireplacefeatures(String fireplacefeatures) {
        this.fireplacefeatures = fireplacefeatures;
    }

    public String getSecuritysystemyn() {
        return this.securitysystemyn;
    }

    public ResProperties securitysystemyn(String securitysystemyn) {
        this.setSecuritysystemyn(securitysystemyn);
        return this;
    }

    public void setSecuritysystemyn(String securitysystemyn) {
        this.securitysystemyn = securitysystemyn;
    }

    public String getGreenbuildingcertification() {
        return this.greenbuildingcertification;
    }

    public ResProperties greenbuildingcertification(String greenbuildingcertification) {
        this.setGreenbuildingcertification(greenbuildingcertification);
        return this;
    }

    public void setGreenbuildingcertification(String greenbuildingcertification) {
        this.greenbuildingcertification = greenbuildingcertification;
    }

    public String getGreenenergyefficient() {
        return this.greenenergyefficient;
    }

    public ResProperties greenenergyefficient(String greenenergyefficient) {
        this.setGreenenergyefficient(greenenergyefficient);
        return this;
    }

    public void setGreenenergyefficient(String greenenergyefficient) {
        this.greenenergyefficient = greenenergyefficient;
    }

    public String getEnergysavingfeatures() {
        return this.energysavingfeatures;
    }

    public ResProperties energysavingfeatures(String energysavingfeatures) {
        this.setEnergysavingfeatures(energysavingfeatures);
        return this;
    }

    public void setEnergysavingfeatures(String energysavingfeatures) {
        this.energysavingfeatures = energysavingfeatures;
    }

    public String getLotnumber() {
        return this.lotnumber;
    }

    public ResProperties lotnumber(String lotnumber) {
        this.setLotnumber(lotnumber);
        return this;
    }

    public void setLotnumber(String lotnumber) {
        this.lotnumber = lotnumber;
    }

    public String getLotsizearea() {
        return this.lotsizearea;
    }

    public ResProperties lotsizearea(String lotsizearea) {
        this.setLotsizearea(lotsizearea);
        return this;
    }

    public void setLotsizearea(String lotsizearea) {
        this.lotsizearea = lotsizearea;
    }

    public String getLotsizedimensions() {
        return this.lotsizedimensions;
    }

    public ResProperties lotsizedimensions(String lotsizedimensions) {
        this.setLotsizedimensions(lotsizedimensions);
        return this;
    }

    public void setLotsizedimensions(String lotsizedimensions) {
        this.lotsizedimensions = lotsizedimensions;
    }

    public String getEasements() {
        return this.easements;
    }

    public ResProperties easements(String easements) {
        this.setEasements(easements);
        return this;
    }

    public void setEasements(String easements) {
        this.easements = easements;
    }

    public String getRestrictions() {
        return this.restrictions;
    }

    public ResProperties restrictions(String restrictions) {
        this.setRestrictions(restrictions);
        return this;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getWasherdryerconnections() {
        return this.washerdryerconnections;
    }

    public ResProperties washerdryerconnections(String washerdryerconnections) {
        this.setWasherdryerconnections(washerdryerconnections);
        return this;
    }

    public void setWasherdryerconnections(String washerdryerconnections) {
        this.washerdryerconnections = washerdryerconnections;
    }

    public String getMunicipalutilitydistrictyn() {
        return this.municipalutilitydistrictyn;
    }

    public ResProperties municipalutilitydistrictyn(String municipalutilitydistrictyn) {
        this.setMunicipalutilitydistrictyn(municipalutilitydistrictyn);
        return this;
    }

    public void setMunicipalutilitydistrictyn(String municipalutilitydistrictyn) {
        this.municipalutilitydistrictyn = municipalutilitydistrictyn;
    }

    public String getAssociationfeeincludes() {
        return this.associationfeeincludes;
    }

    public ResProperties associationfeeincludes(String associationfeeincludes) {
        this.setAssociationfeeincludes(associationfeeincludes);
        return this;
    }

    public void setAssociationfeeincludes(String associationfeeincludes) {
        this.associationfeeincludes = associationfeeincludes;
    }

    public String getAssociationtype() {
        return this.associationtype;
    }

    public ResProperties associationtype(String associationtype) {
        this.setAssociationtype(associationtype);
        return this;
    }

    public void setAssociationtype(String associationtype) {
        this.associationtype = associationtype;
    }

    public String getBarninformation() {
        return this.barninformation;
    }

    public ResProperties barninformation(String barninformation) {
        this.setBarninformation(barninformation);
        return this;
    }

    public void setBarninformation(String barninformation) {
        this.barninformation = barninformation;
    }

    public String getConstructionmaterialswalls() {
        return this.constructionmaterialswalls;
    }

    public ResProperties constructionmaterialswalls(String constructionmaterialswalls) {
        this.setConstructionmaterialswalls(constructionmaterialswalls);
        return this;
    }

    public void setConstructionmaterialswalls(String constructionmaterialswalls) {
        this.constructionmaterialswalls = constructionmaterialswalls;
    }

    public String getCountyorparish() {
        return this.countyorparish;
    }

    public ResProperties countyorparish(String countyorparish) {
        this.setCountyorparish(countyorparish);
        return this;
    }

    public void setCountyorparish(String countyorparish) {
        this.countyorparish = countyorparish;
    }

    public String getExteriorbuildings() {
        return this.exteriorbuildings;
    }

    public ResProperties exteriorbuildings(String exteriorbuildings) {
        this.setExteriorbuildings(exteriorbuildings);
        return this;
    }

    public void setExteriorbuildings(String exteriorbuildings) {
        this.exteriorbuildings = exteriorbuildings;
    }

    public String getFarmranchfeatures() {
        return this.farmranchfeatures;
    }

    public ResProperties farmranchfeatures(String farmranchfeatures) {
        this.setFarmranchfeatures(farmranchfeatures);
        return this;
    }

    public void setFarmranchfeatures(String farmranchfeatures) {
        this.farmranchfeatures = farmranchfeatures;
    }

    public String getFencedyardyn() {
        return this.fencedyardyn;
    }

    public ResProperties fencedyardyn(String fencedyardyn) {
        this.setFencedyardyn(fencedyardyn);
        return this;
    }

    public void setFencedyardyn(String fencedyardyn) {
        this.fencedyardyn = fencedyardyn;
    }

    public String getFinancingproposed() {
        return this.financingproposed;
    }

    public ResProperties financingproposed(String financingproposed) {
        this.setFinancingproposed(financingproposed);
        return this;
    }

    public void setFinancingproposed(String financingproposed) {
        this.financingproposed = financingproposed;
    }

    public String getHandicapyn() {
        return this.handicapyn;
    }

    public ResProperties handicapyn(String handicapyn) {
        this.setHandicapyn(handicapyn);
        return this;
    }

    public void setHandicapyn(String handicapyn) {
        this.handicapyn = handicapyn;
    }

    public String getNumberoftanksandponds() {
        return this.numberoftanksandponds;
    }

    public ResProperties numberoftanksandponds(String numberoftanksandponds) {
        this.setNumberoftanksandponds(numberoftanksandponds);
        return this;
    }

    public void setNumberoftanksandponds(String numberoftanksandponds) {
        this.numberoftanksandponds = numberoftanksandponds;
    }

    public String getParcelnumber() {
        return this.parcelnumber;
    }

    public ResProperties parcelnumber(String parcelnumber) {
        this.setParcelnumber(parcelnumber);
        return this;
    }

    public void setParcelnumber(String parcelnumber) {
        this.parcelnumber = parcelnumber;
    }

    public String getVirtualtoururlunbranded() {
        return this.virtualtoururlunbranded;
    }

    public ResProperties virtualtoururlunbranded(String virtualtoururlunbranded) {
        this.setVirtualtoururlunbranded(virtualtoururlunbranded);
        return this;
    }

    public void setVirtualtoururlunbranded(String virtualtoururlunbranded) {
        this.virtualtoururlunbranded = virtualtoururlunbranded;
    }

    public String getLivingRoomFeature() {
        return this.livingRoomFeature;
    }

    public ResProperties livingRoomFeature(String livingRoomFeature) {
        this.setLivingRoomFeature(livingRoomFeature);
        return this;
    }

    public void setLivingRoomFeature(String livingRoomFeature) {
        this.livingRoomFeature = livingRoomFeature;
    }

    public String getMasterBedRoomFeature() {
        return this.masterBedRoomFeature;
    }

    public ResProperties masterBedRoomFeature(String masterBedRoomFeature) {
        this.setMasterBedRoomFeature(masterBedRoomFeature);
        return this;
    }

    public void setMasterBedRoomFeature(String masterBedRoomFeature) {
        this.masterBedRoomFeature = masterBedRoomFeature;
    }

    public String getBedRoomFeature() {
        return this.bedRoomFeature;
    }

    public ResProperties bedRoomFeature(String bedRoomFeature) {
        this.setBedRoomFeature(bedRoomFeature);
        return this;
    }

    public void setBedRoomFeature(String bedRoomFeature) {
        this.bedRoomFeature = bedRoomFeature;
    }

    public String getDiningRoomFeature() {
        return this.diningRoomFeature;
    }

    public ResProperties diningRoomFeature(String diningRoomFeature) {
        this.setDiningRoomFeature(diningRoomFeature);
        return this;
    }

    public void setDiningRoomFeature(String diningRoomFeature) {
        this.diningRoomFeature = diningRoomFeature;
    }

    public String getKitchenRoomFeature() {
        return this.kitchenRoomFeature;
    }

    public ResProperties kitchenRoomFeature(String kitchenRoomFeature) {
        this.setKitchenRoomFeature(kitchenRoomFeature);
        return this;
    }

    public void setKitchenRoomFeature(String kitchenRoomFeature) {
        this.kitchenRoomFeature = kitchenRoomFeature;
    }

    public String getBreakfastRoomFeature() {
        return this.breakfastRoomFeature;
    }

    public ResProperties breakfastRoomFeature(String breakfastRoomFeature) {
        this.setBreakfastRoomFeature(breakfastRoomFeature);
        return this;
    }

    public void setBreakfastRoomFeature(String breakfastRoomFeature) {
        this.breakfastRoomFeature = breakfastRoomFeature;
    }

    public String getStudyRoomFeature() {
        return this.studyRoomFeature;
    }

    public ResProperties studyRoomFeature(String studyRoomFeature) {
        this.setStudyRoomFeature(studyRoomFeature);
        return this;
    }

    public void setStudyRoomFeature(String studyRoomFeature) {
        this.studyRoomFeature = studyRoomFeature;
    }

    public String getUtilityRoomFeature() {
        return this.utilityRoomFeature;
    }

    public ResProperties utilityRoomFeature(String utilityRoomFeature) {
        this.setUtilityRoomFeature(utilityRoomFeature);
        return this;
    }

    public void setUtilityRoomFeature(String utilityRoomFeature) {
        this.utilityRoomFeature = utilityRoomFeature;
    }

    public String getFullBathRoomFeature() {
        return this.fullBathRoomFeature;
    }

    public ResProperties fullBathRoomFeature(String fullBathRoomFeature) {
        this.setFullBathRoomFeature(fullBathRoomFeature);
        return this;
    }

    public void setFullBathRoomFeature(String fullBathRoomFeature) {
        this.fullBathRoomFeature = fullBathRoomFeature;
    }

    public String getHalfBathRoomFeature() {
        return this.halfBathRoomFeature;
    }

    public ResProperties halfBathRoomFeature(String halfBathRoomFeature) {
        this.setHalfBathRoomFeature(halfBathRoomFeature);
        return this;
    }

    public void setHalfBathRoomFeature(String halfBathRoomFeature) {
        this.halfBathRoomFeature = halfBathRoomFeature;
    }

    public String getExerciseRoomFeature() {
        return this.exerciseRoomFeature;
    }

    public ResProperties exerciseRoomFeature(String exerciseRoomFeature) {
        this.setExerciseRoomFeature(exerciseRoomFeature);
        return this;
    }

    public void setExerciseRoomFeature(String exerciseRoomFeature) {
        this.exerciseRoomFeature = exerciseRoomFeature;
    }

    public String getExtraStorageRoomFeature() {
        return this.extraStorageRoomFeature;
    }

    public ResProperties extraStorageRoomFeature(String extraStorageRoomFeature) {
        this.setExtraStorageRoomFeature(extraStorageRoomFeature);
        return this;
    }

    public void setExtraStorageRoomFeature(String extraStorageRoomFeature) {
        this.extraStorageRoomFeature = extraStorageRoomFeature;
    }

    public String getGameRoomFeature() {
        return this.gameRoomFeature;
    }

    public ResProperties gameRoomFeature(String gameRoomFeature) {
        this.setGameRoomFeature(gameRoomFeature);
        return this;
    }

    public void setGameRoomFeature(String gameRoomFeature) {
        this.gameRoomFeature = gameRoomFeature;
    }

    public String getGuestRoomFeature() {
        return this.guestRoomFeature;
    }

    public ResProperties guestRoomFeature(String guestRoomFeature) {
        this.setGuestRoomFeature(guestRoomFeature);
        return this;
    }

    public void setGuestRoomFeature(String guestRoomFeature) {
        this.guestRoomFeature = guestRoomFeature;
    }

    public String getLibraryRoomFeature() {
        return this.libraryRoomFeature;
    }

    public ResProperties libraryRoomFeature(String libraryRoomFeature) {
        this.setLibraryRoomFeature(libraryRoomFeature);
        return this;
    }

    public void setLibraryRoomFeature(String libraryRoomFeature) {
        this.libraryRoomFeature = libraryRoomFeature;
    }

    public String getMediaRoomFeature() {
        return this.mediaRoomFeature;
    }

    public ResProperties mediaRoomFeature(String mediaRoomFeature) {
        this.setMediaRoomFeature(mediaRoomFeature);
        return this;
    }

    public void setMediaRoomFeature(String mediaRoomFeature) {
        this.mediaRoomFeature = mediaRoomFeature;
    }

    public String getMudRoomFeature() {
        return this.mudRoomFeature;
    }

    public ResProperties mudRoomFeature(String mudRoomFeature) {
        this.setMudRoomFeature(mudRoomFeature);
        return this;
    }

    public void setMudRoomFeature(String mudRoomFeature) {
        this.mudRoomFeature = mudRoomFeature;
    }

    public String getOfficeRoomFeature() {
        return this.officeRoomFeature;
    }

    public ResProperties officeRoomFeature(String officeRoomFeature) {
        this.setOfficeRoomFeature(officeRoomFeature);
        return this;
    }

    public void setOfficeRoomFeature(String officeRoomFeature) {
        this.officeRoomFeature = officeRoomFeature;
    }

    public String getSaunaRoomFeature() {
        return this.saunaRoomFeature;
    }

    public ResProperties saunaRoomFeature(String saunaRoomFeature) {
        this.setSaunaRoomFeature(saunaRoomFeature);
        return this;
    }

    public void setSaunaRoomFeature(String saunaRoomFeature) {
        this.saunaRoomFeature = saunaRoomFeature;
    }

    public String getSecondMasterRoomFeature() {
        return this.secondMasterRoomFeature;
    }

    public ResProperties secondMasterRoomFeature(String secondMasterRoomFeature) {
        this.setSecondMasterRoomFeature(secondMasterRoomFeature);
        return this;
    }

    public void setSecondMasterRoomFeature(String secondMasterRoomFeature) {
        this.secondMasterRoomFeature = secondMasterRoomFeature;
    }

    public String getSunroomRoomFeature() {
        return this.sunroomRoomFeature;
    }

    public ResProperties sunroomRoomFeature(String sunroomRoomFeature) {
        this.setSunroomRoomFeature(sunroomRoomFeature);
        return this;
    }

    public void setSunroomRoomFeature(String sunroomRoomFeature) {
        this.sunroomRoomFeature = sunroomRoomFeature;
    }

    public String getSpaRoomFeature() {
        return this.spaRoomFeature;
    }

    public ResProperties spaRoomFeature(String spaRoomFeature) {
        this.setSpaRoomFeature(spaRoomFeature);
        return this;
    }

    public void setSpaRoomFeature(String spaRoomFeature) {
        this.spaRoomFeature = spaRoomFeature;
    }

    public String getWineRoomFeature() {
        return this.wineRoomFeature;
    }

    public ResProperties wineRoomFeature(String wineRoomFeature) {
        this.setWineRoomFeature(wineRoomFeature);
        return this;
    }

    public void setWineRoomFeature(String wineRoomFeature) {
        this.wineRoomFeature = wineRoomFeature;
    }

    public String getOtherRoomFeature() {
        return this.otherRoomFeature;
    }

    public ResProperties otherRoomFeature(String otherRoomFeature) {
        this.setOtherRoomFeature(otherRoomFeature);
        return this;
    }

    public void setOtherRoomFeature(String otherRoomFeature) {
        this.otherRoomFeature = otherRoomFeature;
    }

    public String getIsLuxury() {
        return this.isLuxury;
    }

    public ResProperties isLuxury(String isLuxury) {
        this.setIsLuxury(isLuxury);
        return this;
    }

    public void setIsLuxury(String isLuxury) {
        this.isLuxury = isLuxury;
    }

    public String getIsMoveInReady() {
        return this.isMoveInReady;
    }

    public ResProperties isMoveInReady(String isMoveInReady) {
        this.setIsMoveInReady(isMoveInReady);
        return this;
    }

    public void setIsMoveInReady(String isMoveInReady) {
        this.isMoveInReady = isMoveInReady;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public ResProperties photoUrl(String photoUrl) {
        this.setPhotoUrl(photoUrl);
        return this;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhoto1Url() {
        return this.photo1Url;
    }

    public ResProperties photo1Url(String photo1Url) {
        this.setPhoto1Url(photo1Url);
        return this;
    }

    public void setPhoto1Url(String photo1Url) {
        this.photo1Url = photo1Url;
    }

    public String getPhoto2Url() {
        return this.photo2Url;
    }

    public ResProperties photo2Url(String photo2Url) {
        this.setPhoto2Url(photo2Url);
        return this;
    }

    public void setPhoto2Url(String photo2Url) {
        this.photo2Url = photo2Url;
    }

    public String getPhoto3Url() {
        return this.photo3Url;
    }

    public ResProperties photo3Url(String photo3Url) {
        this.setPhoto3Url(photo3Url);
        return this;
    }

    public void setPhoto3Url(String photo3Url) {
        this.photo3Url = photo3Url;
    }

    public String getPhoto4Url() {
        return this.photo4Url;
    }

    public ResProperties photo4Url(String photo4Url) {
        this.setPhoto4Url(photo4Url);
        return this;
    }

    public void setPhoto4Url(String photo4Url) {
        this.photo4Url = photo4Url;
    }

    public String getPhoto5Url() {
        return this.photo5Url;
    }

    public ResProperties photo5Url(String photo5Url) {
        this.setPhoto5Url(photo5Url);
        return this;
    }

    public void setPhoto5Url(String photo5Url) {
        this.photo5Url = photo5Url;
    }

    public String getPhoto6Url() {
        return this.photo6Url;
    }

    public ResProperties photo6Url(String photo6Url) {
        this.setPhoto6Url(photo6Url);
        return this;
    }

    public void setPhoto6Url(String photo6Url) {
        this.photo6Url = photo6Url;
    }

    public String getPhoto7Url() {
        return this.photo7Url;
    }

    public ResProperties photo7Url(String photo7Url) {
        this.setPhoto7Url(photo7Url);
        return this;
    }

    public void setPhoto7Url(String photo7Url) {
        this.photo7Url = photo7Url;
    }

    public String getPhoto8Url() {
        return this.photo8Url;
    }

    public ResProperties photo8Url(String photo8Url) {
        this.setPhoto8Url(photo8Url);
        return this;
    }

    public void setPhoto8Url(String photo8Url) {
        this.photo8Url = photo8Url;
    }

    public String getPhoto9Url() {
        return this.photo9Url;
    }

    public ResProperties photo9Url(String photo9Url) {
        this.setPhoto9Url(photo9Url);
        return this;
    }

    public void setPhoto9Url(String photo9Url) {
        this.photo9Url = photo9Url;
    }

    public String getPhoto10Url() {
        return this.photo10Url;
    }

    public ResProperties photo10Url(String photo10Url) {
        this.setPhoto10Url(photo10Url);
        return this;
    }

    public void setPhoto10Url(String photo10Url) {
        this.photo10Url = photo10Url;
    }

    public String getPhoto11Url() {
        return this.photo11Url;
    }

    public ResProperties photo11Url(String photo11Url) {
        this.setPhoto11Url(photo11Url);
        return this;
    }

    public void setPhoto11Url(String photo11Url) {
        this.photo11Url = photo11Url;
    }

    public String getPhoto12Url() {
        return this.photo12Url;
    }

    public ResProperties photo12Url(String photo12Url) {
        this.setPhoto12Url(photo12Url);
        return this;
    }

    public void setPhoto12Url(String photo12Url) {
        this.photo12Url = photo12Url;
    }

    public String getPhoto13Url() {
        return this.photo13Url;
    }

    public ResProperties photo13Url(String photo13Url) {
        this.setPhoto13Url(photo13Url);
        return this;
    }

    public void setPhoto13Url(String photo13Url) {
        this.photo13Url = photo13Url;
    }

    public String getPhoto14Url() {
        return this.photo14Url;
    }

    public ResProperties photo14Url(String photo14Url) {
        this.setPhoto14Url(photo14Url);
        return this;
    }

    public void setPhoto14Url(String photo14Url) {
        this.photo14Url = photo14Url;
    }

    public String getPhoto15Url() {
        return this.photo15Url;
    }

    public ResProperties photo15Url(String photo15Url) {
        this.setPhoto15Url(photo15Url);
        return this;
    }

    public void setPhoto15Url(String photo15Url) {
        this.photo15Url = photo15Url;
    }

    public String getPhoto16Url() {
        return this.photo16Url;
    }

    public ResProperties photo16Url(String photo16Url) {
        this.setPhoto16Url(photo16Url);
        return this;
    }

    public void setPhoto16Url(String photo16Url) {
        this.photo16Url = photo16Url;
    }

    public String getPhoto17Url() {
        return this.photo17Url;
    }

    public ResProperties photo17Url(String photo17Url) {
        this.setPhoto17Url(photo17Url);
        return this;
    }

    public void setPhoto17Url(String photo17Url) {
        this.photo17Url = photo17Url;
    }

    public String getPhoto18Url() {
        return this.photo18Url;
    }

    public ResProperties photo18Url(String photo18Url) {
        this.setPhoto18Url(photo18Url);
        return this;
    }

    public void setPhoto18Url(String photo18Url) {
        this.photo18Url = photo18Url;
    }

    public String getPhoto19Url() {
        return this.photo19Url;
    }

    public ResProperties photo19Url(String photo19Url) {
        this.setPhoto19Url(photo19Url);
        return this;
    }

    public void setPhoto19Url(String photo19Url) {
        this.photo19Url = photo19Url;
    }

    public String getPhoto20Url() {
        return this.photo20Url;
    }

    public ResProperties photo20Url(String photo20Url) {
        this.setPhoto20Url(photo20Url);
        return this;
    }

    public void setPhoto20Url(String photo20Url) {
        this.photo20Url = photo20Url;
    }

    public String getPhoto21Url() {
        return this.photo21Url;
    }

    public ResProperties photo21Url(String photo21Url) {
        this.setPhoto21Url(photo21Url);
        return this;
    }

    public void setPhoto21Url(String photo21Url) {
        this.photo21Url = photo21Url;
    }

    public String getPhoto22Url() {
        return this.photo22Url;
    }

    public ResProperties photo22Url(String photo22Url) {
        this.setPhoto22Url(photo22Url);
        return this;
    }

    public void setPhoto22Url(String photo22Url) {
        this.photo22Url = photo22Url;
    }

    public String getPhoto23Url() {
        return this.photo23Url;
    }

    public ResProperties photo23Url(String photo23Url) {
        this.setPhoto23Url(photo23Url);
        return this;
    }

    public void setPhoto23Url(String photo23Url) {
        this.photo23Url = photo23Url;
    }

    public String getPhoto24Url() {
        return this.photo24Url;
    }

    public ResProperties photo24Url(String photo24Url) {
        this.setPhoto24Url(photo24Url);
        return this;
    }

    public void setPhoto24Url(String photo24Url) {
        this.photo24Url = photo24Url;
    }

    public String getPhoto25Url() {
        return this.photo25Url;
    }

    public ResProperties photo25Url(String photo25Url) {
        this.setPhoto25Url(photo25Url);
        return this;
    }

    public void setPhoto25Url(String photo25Url) {
        this.photo25Url = photo25Url;
    }

    public String getPhoto26Url() {
        return this.photo26Url;
    }

    public ResProperties photo26Url(String photo26Url) {
        this.setPhoto26Url(photo26Url);
        return this;
    }

    public void setPhoto26Url(String photo26Url) {
        this.photo26Url = photo26Url;
    }

    public String getPhoto27Url() {
        return this.photo27Url;
    }

    public ResProperties photo27Url(String photo27Url) {
        this.setPhoto27Url(photo27Url);
        return this;
    }

    public void setPhoto27Url(String photo27Url) {
        this.photo27Url = photo27Url;
    }

    public String getPhoto28Url() {
        return this.photo28Url;
    }

    public ResProperties photo28Url(String photo28Url) {
        this.setPhoto28Url(photo28Url);
        return this;
    }

    public void setPhoto28Url(String photo28Url) {
        this.photo28Url = photo28Url;
    }

    public String getPhoto29Url() {
        return this.photo29Url;
    }

    public ResProperties photo29Url(String photo29Url) {
        this.setPhoto29Url(photo29Url);
        return this;
    }

    public void setPhoto29Url(String photo29Url) {
        this.photo29Url = photo29Url;
    }

    public String getPhoto30Url() {
        return this.photo30Url;
    }

    public ResProperties photo30Url(String photo30Url) {
        this.setPhoto30Url(photo30Url);
        return this;
    }

    public void setPhoto30Url(String photo30Url) {
        this.photo30Url = photo30Url;
    }

    public String getPhoto31Url() {
        return this.photo31Url;
    }

    public ResProperties photo31Url(String photo31Url) {
        this.setPhoto31Url(photo31Url);
        return this;
    }

    public void setPhoto31Url(String photo31Url) {
        this.photo31Url = photo31Url;
    }

    public String getPhoto32Url() {
        return this.photo32Url;
    }

    public ResProperties photo32Url(String photo32Url) {
        this.setPhoto32Url(photo32Url);
        return this;
    }

    public void setPhoto32Url(String photo32Url) {
        this.photo32Url = photo32Url;
    }

    public String getPhoto33Url() {
        return this.photo33Url;
    }

    public ResProperties photo33Url(String photo33Url) {
        this.setPhoto33Url(photo33Url);
        return this;
    }

    public void setPhoto33Url(String photo33Url) {
        this.photo33Url = photo33Url;
    }

    public String getPhoto34Url() {
        return this.photo34Url;
    }

    public ResProperties photo34Url(String photo34Url) {
        this.setPhoto34Url(photo34Url);
        return this;
    }

    public void setPhoto34Url(String photo34Url) {
        this.photo34Url = photo34Url;
    }

    public String getPhoto35Url() {
        return this.photo35Url;
    }

    public ResProperties photo35Url(String photo35Url) {
        this.setPhoto35Url(photo35Url);
        return this;
    }

    public void setPhoto35Url(String photo35Url) {
        this.photo35Url = photo35Url;
    }

    public String getPhoto36Url() {
        return this.photo36Url;
    }

    public ResProperties photo36Url(String photo36Url) {
        this.setPhoto36Url(photo36Url);
        return this;
    }

    public void setPhoto36Url(String photo36Url) {
        this.photo36Url = photo36Url;
    }

    public String getPhoto37Url() {
        return this.photo37Url;
    }

    public ResProperties photo37Url(String photo37Url) {
        this.setPhoto37Url(photo37Url);
        return this;
    }

    public void setPhoto37Url(String photo37Url) {
        this.photo37Url = photo37Url;
    }

    public String getPhoto38Url() {
        return this.photo38Url;
    }

    public ResProperties photo38Url(String photo38Url) {
        this.setPhoto38Url(photo38Url);
        return this;
    }

    public void setPhoto38Url(String photo38Url) {
        this.photo38Url = photo38Url;
    }

    public String getPhoto39Url() {
        return this.photo39Url;
    }

    public ResProperties photo39Url(String photo39Url) {
        this.setPhoto39Url(photo39Url);
        return this;
    }

    public void setPhoto39Url(String photo39Url) {
        this.photo39Url = photo39Url;
    }

    public String getPhoto40Url() {
        return this.photo40Url;
    }

    public ResProperties photo40Url(String photo40Url) {
        this.setPhoto40Url(photo40Url);
        return this;
    }

    public void setPhoto40Url(String photo40Url) {
        this.photo40Url = photo40Url;
    }

    public Instant getCreated() {
        return this.created;
    }

    public ResProperties created(Instant created) {
        this.setCreated(created);
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return this.updated;
    }

    public ResProperties updated(Instant updated) {
        this.setUpdated(updated);
        return this;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Instant getModifiedDate() {
        return this.modifiedDate;
    }

    public ResProperties modifiedDate(Instant modifiedDate) {
        this.setModifiedDate(modifiedDate);
        return this;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getImgDeleted() {
        return this.imgDeleted;
    }

    public ResProperties imgDeleted(Boolean imgDeleted) {
        this.setImgDeleted(imgDeleted);
        return this;
    }

    public void setImgDeleted(Boolean imgDeleted) {
        this.imgDeleted = imgDeleted;
    }

    public String getRetsServer() {
        return this.retsServer;
    }

    public ResProperties retsServer(String retsServer) {
        this.setRetsServer(retsServer);
        return this;
    }

    public void setRetsServer(String retsServer) {
        this.retsServer = retsServer;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public ResProperties permalink(String permalink) {
        this.setPermalink(permalink);
        return this;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPropertyTag() {
        return this.propertyTag;
    }

    public ResProperties propertyTag(String propertyTag) {
        this.setPropertyTag(propertyTag);
        return this;
    }

    public void setPropertyTag(String propertyTag) {
        this.propertyTag = propertyTag;
    }

    public Integer getBuildentoryViews() {
        return this.buildentoryViews;
    }

    public ResProperties buildentoryViews(Integer buildentoryViews) {
        this.setBuildentoryViews(buildentoryViews);
        return this;
    }

    public void setBuildentoryViews(Integer buildentoryViews) {
        this.buildentoryViews = buildentoryViews;
    }

    public String getLocation() {
        return this.location;
    }

    public ResProperties location(String location) {
        this.setLocation(location);
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResProperties)) {
            return false;
        }
        return id != null && id.equals(((ResProperties) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ResProperties{" +
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
