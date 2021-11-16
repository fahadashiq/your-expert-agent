package com.hsrw.yea.web.rest;

import static com.hsrw.yea.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.hsrw.yea.IntegrationTest;
import com.hsrw.yea.domain.ResProperties;
import com.hsrw.yea.repository.ResPropertiesRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link ResPropertiesResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ResPropertiesResourceIT {

    private static final Integer DEFAULT_COMMUNITY_ID = 1;
    private static final Integer UPDATED_COMMUNITY_ID = 2;

    private static final String DEFAULT_COMMUNITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMMUNITY_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_BUILDER_ID = 1;
    private static final Integer UPDATED_BUILDER_ID = 2;

    private static final String DEFAULT_SPECIAL_OFFERS = "AAAAAAAAAA";
    private static final String UPDATED_SPECIAL_OFFERS = "BBBBBBBBBB";

    private static final String DEFAULT_BROCHURE = "AAAAAAAAAA";
    private static final String UPDATED_BROCHURE = "BBBBBBBBBB";

    private static final Integer DEFAULT_FLOOR_PLAN_ID = 1;
    private static final Integer UPDATED_FLOOR_PLAN_ID = 2;

    private static final String DEFAULT_LATITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LATITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_LONGITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LONGITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTY = "AAAAAAAAAA";
    private static final String UPDATED_COUNTY = "BBBBBBBBBB";

    private static final String DEFAULT_HEATSYSTEM = "AAAAAAAAAA";
    private static final String UPDATED_HEATSYSTEM = "BBBBBBBBBB";

    private static final String DEFAULT_LISTSTATUS = "AAAAAAAAAA";
    private static final String UPDATED_LISTSTATUS = "BBBBBBBBBB";

    private static final String DEFAULT_LISTSTATUSFLAG = "AAAAAAAAAA";
    private static final String UPDATED_LISTSTATUSFLAG = "BBBBBBBBBB";

    private static final String DEFAULT_CARPORTCAP = "AAAAAAAAAA";
    private static final String UPDATED_CARPORTCAP = "BBBBBBBBBB";

    private static final String DEFAULT_POSSESSION = "AAAAAAAAAA";
    private static final String UPDATED_POSSESSION = "BBBBBBBBBB";

    private static final String DEFAULT_SCHOOLNAME_1 = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLNAME_1 = "BBBBBBBBBB";

    private static final String DEFAULT_SUBDIVIDE = "AAAAAAAAAA";
    private static final String UPDATED_SUBDIVIDE = "BBBBBBBBBB";

    private static final String DEFAULT_VOWAVMYN = "A";
    private static final String UPDATED_VOWAVMYN = "B";

    private static final String DEFAULT_PRESENTUSE = "AAAAAAAAAA";
    private static final String UPDATED_PRESENTUSE = "BBBBBBBBBB";

    private static final String DEFAULT_PROPOSEDUSE = "AAAAAAAAAA";
    private static final String UPDATED_PROPOSEDUSE = "BBBBBBBBBB";

    private static final String DEFAULT_RANCHNAME = "AAAAAAAAAA";
    private static final String UPDATED_RANCHNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMBED_2_WIDTH = 1;
    private static final Integer UPDATED_ROOMBED_2_WIDTH = 2;

    private static final String DEFAULT_ROOMDININGLEVEL = "AAAAAAAAAA";
    private static final String UPDATED_ROOMDININGLEVEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMLIVING_2_WIDTH = 1;
    private static final Integer UPDATED_ROOMLIVING_2_WIDTH = 2;

    private static final String DEFAULT_ROOMSTUDYLEVEL = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSTUDYLEVEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_AREA = 1;
    private static final Integer UPDATED_AREA = 2;

    private static final String DEFAULT_AREATITLE = "AAAAAAAAAA";
    private static final String UPDATED_AREATITLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_ASSOCFEE = 1;
    private static final Integer UPDATED_ASSOCFEE = 2;

    private static final String DEFAULT_FINANCEPROPOSED = "AAAAAAAAAA";
    private static final String UPDATED_FINANCEPROPOSED = "BBBBBBBBBB";

    private static final Integer DEFAULT_LISTPRICEORIG = 1;
    private static final Integer UPDATED_LISTPRICEORIG = 2;

    private static final String DEFAULT_MAPCOORD = "AAAAA";
    private static final String UPDATED_MAPCOORD = "BBBBB";

    private static final String DEFAULT_SCHOOLNAME_2 = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLNAME_2 = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMGARAGEWIDTH = 1;
    private static final Integer UPDATED_ROOMGARAGEWIDTH = 2;

    private static final String DEFAULT_ROOMKITCHENDESC = "AAAAAAAAAA";
    private static final String UPDATED_ROOMKITCHENDESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMLIVING_1_WIDTH = 1;
    private static final Integer UPDATED_ROOMLIVING_1_WIDTH = 2;

    private static final Integer DEFAULT_ROOMOTHER_2_WIDTH = 1;
    private static final Integer UPDATED_ROOMOTHER_2_WIDTH = 2;

    private static final Integer DEFAULT_SQFTTOTAL = 1;
    private static final Integer UPDATED_SQFTTOTAL = 2;

    private static final String DEFAULT_OFFICELIST_OFFICENAM_1 = "AAAAAAAAAA";
    private static final String UPDATED_OFFICELIST_OFFICENAM_1 = "BBBBBBBBBB";

    private static final String DEFAULT_SCHOOLNAME_3 = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLNAME_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ZIPCODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIPCODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_BARN_1_LENGTH = 1;
    private static final Integer UPDATED_BARN_1_LENGTH = 2;

    private static final Integer DEFAULT_BARN_3_WIDTH = 1;
    private static final Integer UPDATED_BARN_3_WIDTH = 2;

    private static final Integer DEFAULT_ROOMBED_2_LENGTH = 1;
    private static final Integer UPDATED_ROOMBED_2_LENGTH = 2;

    private static final Integer DEFAULT_ROOMBED_3_LENGTH = 1;
    private static final Integer UPDATED_ROOMBED_3_LENGTH = 2;

    private static final Integer DEFAULT_ROOMOTHER_1_WIDTH = 1;
    private static final Integer UPDATED_ROOMOTHER_1_WIDTH = 2;

    private static final String DEFAULT_AGENTLIST_FULLNAME = "AAAAAAAAAA";
    private static final String UPDATED_AGENTLIST_FULLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PROPTYPE = "AAAAAAAAAA";
    private static final String UPDATED_PROPTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_MLS_PROPTYPE = "AAAAAAAAAA";
    private static final String UPDATED_MLS_PROPTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SCHOOLNAME_4 = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLNAME_4 = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_ACRESCULTIVATED = new BigDecimal(1);
    private static final BigDecimal UPDATED_ACRESCULTIVATED = new BigDecimal(2);

    private static final Integer DEFAULT_BARN_2_LENGTH = 1;
    private static final Integer UPDATED_BARN_2_LENGTH = 2;

    private static final Integer DEFAULT_BARN_2_WIDTH = 1;
    private static final Integer UPDATED_BARN_2_WIDTH = 2;

    private static final String DEFAULT_COMPLEXNAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPLEXNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMBED_4_LENGTH = 1;
    private static final Integer UPDATED_ROOMBED_4_LENGTH = 2;

    private static final String DEFAULT_ROOMBEDBATHDESC = "AAAAAAAAAA";
    private static final String UPDATED_ROOMBEDBATHDESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMBREAKFASTWIDTH = 1;
    private static final Integer UPDATED_ROOMBREAKFASTWIDTH = 2;

    private static final String DEFAULT_ROOMOTHER = "AAAAAAAAAA";
    private static final String UPDATED_ROOMOTHER = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMUTILITYLENGTH = 1;
    private static final Integer UPDATED_ROOMUTILITYLENGTH = 2;

    private static final BigDecimal DEFAULT_ACRES = new BigDecimal(1);
    private static final BigDecimal UPDATED_ACRES = new BigDecimal(2);

    private static final String DEFAULT_BLOCK = "AAAAAAA";
    private static final String UPDATED_BLOCK = "BBBBBBB";

    private static final String DEFAULT_DIRECTIONS = "AAAAAAAAAA";
    private static final String UPDATED_DIRECTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_SUBDIVISION = "AAAAAAAAAA";
    private static final String UPDATED_SUBDIVISION = "BBBBBBBBBB";

    private static final Integer DEFAULT_YEARBUILT = 1;
    private static final Integer UPDATED_YEARBUILT = 2;

    private static final String DEFAULT_YEARBUILTDETAILS = "AAAAAAAAAA";
    private static final String UPDATED_YEARBUILTDETAILS = "BBBBBBBBBB";

    private static final String DEFAULT_AGEXEMPTION = "A";
    private static final String UPDATED_AGEXEMPTION = "B";

    private static final Integer DEFAULT_BARN_1_WIDTH = 1;
    private static final Integer UPDATED_BARN_1_WIDTH = 2;

    private static final Integer DEFAULT_BARN_3_LENGTH = 1;
    private static final Integer UPDATED_BARN_3_LENGTH = 2;

    private static final Integer DEFAULT_ROOMDININGWIDTH = 1;
    private static final Integer UPDATED_ROOMDININGWIDTH = 2;

    private static final Integer DEFAULT_ROOMSTUDYWIDTH = 1;
    private static final Integer UPDATED_ROOMSTUDYWIDTH = 2;

    private static final String DEFAULT_SOILTYPE = "AAAAAAAAAA";
    private static final String UPDATED_SOILTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_APPRAISERNAME = "AAAAAAAAAA";
    private static final String UPDATED_APPRAISERNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_LISTPRICELOW = 1;
    private static final Integer UPDATED_LISTPRICELOW = 2;

    private static final String DEFAULT_MAPPAGE = "AAAAA";
    private static final String UPDATED_MAPPAGE = "BBBBB";

    private static final String DEFAULT_UNITNUMBER = "AAAAAAAAAA";
    private static final String UPDATED_UNITNUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_STREETDIR = "AAAAAAAAAA";
    private static final String UPDATED_STREETDIR = "BBBBBBBBBB";

    private static final String DEFAULT_STREETTYPE = "AAAAAAAAAA";
    private static final String UPDATED_STREETTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SUBAREA = "AAAAAAAAAA";
    private static final String UPDATED_SUBAREA = "BBBBBBBBBB";

    private static final String DEFAULT_SUBAREATITLE = "AAAAAAAAAA";
    private static final String UPDATED_SUBAREATITLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_BATHSHALF = 1;
    private static final Integer UPDATED_BATHSHALF = 2;

    private static final Integer DEFAULT_ROOMGARAGELENGTH = 1;
    private static final Integer UPDATED_ROOMGARAGELENGTH = 2;

    private static final String DEFAULT_PROPSUBTYPE = "AAAAAAAAAA";
    private static final String UPDATED_PROPSUBTYPE = "BBBBBBBBBB";

    private static final Integer DEFAULT_BEDS = 1;
    private static final Integer UPDATED_BEDS = 2;

    private static final Integer DEFAULT_ROOMMASTERBEDWIDTH = 1;
    private static final Integer UPDATED_ROOMMASTERBEDWIDTH = 2;

    private static final Integer DEFAULT_ROOMSTUDYLENGTH = 1;
    private static final Integer UPDATED_ROOMSTUDYLENGTH = 2;

    private static final String DEFAULT_AGENTLIST = "AAAAAAAAAA";
    private static final String UPDATED_AGENTLIST = "BBBBBBBBBB";

    private static final String DEFAULT_STREETNAME = "AAAAAAAAAA";
    private static final String UPDATED_STREETNAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMBREAKFASTLENGTH = 1;
    private static final Integer UPDATED_ROOMBREAKFASTLENGTH = 2;

    private static final Integer DEFAULT_ROOMKITCHENWIDTH = 1;
    private static final Integer UPDATED_ROOMKITCHENWIDTH = 2;

    private static final String DEFAULT_FENCE = "AAAAAAAAAA";
    private static final String UPDATED_FENCE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_BATHSTOTAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_BATHSTOTAL = new BigDecimal(2);

    private static final Integer DEFAULT_GARAGECAP = 1;
    private static final Integer UPDATED_GARAGECAP = 2;

    private static final BigDecimal DEFAULT_SQFTPRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_SQFTPRICE = new BigDecimal(2);

    private static final String DEFAULT_STYLE = "AAAAAAAAAA";
    private static final String UPDATED_STYLE = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERIOR = "AAAAAAAAAA";
    private static final String UPDATED_EXTERIOR = "BBBBBBBBBB";

    private static final String DEFAULT_FOUNDATION = "AAAAAAAAAA";
    private static final String UPDATED_FOUNDATION = "BBBBBBBBBB";

    private static final String DEFAULT_INTERIOR = "AAAAAAAAAA";
    private static final String UPDATED_INTERIOR = "BBBBBBBBBB";

    private static final String DEFAULT_POOLYN = "AAAAAAAAAA";
    private static final String UPDATED_POOLYN = "BBBBBBBBBB";

    private static final String DEFAULT_POOL_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_POOL_FEATURE = "BBBBBBBBBB";

    private static final Integer DEFAULT_LISTPRICE = 1;
    private static final Integer UPDATED_LISTPRICE = 2;

    private static final String DEFAULT_LISTPRICERANGE = "A";
    private static final String UPDATED_LISTPRICERANGE = "B";

    private static final String DEFAULT_MLSNUM = "AAAAAAAAAA";
    private static final String UPDATED_MLSNUM = "BBBBBBBBBB";

    private static final Integer DEFAULT_MATRIXID = 1;
    private static final Integer UPDATED_MATRIXID = 2;

    private static final String DEFAULT_REMARKS = "AAAAAAAAAA";
    private static final String UPDATED_REMARKS = "BBBBBBBBBB";

    private static final String DEFAULT_STATE = "AAAAAAAAAA";
    private static final String UPDATED_STATE = "BBBBBBBBBB";

    private static final String DEFAULT_ROOF = "AAAAAAAAAA";
    private static final String UPDATED_ROOF = "BBBBBBBBBB";

    private static final String DEFAULT_SECURITYFEATURES = "AAAAAAAAAA";
    private static final String UPDATED_SECURITYFEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_UTILITIESOTHER = "AAAAAAAAAA";
    private static final String UPDATED_UTILITIESOTHER = "BBBBBBBBBB";

    private static final String DEFAULT_COMMONFEATURES = "AAAAAAAAAA";
    private static final String UPDATED_COMMONFEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_CONSTRUCTION = "AAAAAAAAAA";
    private static final String UPDATED_CONSTRUCTION = "BBBBBBBBBB";

    private static final Instant DEFAULT_MODIFIED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MODIFIED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_STORIES = 1;
    private static final Integer UPDATED_STORIES = 2;

    private static final Integer DEFAULT_ROOMDININGLENGTH = 1;
    private static final Integer UPDATED_ROOMDININGLENGTH = 2;

    private static final Integer DEFAULT_ROOMLIVING_1_LENGTH = 1;
    private static final Integer UPDATED_ROOMLIVING_1_LENGTH = 2;

    private static final String DEFAULT_OPENHOUSETIME = "AAAAAAAAAA";
    private static final String UPDATED_OPENHOUSETIME = "BBBBBBBBBB";

    private static final String DEFAULT_OPENHOUSEENDTIME = "AAAAAAAAAA";
    private static final String UPDATED_OPENHOUSEENDTIME = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMLIVING_2_LENGTH = 1;
    private static final Integer UPDATED_ROOMLIVING_2_LENGTH = 2;

    private static final String DEFAULT_LOTDESC = "AAAAAAAAAA";
    private static final String UPDATED_LOTDESC = "BBBBBBBBBB";

    private static final Instant DEFAULT_OPENHOUSEDATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_OPENHOUSEDATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_ROOMMASTERBEDLENGTH = 1;
    private static final Integer UPDATED_ROOMMASTERBEDLENGTH = 2;

    private static final Integer DEFAULT_ROOMOTHER_1_LENGTH = 1;
    private static final Integer UPDATED_ROOMOTHER_1_LENGTH = 2;

    private static final String DEFAULT_OFFICESELL_OFFICENAM_2 = "AAAAAAAAAA";
    private static final String UPDATED_OFFICESELL_OFFICENAM_2 = "BBBBBBBBBB";

    private static final String DEFAULT_LOTSIZE = "AAAAAAAAAA";
    private static final String UPDATED_LOTSIZE = "BBBBBBBBBB";

    private static final String DEFAULT_STREETDIRSUFFIX = "AAAAAAAAAA";
    private static final String UPDATED_STREETDIRSUFFIX = "BBBBBBBBBB";

    private static final Integer DEFAULT_PHOTOCOUNT = 1;
    private static final Integer UPDATED_PHOTOCOUNT = 2;

    private static final String DEFAULT_SCHOOLDISTRICT = "AAAAAAAAAA";
    private static final String UPDATED_SCHOOLDISTRICT = "BBBBBBBBBB";

    private static final Integer DEFAULT_STREETNUM = 1;
    private static final Integer UPDATED_STREETNUM = 2;

    private static final String DEFAULT_UTILITIES = "AAAAAAAAAA";
    private static final String UPDATED_UTILITIES = "BBBBBBBBBB";

    private static final String DEFAULT_EQUIPMENT = "AAAAAAAAAA";
    private static final String UPDATED_EQUIPMENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMBED_4_WIDTH = 1;
    private static final Integer UPDATED_ROOMBED_4_WIDTH = 2;

    private static final Integer DEFAULT_ROOMKITCHENLENGTH = 1;
    private static final Integer UPDATED_ROOMKITCHENLENGTH = 2;

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_GARAGEDESC = "AAAAAAAAAA";
    private static final String UPDATED_GARAGEDESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_BATHSFULL = 1;
    private static final Integer UPDATED_BATHSFULL = 2;

    private static final Integer DEFAULT_ROOMBED_3_WIDTH = 1;
    private static final Integer UPDATED_ROOMBED_3_WIDTH = 2;

    private static final String DEFAULT_ROOMUTILDESC = "AAAAAAAAAA";
    private static final String UPDATED_ROOMUTILDESC = "BBBBBBBBBB";

    private static final Integer DEFAULT_ROOMUTILITYWIDTH = 1;
    private static final Integer UPDATED_ROOMUTILITYWIDTH = 2;

    private static final String DEFAULT_ROOMFULLBATHLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMFULLBATHLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMFULLBATHWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMFULLBATHWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMHALFBATHLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMHALFBATHLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMHALFBATHWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMHALFBATHWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMEXERCISELENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMEXERCISELENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMEXERCISEWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMEXERCISEWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSTORAGELENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSTORAGELENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSTORAGEWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSTORAGEWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMGAMELENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMGAMELENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMGAMEWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMGAMEWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMGUESTLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMGUESTLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMGUESTWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMGUESTWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMLIBRARYLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMLIBRARYLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMLIBRARYWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMLIBRARYWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMMEDIALENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMMEDIALENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMMEDIAWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMMEDIAWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMMUDLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMMUDLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMMUDWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMMUDWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMOFFICELENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMOFFICELENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMOFFICEWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMOFFICEWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSAUNALENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSAUNALENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSAUNAWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSAUNAWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSECONDMASTERLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSECONDMASTERLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSECONDMASTERWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSECONDMASTERWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSUNLENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSUNLENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSUNWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSUNWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSPALENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSPALENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMSPAWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMSPAWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMWINELENGTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMWINELENGTH = "BBBBBBBBBB";

    private static final String DEFAULT_ROOMWINEWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_ROOMWINEWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_JUNIORHIGHSCHOOLNAME = "AAAAAAAAAA";
    private static final String UPDATED_JUNIORHIGHSCHOOLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PRIMARYSCHOOLNAME = "AAAAAAAAAA";
    private static final String UPDATED_PRIMARYSCHOOLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_SENIORHIGHSCHOOLNAME = "AAAAAAAAAA";
    private static final String UPDATED_SENIORHIGHSCHOOLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_ASSOCIATIONFEE = "AAAAAAAAAA";
    private static final String UPDATED_ASSOCIATIONFEE = "BBBBBBBBBB";

    private static final String DEFAULT_ASSOCIATIONFEEFREQUENCY = "AAAAAAAAAA";
    private static final String UPDATED_ASSOCIATIONFEEFREQUENCY = "BBBBBBBBBB";

    private static final String DEFAULT_CONSTRUCTIONMATERIALS = "AAAAAAAAAA";
    private static final String UPDATED_CONSTRUCTIONMATERIALS = "BBBBBBBBBB";

    private static final String DEFAULT_HEATING = "AAAAAAAAAA";
    private static final String UPDATED_HEATING = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESSORYUNITTYPE = "AAAAAAAAAA";
    private static final String UPDATED_ACCESSORYUNITTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESSORYUNITYN = "AAAAAAAAAA";
    private static final String UPDATED_ACCESSORYUNITYN = "BBBBBBBBBB";

    private static final String DEFAULT_FLOORING = "AAAAAAAAAA";
    private static final String UPDATED_FLOORING = "BBBBBBBBBB";

    private static final String DEFAULT_FIREPLACESTOTAL = "AAAAAAAAAA";
    private static final String UPDATED_FIREPLACESTOTAL = "BBBBBBBBBB";

    private static final String DEFAULT_FIREPLACEFEATURES = "AAAAAAAAAA";
    private static final String UPDATED_FIREPLACEFEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_SECURITYSYSTEMYN = "AAAAAAAAAA";
    private static final String UPDATED_SECURITYSYSTEMYN = "BBBBBBBBBB";

    private static final String DEFAULT_GREENBUILDINGCERTIFICATION = "AAAAAAAAAA";
    private static final String UPDATED_GREENBUILDINGCERTIFICATION = "BBBBBBBBBB";

    private static final String DEFAULT_GREENENERGYEFFICIENT = "AAAAAAAAAA";
    private static final String UPDATED_GREENENERGYEFFICIENT = "BBBBBBBBBB";

    private static final String DEFAULT_ENERGYSAVINGFEATURES = "AAAAAAAAAA";
    private static final String UPDATED_ENERGYSAVINGFEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_LOTNUMBER = "AAAAAAAAAA";
    private static final String UPDATED_LOTNUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_LOTSIZEAREA = "AAAAAAAAAA";
    private static final String UPDATED_LOTSIZEAREA = "BBBBBBBBBB";

    private static final String DEFAULT_LOTSIZEDIMENSIONS = "AAAAAAAAAA";
    private static final String UPDATED_LOTSIZEDIMENSIONS = "BBBBBBBBBB";

    private static final String DEFAULT_EASEMENTS = "AAAAAAAAAA";
    private static final String UPDATED_EASEMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_RESTRICTIONS = "AAAAAAAAAA";
    private static final String UPDATED_RESTRICTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_WASHERDRYERCONNECTIONS = "AAAAAAAAAA";
    private static final String UPDATED_WASHERDRYERCONNECTIONS = "BBBBBBBBBB";

    private static final String DEFAULT_MUNICIPALUTILITYDISTRICTYN = "AAAAAAAAAA";
    private static final String UPDATED_MUNICIPALUTILITYDISTRICTYN = "BBBBBBBBBB";

    private static final String DEFAULT_ASSOCIATIONFEEINCLUDES = "AAAAAAAAAA";
    private static final String UPDATED_ASSOCIATIONFEEINCLUDES = "BBBBBBBBBB";

    private static final String DEFAULT_ASSOCIATIONTYPE = "AAAAAAAAAA";
    private static final String UPDATED_ASSOCIATIONTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_BARNINFORMATION = "AAAAAAAAAA";
    private static final String UPDATED_BARNINFORMATION = "BBBBBBBBBB";

    private static final String DEFAULT_CONSTRUCTIONMATERIALSWALLS = "AAAAAAAAAA";
    private static final String UPDATED_CONSTRUCTIONMATERIALSWALLS = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTYORPARISH = "AAAAAAAAAA";
    private static final String UPDATED_COUNTYORPARISH = "BBBBBBBBBB";

    private static final String DEFAULT_EXTERIORBUILDINGS = "AAAAAAAAAA";
    private static final String UPDATED_EXTERIORBUILDINGS = "BBBBBBBBBB";

    private static final String DEFAULT_FARMRANCHFEATURES = "AAAAAAAAAA";
    private static final String UPDATED_FARMRANCHFEATURES = "BBBBBBBBBB";

    private static final String DEFAULT_FENCEDYARDYN = "AAAAAAAAAA";
    private static final String UPDATED_FENCEDYARDYN = "BBBBBBBBBB";

    private static final String DEFAULT_FINANCINGPROPOSED = "AAAAAAAAAA";
    private static final String UPDATED_FINANCINGPROPOSED = "BBBBBBBBBB";

    private static final String DEFAULT_HANDICAPYN = "AAAAAAAAAA";
    private static final String UPDATED_HANDICAPYN = "BBBBBBBBBB";

    private static final String DEFAULT_NUMBEROFTANKSANDPONDS = "AAAAAAAAAA";
    private static final String UPDATED_NUMBEROFTANKSANDPONDS = "BBBBBBBBBB";

    private static final String DEFAULT_PARCELNUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PARCELNUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_VIRTUALTOURURLUNBRANDED = "AAAAAAAAAA";
    private static final String UPDATED_VIRTUALTOURURLUNBRANDED = "BBBBBBBBBB";

    private static final String DEFAULT_LIVING_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_LIVING_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_MASTER_BED_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_MASTER_BED_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_BED_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_BED_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_DINING_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_DINING_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_KITCHEN_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_KITCHEN_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_BREAKFAST_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_BREAKFAST_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_STUDY_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_STUDY_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_UTILITY_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_UTILITY_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_BATH_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_FULL_BATH_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_HALF_BATH_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_HALF_BATH_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_EXERCISE_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_EXERCISE_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_EXTRA_STORAGE_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_EXTRA_STORAGE_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_GAME_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_GAME_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_GUEST_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_GUEST_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_LIBRARY_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_LIBRARY_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_MEDIA_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_MEDIA_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_MUD_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_MUD_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_OFFICE_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_OFFICE_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_SAUNA_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_SAUNA_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_SECOND_MASTER_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_SECOND_MASTER_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_SUNROOM_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_SUNROOM_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_SPA_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_SPA_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_WINE_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_WINE_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_OTHER_ROOM_FEATURE = "AAAAAAAAAA";
    private static final String UPDATED_OTHER_ROOM_FEATURE = "BBBBBBBBBB";

    private static final String DEFAULT_IS_LUXURY = "AAAAA";
    private static final String UPDATED_IS_LUXURY = "BBBBB";

    private static final String DEFAULT_IS_MOVE_IN_READY = "AAAAA";
    private static final String UPDATED_IS_MOVE_IN_READY = "BBBBB";

    private static final String DEFAULT_PHOTO_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_1_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_1_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_2_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_2_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_3_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_3_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_4_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_4_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_5_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_5_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_6_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_6_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_7_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_7_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_8_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_8_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_9_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_9_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_10_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_10_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_11_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_11_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_12_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_12_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_13_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_13_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_14_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_14_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_15_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_15_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_16_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_16_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_17_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_17_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_18_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_18_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_19_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_19_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_20_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_20_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_21_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_21_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_22_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_22_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_23_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_23_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_24_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_24_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_25_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_25_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_26_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_26_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_27_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_27_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_28_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_28_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_29_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_29_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_30_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_30_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_31_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_31_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_32_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_32_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_33_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_33_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_34_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_34_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_35_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_35_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_36_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_36_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_37_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_37_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_38_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_38_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_39_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_39_URL = "BBBBBBBBBB";

    private static final String DEFAULT_PHOTO_40_URL = "AAAAAAAAAA";
    private static final String UPDATED_PHOTO_40_URL = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_MODIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MODIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IMG_DELETED = false;
    private static final Boolean UPDATED_IMG_DELETED = true;

    private static final String DEFAULT_RETS_SERVER = "AAAAAAAAAA";
    private static final String UPDATED_RETS_SERVER = "BBBBBBBBBB";

    private static final String DEFAULT_PERMALINK = "AAAAAAAAAA";
    private static final String UPDATED_PERMALINK = "BBBBBBBBBB";

    private static final String DEFAULT_PROPERTY_TAG = "AAAAAAAAAA";
    private static final String UPDATED_PROPERTY_TAG = "BBBBBBBBBB";

    private static final Integer DEFAULT_BUILDENTORY_VIEWS = 1;
    private static final Integer UPDATED_BUILDENTORY_VIEWS = 2;

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/res-properties";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ResPropertiesRepository resPropertiesRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restResPropertiesMockMvc;

    private ResProperties resProperties;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResProperties createEntity(EntityManager em) {
        ResProperties resProperties = new ResProperties()
            .communityId(DEFAULT_COMMUNITY_ID)
            .communityName(DEFAULT_COMMUNITY_NAME)
            .builderId(DEFAULT_BUILDER_ID)
            .specialOffers(DEFAULT_SPECIAL_OFFERS)
            .brochure(DEFAULT_BROCHURE)
            .floorPlanId(DEFAULT_FLOOR_PLAN_ID)
            .latitude(DEFAULT_LATITUDE)
            .longitude(DEFAULT_LONGITUDE)
            .county(DEFAULT_COUNTY)
            .heatsystem(DEFAULT_HEATSYSTEM)
            .liststatus(DEFAULT_LISTSTATUS)
            .liststatusflag(DEFAULT_LISTSTATUSFLAG)
            .carportcap(DEFAULT_CARPORTCAP)
            .possession(DEFAULT_POSSESSION)
            .schoolname1(DEFAULT_SCHOOLNAME_1)
            .subdivide(DEFAULT_SUBDIVIDE)
            .vowavmyn(DEFAULT_VOWAVMYN)
            .presentuse(DEFAULT_PRESENTUSE)
            .proposeduse(DEFAULT_PROPOSEDUSE)
            .ranchname(DEFAULT_RANCHNAME)
            .roombed2width(DEFAULT_ROOMBED_2_WIDTH)
            .roomdininglevel(DEFAULT_ROOMDININGLEVEL)
            .roomliving2width(DEFAULT_ROOMLIVING_2_WIDTH)
            .roomstudylevel(DEFAULT_ROOMSTUDYLEVEL)
            .area(DEFAULT_AREA)
            .areatitle(DEFAULT_AREATITLE)
            .assocfee(DEFAULT_ASSOCFEE)
            .financeproposed(DEFAULT_FINANCEPROPOSED)
            .listpriceorig(DEFAULT_LISTPRICEORIG)
            .mapcoord(DEFAULT_MAPCOORD)
            .schoolname2(DEFAULT_SCHOOLNAME_2)
            .roomgaragewidth(DEFAULT_ROOMGARAGEWIDTH)
            .roomkitchendesc(DEFAULT_ROOMKITCHENDESC)
            .roomliving1width(DEFAULT_ROOMLIVING_1_WIDTH)
            .roomother2width(DEFAULT_ROOMOTHER_2_WIDTH)
            .sqfttotal(DEFAULT_SQFTTOTAL)
            .officelistOfficenam1(DEFAULT_OFFICELIST_OFFICENAM_1)
            .schoolname3(DEFAULT_SCHOOLNAME_3)
            .zipcode(DEFAULT_ZIPCODE)
            .barn1length(DEFAULT_BARN_1_LENGTH)
            .barn3width(DEFAULT_BARN_3_WIDTH)
            .roombed2length(DEFAULT_ROOMBED_2_LENGTH)
            .roombed3length(DEFAULT_ROOMBED_3_LENGTH)
            .roomother1width(DEFAULT_ROOMOTHER_1_WIDTH)
            .agentlistFullname(DEFAULT_AGENTLIST_FULLNAME)
            .proptype(DEFAULT_PROPTYPE)
            .mlsProptype(DEFAULT_MLS_PROPTYPE)
            .schoolname4(DEFAULT_SCHOOLNAME_4)
            .acrescultivated(DEFAULT_ACRESCULTIVATED)
            .barn2length(DEFAULT_BARN_2_LENGTH)
            .barn2width(DEFAULT_BARN_2_WIDTH)
            .complexname(DEFAULT_COMPLEXNAME)
            .roombed4length(DEFAULT_ROOMBED_4_LENGTH)
            .roombedbathdesc(DEFAULT_ROOMBEDBATHDESC)
            .roombreakfastwidth(DEFAULT_ROOMBREAKFASTWIDTH)
            .roomother(DEFAULT_ROOMOTHER)
            .roomutilitylength(DEFAULT_ROOMUTILITYLENGTH)
            .acres(DEFAULT_ACRES)
            .block(DEFAULT_BLOCK)
            .directions(DEFAULT_DIRECTIONS)
            .subdivision(DEFAULT_SUBDIVISION)
            .yearbuilt(DEFAULT_YEARBUILT)
            .yearbuiltdetails(DEFAULT_YEARBUILTDETAILS)
            .agexemption(DEFAULT_AGEXEMPTION)
            .barn1width(DEFAULT_BARN_1_WIDTH)
            .barn3length(DEFAULT_BARN_3_LENGTH)
            .roomdiningwidth(DEFAULT_ROOMDININGWIDTH)
            .roomstudywidth(DEFAULT_ROOMSTUDYWIDTH)
            .soiltype(DEFAULT_SOILTYPE)
            .appraisername(DEFAULT_APPRAISERNAME)
            .listpricelow(DEFAULT_LISTPRICELOW)
            .mappage(DEFAULT_MAPPAGE)
            .unitnumber(DEFAULT_UNITNUMBER)
            .streetdir(DEFAULT_STREETDIR)
            .streettype(DEFAULT_STREETTYPE)
            .subarea(DEFAULT_SUBAREA)
            .subareatitle(DEFAULT_SUBAREATITLE)
            .bathshalf(DEFAULT_BATHSHALF)
            .roomgaragelength(DEFAULT_ROOMGARAGELENGTH)
            .propsubtype(DEFAULT_PROPSUBTYPE)
            .beds(DEFAULT_BEDS)
            .roommasterbedwidth(DEFAULT_ROOMMASTERBEDWIDTH)
            .roomstudylength(DEFAULT_ROOMSTUDYLENGTH)
            .agentlist(DEFAULT_AGENTLIST)
            .streetname(DEFAULT_STREETNAME)
            .roombreakfastlength(DEFAULT_ROOMBREAKFASTLENGTH)
            .roomkitchenwidth(DEFAULT_ROOMKITCHENWIDTH)
            .fence(DEFAULT_FENCE)
            .bathstotal(DEFAULT_BATHSTOTAL)
            .garagecap(DEFAULT_GARAGECAP)
            .sqftprice(DEFAULT_SQFTPRICE)
            .style(DEFAULT_STYLE)
            .exterior(DEFAULT_EXTERIOR)
            .foundation(DEFAULT_FOUNDATION)
            .interior(DEFAULT_INTERIOR)
            .poolyn(DEFAULT_POOLYN)
            .poolFeature(DEFAULT_POOL_FEATURE)
            .listprice(DEFAULT_LISTPRICE)
            .listpricerange(DEFAULT_LISTPRICERANGE)
            .mlsnum(DEFAULT_MLSNUM)
            .matrixid(DEFAULT_MATRIXID)
            .remarks(DEFAULT_REMARKS)
            .state(DEFAULT_STATE)
            .roof(DEFAULT_ROOF)
            .securityfeatures(DEFAULT_SECURITYFEATURES)
            .utilitiesother(DEFAULT_UTILITIESOTHER)
            .commonfeatures(DEFAULT_COMMONFEATURES)
            .construction(DEFAULT_CONSTRUCTION)
            .modified(DEFAULT_MODIFIED)
            .stories(DEFAULT_STORIES)
            .roomdininglength(DEFAULT_ROOMDININGLENGTH)
            .roomliving1length(DEFAULT_ROOMLIVING_1_LENGTH)
            .openhousetime(DEFAULT_OPENHOUSETIME)
            .openhouseendtime(DEFAULT_OPENHOUSEENDTIME)
            .roomliving2length(DEFAULT_ROOMLIVING_2_LENGTH)
            .lotdesc(DEFAULT_LOTDESC)
            .openhousedate(DEFAULT_OPENHOUSEDATE)
            .roommasterbedlength(DEFAULT_ROOMMASTERBEDLENGTH)
            .roomother1length(DEFAULT_ROOMOTHER_1_LENGTH)
            .officesellOfficenam2(DEFAULT_OFFICESELL_OFFICENAM_2)
            .lotsize(DEFAULT_LOTSIZE)
            .streetdirsuffix(DEFAULT_STREETDIRSUFFIX)
            .photocount(DEFAULT_PHOTOCOUNT)
            .schooldistrict(DEFAULT_SCHOOLDISTRICT)
            .streetnum(DEFAULT_STREETNUM)
            .utilities(DEFAULT_UTILITIES)
            .equipment(DEFAULT_EQUIPMENT)
            .roombed4width(DEFAULT_ROOMBED_4_WIDTH)
            .roomkitchenlength(DEFAULT_ROOMKITCHENLENGTH)
            .city(DEFAULT_CITY)
            .garagedesc(DEFAULT_GARAGEDESC)
            .bathsfull(DEFAULT_BATHSFULL)
            .roombed3width(DEFAULT_ROOMBED_3_WIDTH)
            .roomutildesc(DEFAULT_ROOMUTILDESC)
            .roomutilitywidth(DEFAULT_ROOMUTILITYWIDTH)
            .roomfullbathlength(DEFAULT_ROOMFULLBATHLENGTH)
            .roomfullbathwidth(DEFAULT_ROOMFULLBATHWIDTH)
            .roomhalfbathlength(DEFAULT_ROOMHALFBATHLENGTH)
            .roomhalfbathwidth(DEFAULT_ROOMHALFBATHWIDTH)
            .roomexerciselength(DEFAULT_ROOMEXERCISELENGTH)
            .roomexercisewidth(DEFAULT_ROOMEXERCISEWIDTH)
            .roomstoragelength(DEFAULT_ROOMSTORAGELENGTH)
            .roomstoragewidth(DEFAULT_ROOMSTORAGEWIDTH)
            .roomgamelength(DEFAULT_ROOMGAMELENGTH)
            .roomgamewidth(DEFAULT_ROOMGAMEWIDTH)
            .roomguestlength(DEFAULT_ROOMGUESTLENGTH)
            .roomguestwidth(DEFAULT_ROOMGUESTWIDTH)
            .roomlibrarylength(DEFAULT_ROOMLIBRARYLENGTH)
            .roomlibrarywidth(DEFAULT_ROOMLIBRARYWIDTH)
            .roommedialength(DEFAULT_ROOMMEDIALENGTH)
            .roommediawidth(DEFAULT_ROOMMEDIAWIDTH)
            .roommudlength(DEFAULT_ROOMMUDLENGTH)
            .roommudwidth(DEFAULT_ROOMMUDWIDTH)
            .roomofficelength(DEFAULT_ROOMOFFICELENGTH)
            .roomofficewidth(DEFAULT_ROOMOFFICEWIDTH)
            .roomsaunalength(DEFAULT_ROOMSAUNALENGTH)
            .roomsaunawidth(DEFAULT_ROOMSAUNAWIDTH)
            .roomsecondmasterlength(DEFAULT_ROOMSECONDMASTERLENGTH)
            .roomsecondmasterwidth(DEFAULT_ROOMSECONDMASTERWIDTH)
            .roomsunlength(DEFAULT_ROOMSUNLENGTH)
            .roomsunwidth(DEFAULT_ROOMSUNWIDTH)
            .roomspalength(DEFAULT_ROOMSPALENGTH)
            .roomspawidth(DEFAULT_ROOMSPAWIDTH)
            .roomwinelength(DEFAULT_ROOMWINELENGTH)
            .roomwinewidth(DEFAULT_ROOMWINEWIDTH)
            .juniorhighschoolname(DEFAULT_JUNIORHIGHSCHOOLNAME)
            .primaryschoolname(DEFAULT_PRIMARYSCHOOLNAME)
            .seniorhighschoolname(DEFAULT_SENIORHIGHSCHOOLNAME)
            .associationfee(DEFAULT_ASSOCIATIONFEE)
            .associationfeefrequency(DEFAULT_ASSOCIATIONFEEFREQUENCY)
            .constructionmaterials(DEFAULT_CONSTRUCTIONMATERIALS)
            .heating(DEFAULT_HEATING)
            .accessoryunittype(DEFAULT_ACCESSORYUNITTYPE)
            .accessoryunityn(DEFAULT_ACCESSORYUNITYN)
            .flooring(DEFAULT_FLOORING)
            .fireplacestotal(DEFAULT_FIREPLACESTOTAL)
            .fireplacefeatures(DEFAULT_FIREPLACEFEATURES)
            .securitysystemyn(DEFAULT_SECURITYSYSTEMYN)
            .greenbuildingcertification(DEFAULT_GREENBUILDINGCERTIFICATION)
            .greenenergyefficient(DEFAULT_GREENENERGYEFFICIENT)
            .energysavingfeatures(DEFAULT_ENERGYSAVINGFEATURES)
            .lotnumber(DEFAULT_LOTNUMBER)
            .lotsizearea(DEFAULT_LOTSIZEAREA)
            .lotsizedimensions(DEFAULT_LOTSIZEDIMENSIONS)
            .easements(DEFAULT_EASEMENTS)
            .restrictions(DEFAULT_RESTRICTIONS)
            .washerdryerconnections(DEFAULT_WASHERDRYERCONNECTIONS)
            .municipalutilitydistrictyn(DEFAULT_MUNICIPALUTILITYDISTRICTYN)
            .associationfeeincludes(DEFAULT_ASSOCIATIONFEEINCLUDES)
            .associationtype(DEFAULT_ASSOCIATIONTYPE)
            .barninformation(DEFAULT_BARNINFORMATION)
            .constructionmaterialswalls(DEFAULT_CONSTRUCTIONMATERIALSWALLS)
            .countyorparish(DEFAULT_COUNTYORPARISH)
            .exteriorbuildings(DEFAULT_EXTERIORBUILDINGS)
            .farmranchfeatures(DEFAULT_FARMRANCHFEATURES)
            .fencedyardyn(DEFAULT_FENCEDYARDYN)
            .financingproposed(DEFAULT_FINANCINGPROPOSED)
            .handicapyn(DEFAULT_HANDICAPYN)
            .numberoftanksandponds(DEFAULT_NUMBEROFTANKSANDPONDS)
            .parcelnumber(DEFAULT_PARCELNUMBER)
            .virtualtoururlunbranded(DEFAULT_VIRTUALTOURURLUNBRANDED)
            .livingRoomFeature(DEFAULT_LIVING_ROOM_FEATURE)
            .masterBedRoomFeature(DEFAULT_MASTER_BED_ROOM_FEATURE)
            .bedRoomFeature(DEFAULT_BED_ROOM_FEATURE)
            .diningRoomFeature(DEFAULT_DINING_ROOM_FEATURE)
            .kitchenRoomFeature(DEFAULT_KITCHEN_ROOM_FEATURE)
            .breakfastRoomFeature(DEFAULT_BREAKFAST_ROOM_FEATURE)
            .studyRoomFeature(DEFAULT_STUDY_ROOM_FEATURE)
            .utilityRoomFeature(DEFAULT_UTILITY_ROOM_FEATURE)
            .fullBathRoomFeature(DEFAULT_FULL_BATH_ROOM_FEATURE)
            .halfBathRoomFeature(DEFAULT_HALF_BATH_ROOM_FEATURE)
            .exerciseRoomFeature(DEFAULT_EXERCISE_ROOM_FEATURE)
            .extraStorageRoomFeature(DEFAULT_EXTRA_STORAGE_ROOM_FEATURE)
            .gameRoomFeature(DEFAULT_GAME_ROOM_FEATURE)
            .guestRoomFeature(DEFAULT_GUEST_ROOM_FEATURE)
            .libraryRoomFeature(DEFAULT_LIBRARY_ROOM_FEATURE)
            .mediaRoomFeature(DEFAULT_MEDIA_ROOM_FEATURE)
            .mudRoomFeature(DEFAULT_MUD_ROOM_FEATURE)
            .officeRoomFeature(DEFAULT_OFFICE_ROOM_FEATURE)
            .saunaRoomFeature(DEFAULT_SAUNA_ROOM_FEATURE)
            .secondMasterRoomFeature(DEFAULT_SECOND_MASTER_ROOM_FEATURE)
            .sunroomRoomFeature(DEFAULT_SUNROOM_ROOM_FEATURE)
            .spaRoomFeature(DEFAULT_SPA_ROOM_FEATURE)
            .wineRoomFeature(DEFAULT_WINE_ROOM_FEATURE)
            .otherRoomFeature(DEFAULT_OTHER_ROOM_FEATURE)
            .isLuxury(DEFAULT_IS_LUXURY)
            .isMoveInReady(DEFAULT_IS_MOVE_IN_READY)
            .photoUrl(DEFAULT_PHOTO_URL)
            .photo1Url(DEFAULT_PHOTO_1_URL)
            .photo2Url(DEFAULT_PHOTO_2_URL)
            .photo3Url(DEFAULT_PHOTO_3_URL)
            .photo4Url(DEFAULT_PHOTO_4_URL)
            .photo5Url(DEFAULT_PHOTO_5_URL)
            .photo6Url(DEFAULT_PHOTO_6_URL)
            .photo7Url(DEFAULT_PHOTO_7_URL)
            .photo8Url(DEFAULT_PHOTO_8_URL)
            .photo9Url(DEFAULT_PHOTO_9_URL)
            .photo10Url(DEFAULT_PHOTO_10_URL)
            .photo11Url(DEFAULT_PHOTO_11_URL)
            .photo12Url(DEFAULT_PHOTO_12_URL)
            .photo13Url(DEFAULT_PHOTO_13_URL)
            .photo14Url(DEFAULT_PHOTO_14_URL)
            .photo15Url(DEFAULT_PHOTO_15_URL)
            .photo16Url(DEFAULT_PHOTO_16_URL)
            .photo17Url(DEFAULT_PHOTO_17_URL)
            .photo18Url(DEFAULT_PHOTO_18_URL)
            .photo19Url(DEFAULT_PHOTO_19_URL)
            .photo20Url(DEFAULT_PHOTO_20_URL)
            .photo21Url(DEFAULT_PHOTO_21_URL)
            .photo22Url(DEFAULT_PHOTO_22_URL)
            .photo23Url(DEFAULT_PHOTO_23_URL)
            .photo24Url(DEFAULT_PHOTO_24_URL)
            .photo25Url(DEFAULT_PHOTO_25_URL)
            .photo26Url(DEFAULT_PHOTO_26_URL)
            .photo27Url(DEFAULT_PHOTO_27_URL)
            .photo28Url(DEFAULT_PHOTO_28_URL)
            .photo29Url(DEFAULT_PHOTO_29_URL)
            .photo30Url(DEFAULT_PHOTO_30_URL)
            .photo31Url(DEFAULT_PHOTO_31_URL)
            .photo32Url(DEFAULT_PHOTO_32_URL)
            .photo33Url(DEFAULT_PHOTO_33_URL)
            .photo34Url(DEFAULT_PHOTO_34_URL)
            .photo35Url(DEFAULT_PHOTO_35_URL)
            .photo36Url(DEFAULT_PHOTO_36_URL)
            .photo37Url(DEFAULT_PHOTO_37_URL)
            .photo38Url(DEFAULT_PHOTO_38_URL)
            .photo39Url(DEFAULT_PHOTO_39_URL)
            .photo40Url(DEFAULT_PHOTO_40_URL)
            .created(DEFAULT_CREATED)
            .updated(DEFAULT_UPDATED)
            .modifiedDate(DEFAULT_MODIFIED_DATE)
            .imgDeleted(DEFAULT_IMG_DELETED)
            .retsServer(DEFAULT_RETS_SERVER)
            .permalink(DEFAULT_PERMALINK)
            .propertyTag(DEFAULT_PROPERTY_TAG)
            .buildentoryViews(DEFAULT_BUILDENTORY_VIEWS)
            .location(DEFAULT_LOCATION);
        return resProperties;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ResProperties createUpdatedEntity(EntityManager em) {
        ResProperties resProperties = new ResProperties()
            .communityId(UPDATED_COMMUNITY_ID)
            .communityName(UPDATED_COMMUNITY_NAME)
            .builderId(UPDATED_BUILDER_ID)
            .specialOffers(UPDATED_SPECIAL_OFFERS)
            .brochure(UPDATED_BROCHURE)
            .floorPlanId(UPDATED_FLOOR_PLAN_ID)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .county(UPDATED_COUNTY)
            .heatsystem(UPDATED_HEATSYSTEM)
            .liststatus(UPDATED_LISTSTATUS)
            .liststatusflag(UPDATED_LISTSTATUSFLAG)
            .carportcap(UPDATED_CARPORTCAP)
            .possession(UPDATED_POSSESSION)
            .schoolname1(UPDATED_SCHOOLNAME_1)
            .subdivide(UPDATED_SUBDIVIDE)
            .vowavmyn(UPDATED_VOWAVMYN)
            .presentuse(UPDATED_PRESENTUSE)
            .proposeduse(UPDATED_PROPOSEDUSE)
            .ranchname(UPDATED_RANCHNAME)
            .roombed2width(UPDATED_ROOMBED_2_WIDTH)
            .roomdininglevel(UPDATED_ROOMDININGLEVEL)
            .roomliving2width(UPDATED_ROOMLIVING_2_WIDTH)
            .roomstudylevel(UPDATED_ROOMSTUDYLEVEL)
            .area(UPDATED_AREA)
            .areatitle(UPDATED_AREATITLE)
            .assocfee(UPDATED_ASSOCFEE)
            .financeproposed(UPDATED_FINANCEPROPOSED)
            .listpriceorig(UPDATED_LISTPRICEORIG)
            .mapcoord(UPDATED_MAPCOORD)
            .schoolname2(UPDATED_SCHOOLNAME_2)
            .roomgaragewidth(UPDATED_ROOMGARAGEWIDTH)
            .roomkitchendesc(UPDATED_ROOMKITCHENDESC)
            .roomliving1width(UPDATED_ROOMLIVING_1_WIDTH)
            .roomother2width(UPDATED_ROOMOTHER_2_WIDTH)
            .sqfttotal(UPDATED_SQFTTOTAL)
            .officelistOfficenam1(UPDATED_OFFICELIST_OFFICENAM_1)
            .schoolname3(UPDATED_SCHOOLNAME_3)
            .zipcode(UPDATED_ZIPCODE)
            .barn1length(UPDATED_BARN_1_LENGTH)
            .barn3width(UPDATED_BARN_3_WIDTH)
            .roombed2length(UPDATED_ROOMBED_2_LENGTH)
            .roombed3length(UPDATED_ROOMBED_3_LENGTH)
            .roomother1width(UPDATED_ROOMOTHER_1_WIDTH)
            .agentlistFullname(UPDATED_AGENTLIST_FULLNAME)
            .proptype(UPDATED_PROPTYPE)
            .mlsProptype(UPDATED_MLS_PROPTYPE)
            .schoolname4(UPDATED_SCHOOLNAME_4)
            .acrescultivated(UPDATED_ACRESCULTIVATED)
            .barn2length(UPDATED_BARN_2_LENGTH)
            .barn2width(UPDATED_BARN_2_WIDTH)
            .complexname(UPDATED_COMPLEXNAME)
            .roombed4length(UPDATED_ROOMBED_4_LENGTH)
            .roombedbathdesc(UPDATED_ROOMBEDBATHDESC)
            .roombreakfastwidth(UPDATED_ROOMBREAKFASTWIDTH)
            .roomother(UPDATED_ROOMOTHER)
            .roomutilitylength(UPDATED_ROOMUTILITYLENGTH)
            .acres(UPDATED_ACRES)
            .block(UPDATED_BLOCK)
            .directions(UPDATED_DIRECTIONS)
            .subdivision(UPDATED_SUBDIVISION)
            .yearbuilt(UPDATED_YEARBUILT)
            .yearbuiltdetails(UPDATED_YEARBUILTDETAILS)
            .agexemption(UPDATED_AGEXEMPTION)
            .barn1width(UPDATED_BARN_1_WIDTH)
            .barn3length(UPDATED_BARN_3_LENGTH)
            .roomdiningwidth(UPDATED_ROOMDININGWIDTH)
            .roomstudywidth(UPDATED_ROOMSTUDYWIDTH)
            .soiltype(UPDATED_SOILTYPE)
            .appraisername(UPDATED_APPRAISERNAME)
            .listpricelow(UPDATED_LISTPRICELOW)
            .mappage(UPDATED_MAPPAGE)
            .unitnumber(UPDATED_UNITNUMBER)
            .streetdir(UPDATED_STREETDIR)
            .streettype(UPDATED_STREETTYPE)
            .subarea(UPDATED_SUBAREA)
            .subareatitle(UPDATED_SUBAREATITLE)
            .bathshalf(UPDATED_BATHSHALF)
            .roomgaragelength(UPDATED_ROOMGARAGELENGTH)
            .propsubtype(UPDATED_PROPSUBTYPE)
            .beds(UPDATED_BEDS)
            .roommasterbedwidth(UPDATED_ROOMMASTERBEDWIDTH)
            .roomstudylength(UPDATED_ROOMSTUDYLENGTH)
            .agentlist(UPDATED_AGENTLIST)
            .streetname(UPDATED_STREETNAME)
            .roombreakfastlength(UPDATED_ROOMBREAKFASTLENGTH)
            .roomkitchenwidth(UPDATED_ROOMKITCHENWIDTH)
            .fence(UPDATED_FENCE)
            .bathstotal(UPDATED_BATHSTOTAL)
            .garagecap(UPDATED_GARAGECAP)
            .sqftprice(UPDATED_SQFTPRICE)
            .style(UPDATED_STYLE)
            .exterior(UPDATED_EXTERIOR)
            .foundation(UPDATED_FOUNDATION)
            .interior(UPDATED_INTERIOR)
            .poolyn(UPDATED_POOLYN)
            .poolFeature(UPDATED_POOL_FEATURE)
            .listprice(UPDATED_LISTPRICE)
            .listpricerange(UPDATED_LISTPRICERANGE)
            .mlsnum(UPDATED_MLSNUM)
            .matrixid(UPDATED_MATRIXID)
            .remarks(UPDATED_REMARKS)
            .state(UPDATED_STATE)
            .roof(UPDATED_ROOF)
            .securityfeatures(UPDATED_SECURITYFEATURES)
            .utilitiesother(UPDATED_UTILITIESOTHER)
            .commonfeatures(UPDATED_COMMONFEATURES)
            .construction(UPDATED_CONSTRUCTION)
            .modified(UPDATED_MODIFIED)
            .stories(UPDATED_STORIES)
            .roomdininglength(UPDATED_ROOMDININGLENGTH)
            .roomliving1length(UPDATED_ROOMLIVING_1_LENGTH)
            .openhousetime(UPDATED_OPENHOUSETIME)
            .openhouseendtime(UPDATED_OPENHOUSEENDTIME)
            .roomliving2length(UPDATED_ROOMLIVING_2_LENGTH)
            .lotdesc(UPDATED_LOTDESC)
            .openhousedate(UPDATED_OPENHOUSEDATE)
            .roommasterbedlength(UPDATED_ROOMMASTERBEDLENGTH)
            .roomother1length(UPDATED_ROOMOTHER_1_LENGTH)
            .officesellOfficenam2(UPDATED_OFFICESELL_OFFICENAM_2)
            .lotsize(UPDATED_LOTSIZE)
            .streetdirsuffix(UPDATED_STREETDIRSUFFIX)
            .photocount(UPDATED_PHOTOCOUNT)
            .schooldistrict(UPDATED_SCHOOLDISTRICT)
            .streetnum(UPDATED_STREETNUM)
            .utilities(UPDATED_UTILITIES)
            .equipment(UPDATED_EQUIPMENT)
            .roombed4width(UPDATED_ROOMBED_4_WIDTH)
            .roomkitchenlength(UPDATED_ROOMKITCHENLENGTH)
            .city(UPDATED_CITY)
            .garagedesc(UPDATED_GARAGEDESC)
            .bathsfull(UPDATED_BATHSFULL)
            .roombed3width(UPDATED_ROOMBED_3_WIDTH)
            .roomutildesc(UPDATED_ROOMUTILDESC)
            .roomutilitywidth(UPDATED_ROOMUTILITYWIDTH)
            .roomfullbathlength(UPDATED_ROOMFULLBATHLENGTH)
            .roomfullbathwidth(UPDATED_ROOMFULLBATHWIDTH)
            .roomhalfbathlength(UPDATED_ROOMHALFBATHLENGTH)
            .roomhalfbathwidth(UPDATED_ROOMHALFBATHWIDTH)
            .roomexerciselength(UPDATED_ROOMEXERCISELENGTH)
            .roomexercisewidth(UPDATED_ROOMEXERCISEWIDTH)
            .roomstoragelength(UPDATED_ROOMSTORAGELENGTH)
            .roomstoragewidth(UPDATED_ROOMSTORAGEWIDTH)
            .roomgamelength(UPDATED_ROOMGAMELENGTH)
            .roomgamewidth(UPDATED_ROOMGAMEWIDTH)
            .roomguestlength(UPDATED_ROOMGUESTLENGTH)
            .roomguestwidth(UPDATED_ROOMGUESTWIDTH)
            .roomlibrarylength(UPDATED_ROOMLIBRARYLENGTH)
            .roomlibrarywidth(UPDATED_ROOMLIBRARYWIDTH)
            .roommedialength(UPDATED_ROOMMEDIALENGTH)
            .roommediawidth(UPDATED_ROOMMEDIAWIDTH)
            .roommudlength(UPDATED_ROOMMUDLENGTH)
            .roommudwidth(UPDATED_ROOMMUDWIDTH)
            .roomofficelength(UPDATED_ROOMOFFICELENGTH)
            .roomofficewidth(UPDATED_ROOMOFFICEWIDTH)
            .roomsaunalength(UPDATED_ROOMSAUNALENGTH)
            .roomsaunawidth(UPDATED_ROOMSAUNAWIDTH)
            .roomsecondmasterlength(UPDATED_ROOMSECONDMASTERLENGTH)
            .roomsecondmasterwidth(UPDATED_ROOMSECONDMASTERWIDTH)
            .roomsunlength(UPDATED_ROOMSUNLENGTH)
            .roomsunwidth(UPDATED_ROOMSUNWIDTH)
            .roomspalength(UPDATED_ROOMSPALENGTH)
            .roomspawidth(UPDATED_ROOMSPAWIDTH)
            .roomwinelength(UPDATED_ROOMWINELENGTH)
            .roomwinewidth(UPDATED_ROOMWINEWIDTH)
            .juniorhighschoolname(UPDATED_JUNIORHIGHSCHOOLNAME)
            .primaryschoolname(UPDATED_PRIMARYSCHOOLNAME)
            .seniorhighschoolname(UPDATED_SENIORHIGHSCHOOLNAME)
            .associationfee(UPDATED_ASSOCIATIONFEE)
            .associationfeefrequency(UPDATED_ASSOCIATIONFEEFREQUENCY)
            .constructionmaterials(UPDATED_CONSTRUCTIONMATERIALS)
            .heating(UPDATED_HEATING)
            .accessoryunittype(UPDATED_ACCESSORYUNITTYPE)
            .accessoryunityn(UPDATED_ACCESSORYUNITYN)
            .flooring(UPDATED_FLOORING)
            .fireplacestotal(UPDATED_FIREPLACESTOTAL)
            .fireplacefeatures(UPDATED_FIREPLACEFEATURES)
            .securitysystemyn(UPDATED_SECURITYSYSTEMYN)
            .greenbuildingcertification(UPDATED_GREENBUILDINGCERTIFICATION)
            .greenenergyefficient(UPDATED_GREENENERGYEFFICIENT)
            .energysavingfeatures(UPDATED_ENERGYSAVINGFEATURES)
            .lotnumber(UPDATED_LOTNUMBER)
            .lotsizearea(UPDATED_LOTSIZEAREA)
            .lotsizedimensions(UPDATED_LOTSIZEDIMENSIONS)
            .easements(UPDATED_EASEMENTS)
            .restrictions(UPDATED_RESTRICTIONS)
            .washerdryerconnections(UPDATED_WASHERDRYERCONNECTIONS)
            .municipalutilitydistrictyn(UPDATED_MUNICIPALUTILITYDISTRICTYN)
            .associationfeeincludes(UPDATED_ASSOCIATIONFEEINCLUDES)
            .associationtype(UPDATED_ASSOCIATIONTYPE)
            .barninformation(UPDATED_BARNINFORMATION)
            .constructionmaterialswalls(UPDATED_CONSTRUCTIONMATERIALSWALLS)
            .countyorparish(UPDATED_COUNTYORPARISH)
            .exteriorbuildings(UPDATED_EXTERIORBUILDINGS)
            .farmranchfeatures(UPDATED_FARMRANCHFEATURES)
            .fencedyardyn(UPDATED_FENCEDYARDYN)
            .financingproposed(UPDATED_FINANCINGPROPOSED)
            .handicapyn(UPDATED_HANDICAPYN)
            .numberoftanksandponds(UPDATED_NUMBEROFTANKSANDPONDS)
            .parcelnumber(UPDATED_PARCELNUMBER)
            .virtualtoururlunbranded(UPDATED_VIRTUALTOURURLUNBRANDED)
            .livingRoomFeature(UPDATED_LIVING_ROOM_FEATURE)
            .masterBedRoomFeature(UPDATED_MASTER_BED_ROOM_FEATURE)
            .bedRoomFeature(UPDATED_BED_ROOM_FEATURE)
            .diningRoomFeature(UPDATED_DINING_ROOM_FEATURE)
            .kitchenRoomFeature(UPDATED_KITCHEN_ROOM_FEATURE)
            .breakfastRoomFeature(UPDATED_BREAKFAST_ROOM_FEATURE)
            .studyRoomFeature(UPDATED_STUDY_ROOM_FEATURE)
            .utilityRoomFeature(UPDATED_UTILITY_ROOM_FEATURE)
            .fullBathRoomFeature(UPDATED_FULL_BATH_ROOM_FEATURE)
            .halfBathRoomFeature(UPDATED_HALF_BATH_ROOM_FEATURE)
            .exerciseRoomFeature(UPDATED_EXERCISE_ROOM_FEATURE)
            .extraStorageRoomFeature(UPDATED_EXTRA_STORAGE_ROOM_FEATURE)
            .gameRoomFeature(UPDATED_GAME_ROOM_FEATURE)
            .guestRoomFeature(UPDATED_GUEST_ROOM_FEATURE)
            .libraryRoomFeature(UPDATED_LIBRARY_ROOM_FEATURE)
            .mediaRoomFeature(UPDATED_MEDIA_ROOM_FEATURE)
            .mudRoomFeature(UPDATED_MUD_ROOM_FEATURE)
            .officeRoomFeature(UPDATED_OFFICE_ROOM_FEATURE)
            .saunaRoomFeature(UPDATED_SAUNA_ROOM_FEATURE)
            .secondMasterRoomFeature(UPDATED_SECOND_MASTER_ROOM_FEATURE)
            .sunroomRoomFeature(UPDATED_SUNROOM_ROOM_FEATURE)
            .spaRoomFeature(UPDATED_SPA_ROOM_FEATURE)
            .wineRoomFeature(UPDATED_WINE_ROOM_FEATURE)
            .otherRoomFeature(UPDATED_OTHER_ROOM_FEATURE)
            .isLuxury(UPDATED_IS_LUXURY)
            .isMoveInReady(UPDATED_IS_MOVE_IN_READY)
            .photoUrl(UPDATED_PHOTO_URL)
            .photo1Url(UPDATED_PHOTO_1_URL)
            .photo2Url(UPDATED_PHOTO_2_URL)
            .photo3Url(UPDATED_PHOTO_3_URL)
            .photo4Url(UPDATED_PHOTO_4_URL)
            .photo5Url(UPDATED_PHOTO_5_URL)
            .photo6Url(UPDATED_PHOTO_6_URL)
            .photo7Url(UPDATED_PHOTO_7_URL)
            .photo8Url(UPDATED_PHOTO_8_URL)
            .photo9Url(UPDATED_PHOTO_9_URL)
            .photo10Url(UPDATED_PHOTO_10_URL)
            .photo11Url(UPDATED_PHOTO_11_URL)
            .photo12Url(UPDATED_PHOTO_12_URL)
            .photo13Url(UPDATED_PHOTO_13_URL)
            .photo14Url(UPDATED_PHOTO_14_URL)
            .photo15Url(UPDATED_PHOTO_15_URL)
            .photo16Url(UPDATED_PHOTO_16_URL)
            .photo17Url(UPDATED_PHOTO_17_URL)
            .photo18Url(UPDATED_PHOTO_18_URL)
            .photo19Url(UPDATED_PHOTO_19_URL)
            .photo20Url(UPDATED_PHOTO_20_URL)
            .photo21Url(UPDATED_PHOTO_21_URL)
            .photo22Url(UPDATED_PHOTO_22_URL)
            .photo23Url(UPDATED_PHOTO_23_URL)
            .photo24Url(UPDATED_PHOTO_24_URL)
            .photo25Url(UPDATED_PHOTO_25_URL)
            .photo26Url(UPDATED_PHOTO_26_URL)
            .photo27Url(UPDATED_PHOTO_27_URL)
            .photo28Url(UPDATED_PHOTO_28_URL)
            .photo29Url(UPDATED_PHOTO_29_URL)
            .photo30Url(UPDATED_PHOTO_30_URL)
            .photo31Url(UPDATED_PHOTO_31_URL)
            .photo32Url(UPDATED_PHOTO_32_URL)
            .photo33Url(UPDATED_PHOTO_33_URL)
            .photo34Url(UPDATED_PHOTO_34_URL)
            .photo35Url(UPDATED_PHOTO_35_URL)
            .photo36Url(UPDATED_PHOTO_36_URL)
            .photo37Url(UPDATED_PHOTO_37_URL)
            .photo38Url(UPDATED_PHOTO_38_URL)
            .photo39Url(UPDATED_PHOTO_39_URL)
            .photo40Url(UPDATED_PHOTO_40_URL)
            .created(UPDATED_CREATED)
            .updated(UPDATED_UPDATED)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .imgDeleted(UPDATED_IMG_DELETED)
            .retsServer(UPDATED_RETS_SERVER)
            .permalink(UPDATED_PERMALINK)
            .propertyTag(UPDATED_PROPERTY_TAG)
            .buildentoryViews(UPDATED_BUILDENTORY_VIEWS)
            .location(UPDATED_LOCATION);
        return resProperties;
    }

    @BeforeEach
    public void initTest() {
        resProperties = createEntity(em);
    }

    @Test
    @Transactional
    void createResProperties() throws Exception {
        int databaseSizeBeforeCreate = resPropertiesRepository.findAll().size();
        // Create the ResProperties
        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isCreated());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeCreate + 1);
        ResProperties testResProperties = resPropertiesList.get(resPropertiesList.size() - 1);
        assertThat(testResProperties.getCommunityId()).isEqualTo(DEFAULT_COMMUNITY_ID);
        assertThat(testResProperties.getCommunityName()).isEqualTo(DEFAULT_COMMUNITY_NAME);
        assertThat(testResProperties.getBuilderId()).isEqualTo(DEFAULT_BUILDER_ID);
        assertThat(testResProperties.getSpecialOffers()).isEqualTo(DEFAULT_SPECIAL_OFFERS);
        assertThat(testResProperties.getBrochure()).isEqualTo(DEFAULT_BROCHURE);
        assertThat(testResProperties.getFloorPlanId()).isEqualTo(DEFAULT_FLOOR_PLAN_ID);
        assertThat(testResProperties.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testResProperties.getLongitude()).isEqualTo(DEFAULT_LONGITUDE);
        assertThat(testResProperties.getCounty()).isEqualTo(DEFAULT_COUNTY);
        assertThat(testResProperties.getHeatsystem()).isEqualTo(DEFAULT_HEATSYSTEM);
        assertThat(testResProperties.getListstatus()).isEqualTo(DEFAULT_LISTSTATUS);
        assertThat(testResProperties.getListstatusflag()).isEqualTo(DEFAULT_LISTSTATUSFLAG);
        assertThat(testResProperties.getCarportcap()).isEqualTo(DEFAULT_CARPORTCAP);
        assertThat(testResProperties.getPossession()).isEqualTo(DEFAULT_POSSESSION);
        assertThat(testResProperties.getSchoolname1()).isEqualTo(DEFAULT_SCHOOLNAME_1);
        assertThat(testResProperties.getSubdivide()).isEqualTo(DEFAULT_SUBDIVIDE);
        assertThat(testResProperties.getVowavmyn()).isEqualTo(DEFAULT_VOWAVMYN);
        assertThat(testResProperties.getPresentuse()).isEqualTo(DEFAULT_PRESENTUSE);
        assertThat(testResProperties.getProposeduse()).isEqualTo(DEFAULT_PROPOSEDUSE);
        assertThat(testResProperties.getRanchname()).isEqualTo(DEFAULT_RANCHNAME);
        assertThat(testResProperties.getRoombed2width()).isEqualTo(DEFAULT_ROOMBED_2_WIDTH);
        assertThat(testResProperties.getRoomdininglevel()).isEqualTo(DEFAULT_ROOMDININGLEVEL);
        assertThat(testResProperties.getRoomliving2width()).isEqualTo(DEFAULT_ROOMLIVING_2_WIDTH);
        assertThat(testResProperties.getRoomstudylevel()).isEqualTo(DEFAULT_ROOMSTUDYLEVEL);
        assertThat(testResProperties.getArea()).isEqualTo(DEFAULT_AREA);
        assertThat(testResProperties.getAreatitle()).isEqualTo(DEFAULT_AREATITLE);
        assertThat(testResProperties.getAssocfee()).isEqualTo(DEFAULT_ASSOCFEE);
        assertThat(testResProperties.getFinanceproposed()).isEqualTo(DEFAULT_FINANCEPROPOSED);
        assertThat(testResProperties.getListpriceorig()).isEqualTo(DEFAULT_LISTPRICEORIG);
        assertThat(testResProperties.getMapcoord()).isEqualTo(DEFAULT_MAPCOORD);
        assertThat(testResProperties.getSchoolname2()).isEqualTo(DEFAULT_SCHOOLNAME_2);
        assertThat(testResProperties.getRoomgaragewidth()).isEqualTo(DEFAULT_ROOMGARAGEWIDTH);
        assertThat(testResProperties.getRoomkitchendesc()).isEqualTo(DEFAULT_ROOMKITCHENDESC);
        assertThat(testResProperties.getRoomliving1width()).isEqualTo(DEFAULT_ROOMLIVING_1_WIDTH);
        assertThat(testResProperties.getRoomother2width()).isEqualTo(DEFAULT_ROOMOTHER_2_WIDTH);
        assertThat(testResProperties.getSqfttotal()).isEqualTo(DEFAULT_SQFTTOTAL);
        assertThat(testResProperties.getOfficelistOfficenam1()).isEqualTo(DEFAULT_OFFICELIST_OFFICENAM_1);
        assertThat(testResProperties.getSchoolname3()).isEqualTo(DEFAULT_SCHOOLNAME_3);
        assertThat(testResProperties.getZipcode()).isEqualTo(DEFAULT_ZIPCODE);
        assertThat(testResProperties.getBarn1length()).isEqualTo(DEFAULT_BARN_1_LENGTH);
        assertThat(testResProperties.getBarn3width()).isEqualTo(DEFAULT_BARN_3_WIDTH);
        assertThat(testResProperties.getRoombed2length()).isEqualTo(DEFAULT_ROOMBED_2_LENGTH);
        assertThat(testResProperties.getRoombed3length()).isEqualTo(DEFAULT_ROOMBED_3_LENGTH);
        assertThat(testResProperties.getRoomother1width()).isEqualTo(DEFAULT_ROOMOTHER_1_WIDTH);
        assertThat(testResProperties.getAgentlistFullname()).isEqualTo(DEFAULT_AGENTLIST_FULLNAME);
        assertThat(testResProperties.getProptype()).isEqualTo(DEFAULT_PROPTYPE);
        assertThat(testResProperties.getMlsProptype()).isEqualTo(DEFAULT_MLS_PROPTYPE);
        assertThat(testResProperties.getSchoolname4()).isEqualTo(DEFAULT_SCHOOLNAME_4);
        assertThat(testResProperties.getAcrescultivated()).isEqualByComparingTo(DEFAULT_ACRESCULTIVATED);
        assertThat(testResProperties.getBarn2length()).isEqualTo(DEFAULT_BARN_2_LENGTH);
        assertThat(testResProperties.getBarn2width()).isEqualTo(DEFAULT_BARN_2_WIDTH);
        assertThat(testResProperties.getComplexname()).isEqualTo(DEFAULT_COMPLEXNAME);
        assertThat(testResProperties.getRoombed4length()).isEqualTo(DEFAULT_ROOMBED_4_LENGTH);
        assertThat(testResProperties.getRoombedbathdesc()).isEqualTo(DEFAULT_ROOMBEDBATHDESC);
        assertThat(testResProperties.getRoombreakfastwidth()).isEqualTo(DEFAULT_ROOMBREAKFASTWIDTH);
        assertThat(testResProperties.getRoomother()).isEqualTo(DEFAULT_ROOMOTHER);
        assertThat(testResProperties.getRoomutilitylength()).isEqualTo(DEFAULT_ROOMUTILITYLENGTH);
        assertThat(testResProperties.getAcres()).isEqualByComparingTo(DEFAULT_ACRES);
        assertThat(testResProperties.getBlock()).isEqualTo(DEFAULT_BLOCK);
        assertThat(testResProperties.getDirections()).isEqualTo(DEFAULT_DIRECTIONS);
        assertThat(testResProperties.getSubdivision()).isEqualTo(DEFAULT_SUBDIVISION);
        assertThat(testResProperties.getYearbuilt()).isEqualTo(DEFAULT_YEARBUILT);
        assertThat(testResProperties.getYearbuiltdetails()).isEqualTo(DEFAULT_YEARBUILTDETAILS);
        assertThat(testResProperties.getAgexemption()).isEqualTo(DEFAULT_AGEXEMPTION);
        assertThat(testResProperties.getBarn1width()).isEqualTo(DEFAULT_BARN_1_WIDTH);
        assertThat(testResProperties.getBarn3length()).isEqualTo(DEFAULT_BARN_3_LENGTH);
        assertThat(testResProperties.getRoomdiningwidth()).isEqualTo(DEFAULT_ROOMDININGWIDTH);
        assertThat(testResProperties.getRoomstudywidth()).isEqualTo(DEFAULT_ROOMSTUDYWIDTH);
        assertThat(testResProperties.getSoiltype()).isEqualTo(DEFAULT_SOILTYPE);
        assertThat(testResProperties.getAppraisername()).isEqualTo(DEFAULT_APPRAISERNAME);
        assertThat(testResProperties.getListpricelow()).isEqualTo(DEFAULT_LISTPRICELOW);
        assertThat(testResProperties.getMappage()).isEqualTo(DEFAULT_MAPPAGE);
        assertThat(testResProperties.getUnitnumber()).isEqualTo(DEFAULT_UNITNUMBER);
        assertThat(testResProperties.getStreetdir()).isEqualTo(DEFAULT_STREETDIR);
        assertThat(testResProperties.getStreettype()).isEqualTo(DEFAULT_STREETTYPE);
        assertThat(testResProperties.getSubarea()).isEqualTo(DEFAULT_SUBAREA);
        assertThat(testResProperties.getSubareatitle()).isEqualTo(DEFAULT_SUBAREATITLE);
        assertThat(testResProperties.getBathshalf()).isEqualTo(DEFAULT_BATHSHALF);
        assertThat(testResProperties.getRoomgaragelength()).isEqualTo(DEFAULT_ROOMGARAGELENGTH);
        assertThat(testResProperties.getPropsubtype()).isEqualTo(DEFAULT_PROPSUBTYPE);
        assertThat(testResProperties.getBeds()).isEqualTo(DEFAULT_BEDS);
        assertThat(testResProperties.getRoommasterbedwidth()).isEqualTo(DEFAULT_ROOMMASTERBEDWIDTH);
        assertThat(testResProperties.getRoomstudylength()).isEqualTo(DEFAULT_ROOMSTUDYLENGTH);
        assertThat(testResProperties.getAgentlist()).isEqualTo(DEFAULT_AGENTLIST);
        assertThat(testResProperties.getStreetname()).isEqualTo(DEFAULT_STREETNAME);
        assertThat(testResProperties.getRoombreakfastlength()).isEqualTo(DEFAULT_ROOMBREAKFASTLENGTH);
        assertThat(testResProperties.getRoomkitchenwidth()).isEqualTo(DEFAULT_ROOMKITCHENWIDTH);
        assertThat(testResProperties.getFence()).isEqualTo(DEFAULT_FENCE);
        assertThat(testResProperties.getBathstotal()).isEqualByComparingTo(DEFAULT_BATHSTOTAL);
        assertThat(testResProperties.getGaragecap()).isEqualTo(DEFAULT_GARAGECAP);
        assertThat(testResProperties.getSqftprice()).isEqualByComparingTo(DEFAULT_SQFTPRICE);
        assertThat(testResProperties.getStyle()).isEqualTo(DEFAULT_STYLE);
        assertThat(testResProperties.getExterior()).isEqualTo(DEFAULT_EXTERIOR);
        assertThat(testResProperties.getFoundation()).isEqualTo(DEFAULT_FOUNDATION);
        assertThat(testResProperties.getInterior()).isEqualTo(DEFAULT_INTERIOR);
        assertThat(testResProperties.getPoolyn()).isEqualTo(DEFAULT_POOLYN);
        assertThat(testResProperties.getPoolFeature()).isEqualTo(DEFAULT_POOL_FEATURE);
        assertThat(testResProperties.getListprice()).isEqualTo(DEFAULT_LISTPRICE);
        assertThat(testResProperties.getListpricerange()).isEqualTo(DEFAULT_LISTPRICERANGE);
        assertThat(testResProperties.getMlsnum()).isEqualTo(DEFAULT_MLSNUM);
        assertThat(testResProperties.getMatrixid()).isEqualTo(DEFAULT_MATRIXID);
        assertThat(testResProperties.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testResProperties.getState()).isEqualTo(DEFAULT_STATE);
        assertThat(testResProperties.getRoof()).isEqualTo(DEFAULT_ROOF);
        assertThat(testResProperties.getSecurityfeatures()).isEqualTo(DEFAULT_SECURITYFEATURES);
        assertThat(testResProperties.getUtilitiesother()).isEqualTo(DEFAULT_UTILITIESOTHER);
        assertThat(testResProperties.getCommonfeatures()).isEqualTo(DEFAULT_COMMONFEATURES);
        assertThat(testResProperties.getConstruction()).isEqualTo(DEFAULT_CONSTRUCTION);
        assertThat(testResProperties.getModified()).isEqualTo(DEFAULT_MODIFIED);
        assertThat(testResProperties.getStories()).isEqualTo(DEFAULT_STORIES);
        assertThat(testResProperties.getRoomdininglength()).isEqualTo(DEFAULT_ROOMDININGLENGTH);
        assertThat(testResProperties.getRoomliving1length()).isEqualTo(DEFAULT_ROOMLIVING_1_LENGTH);
        assertThat(testResProperties.getOpenhousetime()).isEqualTo(DEFAULT_OPENHOUSETIME);
        assertThat(testResProperties.getOpenhouseendtime()).isEqualTo(DEFAULT_OPENHOUSEENDTIME);
        assertThat(testResProperties.getRoomliving2length()).isEqualTo(DEFAULT_ROOMLIVING_2_LENGTH);
        assertThat(testResProperties.getLotdesc()).isEqualTo(DEFAULT_LOTDESC);
        assertThat(testResProperties.getOpenhousedate()).isEqualTo(DEFAULT_OPENHOUSEDATE);
        assertThat(testResProperties.getRoommasterbedlength()).isEqualTo(DEFAULT_ROOMMASTERBEDLENGTH);
        assertThat(testResProperties.getRoomother1length()).isEqualTo(DEFAULT_ROOMOTHER_1_LENGTH);
        assertThat(testResProperties.getOfficesellOfficenam2()).isEqualTo(DEFAULT_OFFICESELL_OFFICENAM_2);
        assertThat(testResProperties.getLotsize()).isEqualTo(DEFAULT_LOTSIZE);
        assertThat(testResProperties.getStreetdirsuffix()).isEqualTo(DEFAULT_STREETDIRSUFFIX);
        assertThat(testResProperties.getPhotocount()).isEqualTo(DEFAULT_PHOTOCOUNT);
        assertThat(testResProperties.getSchooldistrict()).isEqualTo(DEFAULT_SCHOOLDISTRICT);
        assertThat(testResProperties.getStreetnum()).isEqualTo(DEFAULT_STREETNUM);
        assertThat(testResProperties.getUtilities()).isEqualTo(DEFAULT_UTILITIES);
        assertThat(testResProperties.getEquipment()).isEqualTo(DEFAULT_EQUIPMENT);
        assertThat(testResProperties.getRoombed4width()).isEqualTo(DEFAULT_ROOMBED_4_WIDTH);
        assertThat(testResProperties.getRoomkitchenlength()).isEqualTo(DEFAULT_ROOMKITCHENLENGTH);
        assertThat(testResProperties.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testResProperties.getGaragedesc()).isEqualTo(DEFAULT_GARAGEDESC);
        assertThat(testResProperties.getBathsfull()).isEqualTo(DEFAULT_BATHSFULL);
        assertThat(testResProperties.getRoombed3width()).isEqualTo(DEFAULT_ROOMBED_3_WIDTH);
        assertThat(testResProperties.getRoomutildesc()).isEqualTo(DEFAULT_ROOMUTILDESC);
        assertThat(testResProperties.getRoomutilitywidth()).isEqualTo(DEFAULT_ROOMUTILITYWIDTH);
        assertThat(testResProperties.getRoomfullbathlength()).isEqualTo(DEFAULT_ROOMFULLBATHLENGTH);
        assertThat(testResProperties.getRoomfullbathwidth()).isEqualTo(DEFAULT_ROOMFULLBATHWIDTH);
        assertThat(testResProperties.getRoomhalfbathlength()).isEqualTo(DEFAULT_ROOMHALFBATHLENGTH);
        assertThat(testResProperties.getRoomhalfbathwidth()).isEqualTo(DEFAULT_ROOMHALFBATHWIDTH);
        assertThat(testResProperties.getRoomexerciselength()).isEqualTo(DEFAULT_ROOMEXERCISELENGTH);
        assertThat(testResProperties.getRoomexercisewidth()).isEqualTo(DEFAULT_ROOMEXERCISEWIDTH);
        assertThat(testResProperties.getRoomstoragelength()).isEqualTo(DEFAULT_ROOMSTORAGELENGTH);
        assertThat(testResProperties.getRoomstoragewidth()).isEqualTo(DEFAULT_ROOMSTORAGEWIDTH);
        assertThat(testResProperties.getRoomgamelength()).isEqualTo(DEFAULT_ROOMGAMELENGTH);
        assertThat(testResProperties.getRoomgamewidth()).isEqualTo(DEFAULT_ROOMGAMEWIDTH);
        assertThat(testResProperties.getRoomguestlength()).isEqualTo(DEFAULT_ROOMGUESTLENGTH);
        assertThat(testResProperties.getRoomguestwidth()).isEqualTo(DEFAULT_ROOMGUESTWIDTH);
        assertThat(testResProperties.getRoomlibrarylength()).isEqualTo(DEFAULT_ROOMLIBRARYLENGTH);
        assertThat(testResProperties.getRoomlibrarywidth()).isEqualTo(DEFAULT_ROOMLIBRARYWIDTH);
        assertThat(testResProperties.getRoommedialength()).isEqualTo(DEFAULT_ROOMMEDIALENGTH);
        assertThat(testResProperties.getRoommediawidth()).isEqualTo(DEFAULT_ROOMMEDIAWIDTH);
        assertThat(testResProperties.getRoommudlength()).isEqualTo(DEFAULT_ROOMMUDLENGTH);
        assertThat(testResProperties.getRoommudwidth()).isEqualTo(DEFAULT_ROOMMUDWIDTH);
        assertThat(testResProperties.getRoomofficelength()).isEqualTo(DEFAULT_ROOMOFFICELENGTH);
        assertThat(testResProperties.getRoomofficewidth()).isEqualTo(DEFAULT_ROOMOFFICEWIDTH);
        assertThat(testResProperties.getRoomsaunalength()).isEqualTo(DEFAULT_ROOMSAUNALENGTH);
        assertThat(testResProperties.getRoomsaunawidth()).isEqualTo(DEFAULT_ROOMSAUNAWIDTH);
        assertThat(testResProperties.getRoomsecondmasterlength()).isEqualTo(DEFAULT_ROOMSECONDMASTERLENGTH);
        assertThat(testResProperties.getRoomsecondmasterwidth()).isEqualTo(DEFAULT_ROOMSECONDMASTERWIDTH);
        assertThat(testResProperties.getRoomsunlength()).isEqualTo(DEFAULT_ROOMSUNLENGTH);
        assertThat(testResProperties.getRoomsunwidth()).isEqualTo(DEFAULT_ROOMSUNWIDTH);
        assertThat(testResProperties.getRoomspalength()).isEqualTo(DEFAULT_ROOMSPALENGTH);
        assertThat(testResProperties.getRoomspawidth()).isEqualTo(DEFAULT_ROOMSPAWIDTH);
        assertThat(testResProperties.getRoomwinelength()).isEqualTo(DEFAULT_ROOMWINELENGTH);
        assertThat(testResProperties.getRoomwinewidth()).isEqualTo(DEFAULT_ROOMWINEWIDTH);
        assertThat(testResProperties.getJuniorhighschoolname()).isEqualTo(DEFAULT_JUNIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getPrimaryschoolname()).isEqualTo(DEFAULT_PRIMARYSCHOOLNAME);
        assertThat(testResProperties.getSeniorhighschoolname()).isEqualTo(DEFAULT_SENIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getAssociationfee()).isEqualTo(DEFAULT_ASSOCIATIONFEE);
        assertThat(testResProperties.getAssociationfeefrequency()).isEqualTo(DEFAULT_ASSOCIATIONFEEFREQUENCY);
        assertThat(testResProperties.getConstructionmaterials()).isEqualTo(DEFAULT_CONSTRUCTIONMATERIALS);
        assertThat(testResProperties.getHeating()).isEqualTo(DEFAULT_HEATING);
        assertThat(testResProperties.getAccessoryunittype()).isEqualTo(DEFAULT_ACCESSORYUNITTYPE);
        assertThat(testResProperties.getAccessoryunityn()).isEqualTo(DEFAULT_ACCESSORYUNITYN);
        assertThat(testResProperties.getFlooring()).isEqualTo(DEFAULT_FLOORING);
        assertThat(testResProperties.getFireplacestotal()).isEqualTo(DEFAULT_FIREPLACESTOTAL);
        assertThat(testResProperties.getFireplacefeatures()).isEqualTo(DEFAULT_FIREPLACEFEATURES);
        assertThat(testResProperties.getSecuritysystemyn()).isEqualTo(DEFAULT_SECURITYSYSTEMYN);
        assertThat(testResProperties.getGreenbuildingcertification()).isEqualTo(DEFAULT_GREENBUILDINGCERTIFICATION);
        assertThat(testResProperties.getGreenenergyefficient()).isEqualTo(DEFAULT_GREENENERGYEFFICIENT);
        assertThat(testResProperties.getEnergysavingfeatures()).isEqualTo(DEFAULT_ENERGYSAVINGFEATURES);
        assertThat(testResProperties.getLotnumber()).isEqualTo(DEFAULT_LOTNUMBER);
        assertThat(testResProperties.getLotsizearea()).isEqualTo(DEFAULT_LOTSIZEAREA);
        assertThat(testResProperties.getLotsizedimensions()).isEqualTo(DEFAULT_LOTSIZEDIMENSIONS);
        assertThat(testResProperties.getEasements()).isEqualTo(DEFAULT_EASEMENTS);
        assertThat(testResProperties.getRestrictions()).isEqualTo(DEFAULT_RESTRICTIONS);
        assertThat(testResProperties.getWasherdryerconnections()).isEqualTo(DEFAULT_WASHERDRYERCONNECTIONS);
        assertThat(testResProperties.getMunicipalutilitydistrictyn()).isEqualTo(DEFAULT_MUNICIPALUTILITYDISTRICTYN);
        assertThat(testResProperties.getAssociationfeeincludes()).isEqualTo(DEFAULT_ASSOCIATIONFEEINCLUDES);
        assertThat(testResProperties.getAssociationtype()).isEqualTo(DEFAULT_ASSOCIATIONTYPE);
        assertThat(testResProperties.getBarninformation()).isEqualTo(DEFAULT_BARNINFORMATION);
        assertThat(testResProperties.getConstructionmaterialswalls()).isEqualTo(DEFAULT_CONSTRUCTIONMATERIALSWALLS);
        assertThat(testResProperties.getCountyorparish()).isEqualTo(DEFAULT_COUNTYORPARISH);
        assertThat(testResProperties.getExteriorbuildings()).isEqualTo(DEFAULT_EXTERIORBUILDINGS);
        assertThat(testResProperties.getFarmranchfeatures()).isEqualTo(DEFAULT_FARMRANCHFEATURES);
        assertThat(testResProperties.getFencedyardyn()).isEqualTo(DEFAULT_FENCEDYARDYN);
        assertThat(testResProperties.getFinancingproposed()).isEqualTo(DEFAULT_FINANCINGPROPOSED);
        assertThat(testResProperties.getHandicapyn()).isEqualTo(DEFAULT_HANDICAPYN);
        assertThat(testResProperties.getNumberoftanksandponds()).isEqualTo(DEFAULT_NUMBEROFTANKSANDPONDS);
        assertThat(testResProperties.getParcelnumber()).isEqualTo(DEFAULT_PARCELNUMBER);
        assertThat(testResProperties.getVirtualtoururlunbranded()).isEqualTo(DEFAULT_VIRTUALTOURURLUNBRANDED);
        assertThat(testResProperties.getLivingRoomFeature()).isEqualTo(DEFAULT_LIVING_ROOM_FEATURE);
        assertThat(testResProperties.getMasterBedRoomFeature()).isEqualTo(DEFAULT_MASTER_BED_ROOM_FEATURE);
        assertThat(testResProperties.getBedRoomFeature()).isEqualTo(DEFAULT_BED_ROOM_FEATURE);
        assertThat(testResProperties.getDiningRoomFeature()).isEqualTo(DEFAULT_DINING_ROOM_FEATURE);
        assertThat(testResProperties.getKitchenRoomFeature()).isEqualTo(DEFAULT_KITCHEN_ROOM_FEATURE);
        assertThat(testResProperties.getBreakfastRoomFeature()).isEqualTo(DEFAULT_BREAKFAST_ROOM_FEATURE);
        assertThat(testResProperties.getStudyRoomFeature()).isEqualTo(DEFAULT_STUDY_ROOM_FEATURE);
        assertThat(testResProperties.getUtilityRoomFeature()).isEqualTo(DEFAULT_UTILITY_ROOM_FEATURE);
        assertThat(testResProperties.getFullBathRoomFeature()).isEqualTo(DEFAULT_FULL_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getHalfBathRoomFeature()).isEqualTo(DEFAULT_HALF_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getExerciseRoomFeature()).isEqualTo(DEFAULT_EXERCISE_ROOM_FEATURE);
        assertThat(testResProperties.getExtraStorageRoomFeature()).isEqualTo(DEFAULT_EXTRA_STORAGE_ROOM_FEATURE);
        assertThat(testResProperties.getGameRoomFeature()).isEqualTo(DEFAULT_GAME_ROOM_FEATURE);
        assertThat(testResProperties.getGuestRoomFeature()).isEqualTo(DEFAULT_GUEST_ROOM_FEATURE);
        assertThat(testResProperties.getLibraryRoomFeature()).isEqualTo(DEFAULT_LIBRARY_ROOM_FEATURE);
        assertThat(testResProperties.getMediaRoomFeature()).isEqualTo(DEFAULT_MEDIA_ROOM_FEATURE);
        assertThat(testResProperties.getMudRoomFeature()).isEqualTo(DEFAULT_MUD_ROOM_FEATURE);
        assertThat(testResProperties.getOfficeRoomFeature()).isEqualTo(DEFAULT_OFFICE_ROOM_FEATURE);
        assertThat(testResProperties.getSaunaRoomFeature()).isEqualTo(DEFAULT_SAUNA_ROOM_FEATURE);
        assertThat(testResProperties.getSecondMasterRoomFeature()).isEqualTo(DEFAULT_SECOND_MASTER_ROOM_FEATURE);
        assertThat(testResProperties.getSunroomRoomFeature()).isEqualTo(DEFAULT_SUNROOM_ROOM_FEATURE);
        assertThat(testResProperties.getSpaRoomFeature()).isEqualTo(DEFAULT_SPA_ROOM_FEATURE);
        assertThat(testResProperties.getWineRoomFeature()).isEqualTo(DEFAULT_WINE_ROOM_FEATURE);
        assertThat(testResProperties.getOtherRoomFeature()).isEqualTo(DEFAULT_OTHER_ROOM_FEATURE);
        assertThat(testResProperties.getIsLuxury()).isEqualTo(DEFAULT_IS_LUXURY);
        assertThat(testResProperties.getIsMoveInReady()).isEqualTo(DEFAULT_IS_MOVE_IN_READY);
        assertThat(testResProperties.getPhotoUrl()).isEqualTo(DEFAULT_PHOTO_URL);
        assertThat(testResProperties.getPhoto1Url()).isEqualTo(DEFAULT_PHOTO_1_URL);
        assertThat(testResProperties.getPhoto2Url()).isEqualTo(DEFAULT_PHOTO_2_URL);
        assertThat(testResProperties.getPhoto3Url()).isEqualTo(DEFAULT_PHOTO_3_URL);
        assertThat(testResProperties.getPhoto4Url()).isEqualTo(DEFAULT_PHOTO_4_URL);
        assertThat(testResProperties.getPhoto5Url()).isEqualTo(DEFAULT_PHOTO_5_URL);
        assertThat(testResProperties.getPhoto6Url()).isEqualTo(DEFAULT_PHOTO_6_URL);
        assertThat(testResProperties.getPhoto7Url()).isEqualTo(DEFAULT_PHOTO_7_URL);
        assertThat(testResProperties.getPhoto8Url()).isEqualTo(DEFAULT_PHOTO_8_URL);
        assertThat(testResProperties.getPhoto9Url()).isEqualTo(DEFAULT_PHOTO_9_URL);
        assertThat(testResProperties.getPhoto10Url()).isEqualTo(DEFAULT_PHOTO_10_URL);
        assertThat(testResProperties.getPhoto11Url()).isEqualTo(DEFAULT_PHOTO_11_URL);
        assertThat(testResProperties.getPhoto12Url()).isEqualTo(DEFAULT_PHOTO_12_URL);
        assertThat(testResProperties.getPhoto13Url()).isEqualTo(DEFAULT_PHOTO_13_URL);
        assertThat(testResProperties.getPhoto14Url()).isEqualTo(DEFAULT_PHOTO_14_URL);
        assertThat(testResProperties.getPhoto15Url()).isEqualTo(DEFAULT_PHOTO_15_URL);
        assertThat(testResProperties.getPhoto16Url()).isEqualTo(DEFAULT_PHOTO_16_URL);
        assertThat(testResProperties.getPhoto17Url()).isEqualTo(DEFAULT_PHOTO_17_URL);
        assertThat(testResProperties.getPhoto18Url()).isEqualTo(DEFAULT_PHOTO_18_URL);
        assertThat(testResProperties.getPhoto19Url()).isEqualTo(DEFAULT_PHOTO_19_URL);
        assertThat(testResProperties.getPhoto20Url()).isEqualTo(DEFAULT_PHOTO_20_URL);
        assertThat(testResProperties.getPhoto21Url()).isEqualTo(DEFAULT_PHOTO_21_URL);
        assertThat(testResProperties.getPhoto22Url()).isEqualTo(DEFAULT_PHOTO_22_URL);
        assertThat(testResProperties.getPhoto23Url()).isEqualTo(DEFAULT_PHOTO_23_URL);
        assertThat(testResProperties.getPhoto24Url()).isEqualTo(DEFAULT_PHOTO_24_URL);
        assertThat(testResProperties.getPhoto25Url()).isEqualTo(DEFAULT_PHOTO_25_URL);
        assertThat(testResProperties.getPhoto26Url()).isEqualTo(DEFAULT_PHOTO_26_URL);
        assertThat(testResProperties.getPhoto27Url()).isEqualTo(DEFAULT_PHOTO_27_URL);
        assertThat(testResProperties.getPhoto28Url()).isEqualTo(DEFAULT_PHOTO_28_URL);
        assertThat(testResProperties.getPhoto29Url()).isEqualTo(DEFAULT_PHOTO_29_URL);
        assertThat(testResProperties.getPhoto30Url()).isEqualTo(DEFAULT_PHOTO_30_URL);
        assertThat(testResProperties.getPhoto31Url()).isEqualTo(DEFAULT_PHOTO_31_URL);
        assertThat(testResProperties.getPhoto32Url()).isEqualTo(DEFAULT_PHOTO_32_URL);
        assertThat(testResProperties.getPhoto33Url()).isEqualTo(DEFAULT_PHOTO_33_URL);
        assertThat(testResProperties.getPhoto34Url()).isEqualTo(DEFAULT_PHOTO_34_URL);
        assertThat(testResProperties.getPhoto35Url()).isEqualTo(DEFAULT_PHOTO_35_URL);
        assertThat(testResProperties.getPhoto36Url()).isEqualTo(DEFAULT_PHOTO_36_URL);
        assertThat(testResProperties.getPhoto37Url()).isEqualTo(DEFAULT_PHOTO_37_URL);
        assertThat(testResProperties.getPhoto38Url()).isEqualTo(DEFAULT_PHOTO_38_URL);
        assertThat(testResProperties.getPhoto39Url()).isEqualTo(DEFAULT_PHOTO_39_URL);
        assertThat(testResProperties.getPhoto40Url()).isEqualTo(DEFAULT_PHOTO_40_URL);
        assertThat(testResProperties.getCreated()).isEqualTo(DEFAULT_CREATED);
        assertThat(testResProperties.getUpdated()).isEqualTo(DEFAULT_UPDATED);
        assertThat(testResProperties.getModifiedDate()).isEqualTo(DEFAULT_MODIFIED_DATE);
        assertThat(testResProperties.getImgDeleted()).isEqualTo(DEFAULT_IMG_DELETED);
        assertThat(testResProperties.getRetsServer()).isEqualTo(DEFAULT_RETS_SERVER);
        assertThat(testResProperties.getPermalink()).isEqualTo(DEFAULT_PERMALINK);
        assertThat(testResProperties.getPropertyTag()).isEqualTo(DEFAULT_PROPERTY_TAG);
        assertThat(testResProperties.getBuildentoryViews()).isEqualTo(DEFAULT_BUILDENTORY_VIEWS);
        assertThat(testResProperties.getLocation()).isEqualTo(DEFAULT_LOCATION);
    }

    @Test
    @Transactional
    void createResPropertiesWithExistingId() throws Exception {
        // Create the ResProperties with an existing ID
        resProperties.setId(1L);

        int databaseSizeBeforeCreate = resPropertiesRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkCommunityIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setCommunityId(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCommunityNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setCommunityName(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBuilderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBuilderId(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSpecialOffersIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSpecialOffers(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBrochureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBrochure(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFloorPlanIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFloorPlanId(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMlsProptypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMlsProptype(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkYearbuiltdetailsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setYearbuiltdetails(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUnitnumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setUnitnumber(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPoolFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPoolFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMlsnumIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMlsnum(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMatrixidIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMatrixid(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSecurityfeaturesIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSecurityfeatures(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUtilitiesotherIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setUtilitiesother(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkModifiedIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setModified(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOpenhouseendtimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setOpenhouseendtime(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomfullbathlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomfullbathlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomfullbathwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomfullbathwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomhalfbathlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomhalfbathlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomhalfbathwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomhalfbathwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomexerciselengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomexerciselength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomexercisewidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomexercisewidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomstoragelengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomstoragelength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomstoragewidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomstoragewidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomgamelengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomgamelength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomgamewidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomgamewidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomguestlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomguestlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomguestwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomguestwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomlibrarylengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomlibrarylength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomlibrarywidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomlibrarywidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoommedialengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoommedialength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoommediawidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoommediawidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoommudlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoommudlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoommudwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoommudwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomofficelengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomofficelength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomofficewidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomofficewidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsaunalengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsaunalength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsaunawidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsaunawidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsecondmasterlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsecondmasterlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsecondmasterwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsecondmasterwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsunlengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsunlength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomsunwidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomsunwidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomspalengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomspalength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomspawidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomspawidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomwinelengthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomwinelength(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRoomwinewidthIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRoomwinewidth(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkJuniorhighschoolnameIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setJuniorhighschoolname(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPrimaryschoolnameIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPrimaryschoolname(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSeniorhighschoolnameIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSeniorhighschoolname(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAssociationfeeIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAssociationfee(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAssociationfeefrequencyIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAssociationfeefrequency(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkConstructionmaterialsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setConstructionmaterials(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHeatingIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setHeating(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAccessoryunittypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAccessoryunittype(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAccessoryunitynIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAccessoryunityn(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFlooringIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFlooring(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFireplacestotalIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFireplacestotal(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFireplacefeaturesIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFireplacefeatures(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSecuritysystemynIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSecuritysystemyn(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGreenbuildingcertificationIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setGreenbuildingcertification(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGreenenergyefficientIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setGreenenergyefficient(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkEnergysavingfeaturesIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setEnergysavingfeatures(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLotnumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLotnumber(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLotsizeareaIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLotsizearea(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLotsizedimensionsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLotsizedimensions(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkEasementsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setEasements(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkRestrictionsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setRestrictions(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWasherdryerconnectionsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setWasherdryerconnections(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMunicipalutilitydistrictynIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMunicipalutilitydistrictyn(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAssociationfeeincludesIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAssociationfeeincludes(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkAssociationtypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setAssociationtype(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBarninformationIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBarninformation(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkConstructionmaterialswallsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setConstructionmaterialswalls(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkCountyorparishIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setCountyorparish(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkExteriorbuildingsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setExteriorbuildings(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFarmranchfeaturesIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFarmranchfeatures(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFencedyardynIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFencedyardyn(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFinancingproposedIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFinancingproposed(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHandicapynIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setHandicapyn(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNumberoftanksandpondsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setNumberoftanksandponds(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkParcelnumberIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setParcelnumber(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkVirtualtoururlunbrandedIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setVirtualtoururlunbranded(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLivingRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLivingRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMasterBedRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMasterBedRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBedRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBedRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkDiningRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setDiningRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkKitchenRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setKitchenRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBreakfastRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBreakfastRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkStudyRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setStudyRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUtilityRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setUtilityRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkFullBathRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setFullBathRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkHalfBathRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setHalfBathRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkExerciseRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setExerciseRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkExtraStorageRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setExtraStorageRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGameRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setGameRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkGuestRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setGuestRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLibraryRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLibraryRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMediaRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMediaRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkMudRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setMudRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOfficeRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setOfficeRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSaunaRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSaunaRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSecondMasterRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSecondMasterRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSunroomRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSunroomRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkSpaRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setSpaRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkWineRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setWineRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkOtherRoomFeatureIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setOtherRoomFeature(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsLuxuryIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setIsLuxury(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkIsMoveInReadyIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setIsMoveInReady(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto1UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto1Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto2UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto2Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto3UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto3Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto4UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto4Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto5UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto5Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto6UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto6Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto7UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto7Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto8UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto8Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto9UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto9Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto10UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto10Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto11UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto11Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto12UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto12Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto13UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto13Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto14UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto14Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto15UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto15Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto16UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto16Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto17UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto17Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto18UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto18Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto19UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto19Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto20UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto20Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto21UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto21Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto22UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto22Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto23UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto23Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto24UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto24Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto25UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto25Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto26UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto26Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto27UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto27Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto28UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto28Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto29UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto29Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto30UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto30Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto31UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto31Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto32UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto32Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto33UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto33Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto34UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto34Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto35UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto35Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto36UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto36Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto37UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto37Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto38UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto38Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto39UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto39Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPhoto40UrlIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPhoto40Url(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkUpdatedIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setUpdated(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkModifiedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setModifiedDate(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkImgDeletedIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setImgDeleted(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPermalinkIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPermalink(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkPropertyTagIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setPropertyTag(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBuildentoryViewsIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setBuildentoryViews(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkLocationIsRequired() throws Exception {
        int databaseSizeBeforeTest = resPropertiesRepository.findAll().size();
        // set the field null
        resProperties.setLocation(null);

        // Create the ResProperties, which fails.

        restResPropertiesMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isBadRequest());

        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllResProperties() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        // Get all the resPropertiesList
        restResPropertiesMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(resProperties.getId().intValue())))
            .andExpect(jsonPath("$.[*].communityId").value(hasItem(DEFAULT_COMMUNITY_ID)))
            .andExpect(jsonPath("$.[*].communityName").value(hasItem(DEFAULT_COMMUNITY_NAME)))
            .andExpect(jsonPath("$.[*].builderId").value(hasItem(DEFAULT_BUILDER_ID)))
            .andExpect(jsonPath("$.[*].specialOffers").value(hasItem(DEFAULT_SPECIAL_OFFERS)))
            .andExpect(jsonPath("$.[*].brochure").value(hasItem(DEFAULT_BROCHURE)))
            .andExpect(jsonPath("$.[*].floorPlanId").value(hasItem(DEFAULT_FLOOR_PLAN_ID)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE)))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE)))
            .andExpect(jsonPath("$.[*].county").value(hasItem(DEFAULT_COUNTY)))
            .andExpect(jsonPath("$.[*].heatsystem").value(hasItem(DEFAULT_HEATSYSTEM)))
            .andExpect(jsonPath("$.[*].liststatus").value(hasItem(DEFAULT_LISTSTATUS)))
            .andExpect(jsonPath("$.[*].liststatusflag").value(hasItem(DEFAULT_LISTSTATUSFLAG)))
            .andExpect(jsonPath("$.[*].carportcap").value(hasItem(DEFAULT_CARPORTCAP)))
            .andExpect(jsonPath("$.[*].possession").value(hasItem(DEFAULT_POSSESSION)))
            .andExpect(jsonPath("$.[*].schoolname1").value(hasItem(DEFAULT_SCHOOLNAME_1)))
            .andExpect(jsonPath("$.[*].subdivide").value(hasItem(DEFAULT_SUBDIVIDE)))
            .andExpect(jsonPath("$.[*].vowavmyn").value(hasItem(DEFAULT_VOWAVMYN)))
            .andExpect(jsonPath("$.[*].presentuse").value(hasItem(DEFAULT_PRESENTUSE)))
            .andExpect(jsonPath("$.[*].proposeduse").value(hasItem(DEFAULT_PROPOSEDUSE)))
            .andExpect(jsonPath("$.[*].ranchname").value(hasItem(DEFAULT_RANCHNAME)))
            .andExpect(jsonPath("$.[*].roombed2width").value(hasItem(DEFAULT_ROOMBED_2_WIDTH)))
            .andExpect(jsonPath("$.[*].roomdininglevel").value(hasItem(DEFAULT_ROOMDININGLEVEL)))
            .andExpect(jsonPath("$.[*].roomliving2width").value(hasItem(DEFAULT_ROOMLIVING_2_WIDTH)))
            .andExpect(jsonPath("$.[*].roomstudylevel").value(hasItem(DEFAULT_ROOMSTUDYLEVEL)))
            .andExpect(jsonPath("$.[*].area").value(hasItem(DEFAULT_AREA)))
            .andExpect(jsonPath("$.[*].areatitle").value(hasItem(DEFAULT_AREATITLE)))
            .andExpect(jsonPath("$.[*].assocfee").value(hasItem(DEFAULT_ASSOCFEE)))
            .andExpect(jsonPath("$.[*].financeproposed").value(hasItem(DEFAULT_FINANCEPROPOSED)))
            .andExpect(jsonPath("$.[*].listpriceorig").value(hasItem(DEFAULT_LISTPRICEORIG)))
            .andExpect(jsonPath("$.[*].mapcoord").value(hasItem(DEFAULT_MAPCOORD)))
            .andExpect(jsonPath("$.[*].schoolname2").value(hasItem(DEFAULT_SCHOOLNAME_2)))
            .andExpect(jsonPath("$.[*].roomgaragewidth").value(hasItem(DEFAULT_ROOMGARAGEWIDTH)))
            .andExpect(jsonPath("$.[*].roomkitchendesc").value(hasItem(DEFAULT_ROOMKITCHENDESC)))
            .andExpect(jsonPath("$.[*].roomliving1width").value(hasItem(DEFAULT_ROOMLIVING_1_WIDTH)))
            .andExpect(jsonPath("$.[*].roomother2width").value(hasItem(DEFAULT_ROOMOTHER_2_WIDTH)))
            .andExpect(jsonPath("$.[*].sqfttotal").value(hasItem(DEFAULT_SQFTTOTAL)))
            .andExpect(jsonPath("$.[*].officelistOfficenam1").value(hasItem(DEFAULT_OFFICELIST_OFFICENAM_1)))
            .andExpect(jsonPath("$.[*].schoolname3").value(hasItem(DEFAULT_SCHOOLNAME_3)))
            .andExpect(jsonPath("$.[*].zipcode").value(hasItem(DEFAULT_ZIPCODE)))
            .andExpect(jsonPath("$.[*].barn1length").value(hasItem(DEFAULT_BARN_1_LENGTH)))
            .andExpect(jsonPath("$.[*].barn3width").value(hasItem(DEFAULT_BARN_3_WIDTH)))
            .andExpect(jsonPath("$.[*].roombed2length").value(hasItem(DEFAULT_ROOMBED_2_LENGTH)))
            .andExpect(jsonPath("$.[*].roombed3length").value(hasItem(DEFAULT_ROOMBED_3_LENGTH)))
            .andExpect(jsonPath("$.[*].roomother1width").value(hasItem(DEFAULT_ROOMOTHER_1_WIDTH)))
            .andExpect(jsonPath("$.[*].agentlistFullname").value(hasItem(DEFAULT_AGENTLIST_FULLNAME)))
            .andExpect(jsonPath("$.[*].proptype").value(hasItem(DEFAULT_PROPTYPE)))
            .andExpect(jsonPath("$.[*].mlsProptype").value(hasItem(DEFAULT_MLS_PROPTYPE)))
            .andExpect(jsonPath("$.[*].schoolname4").value(hasItem(DEFAULT_SCHOOLNAME_4)))
            .andExpect(jsonPath("$.[*].acrescultivated").value(hasItem(sameNumber(DEFAULT_ACRESCULTIVATED))))
            .andExpect(jsonPath("$.[*].barn2length").value(hasItem(DEFAULT_BARN_2_LENGTH)))
            .andExpect(jsonPath("$.[*].barn2width").value(hasItem(DEFAULT_BARN_2_WIDTH)))
            .andExpect(jsonPath("$.[*].complexname").value(hasItem(DEFAULT_COMPLEXNAME)))
            .andExpect(jsonPath("$.[*].roombed4length").value(hasItem(DEFAULT_ROOMBED_4_LENGTH)))
            .andExpect(jsonPath("$.[*].roombedbathdesc").value(hasItem(DEFAULT_ROOMBEDBATHDESC)))
            .andExpect(jsonPath("$.[*].roombreakfastwidth").value(hasItem(DEFAULT_ROOMBREAKFASTWIDTH)))
            .andExpect(jsonPath("$.[*].roomother").value(hasItem(DEFAULT_ROOMOTHER)))
            .andExpect(jsonPath("$.[*].roomutilitylength").value(hasItem(DEFAULT_ROOMUTILITYLENGTH)))
            .andExpect(jsonPath("$.[*].acres").value(hasItem(sameNumber(DEFAULT_ACRES))))
            .andExpect(jsonPath("$.[*].block").value(hasItem(DEFAULT_BLOCK)))
            .andExpect(jsonPath("$.[*].directions").value(hasItem(DEFAULT_DIRECTIONS)))
            .andExpect(jsonPath("$.[*].subdivision").value(hasItem(DEFAULT_SUBDIVISION)))
            .andExpect(jsonPath("$.[*].yearbuilt").value(hasItem(DEFAULT_YEARBUILT)))
            .andExpect(jsonPath("$.[*].yearbuiltdetails").value(hasItem(DEFAULT_YEARBUILTDETAILS)))
            .andExpect(jsonPath("$.[*].agexemption").value(hasItem(DEFAULT_AGEXEMPTION)))
            .andExpect(jsonPath("$.[*].barn1width").value(hasItem(DEFAULT_BARN_1_WIDTH)))
            .andExpect(jsonPath("$.[*].barn3length").value(hasItem(DEFAULT_BARN_3_LENGTH)))
            .andExpect(jsonPath("$.[*].roomdiningwidth").value(hasItem(DEFAULT_ROOMDININGWIDTH)))
            .andExpect(jsonPath("$.[*].roomstudywidth").value(hasItem(DEFAULT_ROOMSTUDYWIDTH)))
            .andExpect(jsonPath("$.[*].soiltype").value(hasItem(DEFAULT_SOILTYPE)))
            .andExpect(jsonPath("$.[*].appraisername").value(hasItem(DEFAULT_APPRAISERNAME)))
            .andExpect(jsonPath("$.[*].listpricelow").value(hasItem(DEFAULT_LISTPRICELOW)))
            .andExpect(jsonPath("$.[*].mappage").value(hasItem(DEFAULT_MAPPAGE)))
            .andExpect(jsonPath("$.[*].unitnumber").value(hasItem(DEFAULT_UNITNUMBER)))
            .andExpect(jsonPath("$.[*].streetdir").value(hasItem(DEFAULT_STREETDIR)))
            .andExpect(jsonPath("$.[*].streettype").value(hasItem(DEFAULT_STREETTYPE)))
            .andExpect(jsonPath("$.[*].subarea").value(hasItem(DEFAULT_SUBAREA)))
            .andExpect(jsonPath("$.[*].subareatitle").value(hasItem(DEFAULT_SUBAREATITLE)))
            .andExpect(jsonPath("$.[*].bathshalf").value(hasItem(DEFAULT_BATHSHALF)))
            .andExpect(jsonPath("$.[*].roomgaragelength").value(hasItem(DEFAULT_ROOMGARAGELENGTH)))
            .andExpect(jsonPath("$.[*].propsubtype").value(hasItem(DEFAULT_PROPSUBTYPE)))
            .andExpect(jsonPath("$.[*].beds").value(hasItem(DEFAULT_BEDS)))
            .andExpect(jsonPath("$.[*].roommasterbedwidth").value(hasItem(DEFAULT_ROOMMASTERBEDWIDTH)))
            .andExpect(jsonPath("$.[*].roomstudylength").value(hasItem(DEFAULT_ROOMSTUDYLENGTH)))
            .andExpect(jsonPath("$.[*].agentlist").value(hasItem(DEFAULT_AGENTLIST)))
            .andExpect(jsonPath("$.[*].streetname").value(hasItem(DEFAULT_STREETNAME)))
            .andExpect(jsonPath("$.[*].roombreakfastlength").value(hasItem(DEFAULT_ROOMBREAKFASTLENGTH)))
            .andExpect(jsonPath("$.[*].roomkitchenwidth").value(hasItem(DEFAULT_ROOMKITCHENWIDTH)))
            .andExpect(jsonPath("$.[*].fence").value(hasItem(DEFAULT_FENCE)))
            .andExpect(jsonPath("$.[*].bathstotal").value(hasItem(sameNumber(DEFAULT_BATHSTOTAL))))
            .andExpect(jsonPath("$.[*].garagecap").value(hasItem(DEFAULT_GARAGECAP)))
            .andExpect(jsonPath("$.[*].sqftprice").value(hasItem(sameNumber(DEFAULT_SQFTPRICE))))
            .andExpect(jsonPath("$.[*].style").value(hasItem(DEFAULT_STYLE)))
            .andExpect(jsonPath("$.[*].exterior").value(hasItem(DEFAULT_EXTERIOR)))
            .andExpect(jsonPath("$.[*].foundation").value(hasItem(DEFAULT_FOUNDATION)))
            .andExpect(jsonPath("$.[*].interior").value(hasItem(DEFAULT_INTERIOR)))
            .andExpect(jsonPath("$.[*].poolyn").value(hasItem(DEFAULT_POOLYN)))
            .andExpect(jsonPath("$.[*].poolFeature").value(hasItem(DEFAULT_POOL_FEATURE)))
            .andExpect(jsonPath("$.[*].listprice").value(hasItem(DEFAULT_LISTPRICE)))
            .andExpect(jsonPath("$.[*].listpricerange").value(hasItem(DEFAULT_LISTPRICERANGE)))
            .andExpect(jsonPath("$.[*].mlsnum").value(hasItem(DEFAULT_MLSNUM)))
            .andExpect(jsonPath("$.[*].matrixid").value(hasItem(DEFAULT_MATRIXID)))
            .andExpect(jsonPath("$.[*].remarks").value(hasItem(DEFAULT_REMARKS)))
            .andExpect(jsonPath("$.[*].state").value(hasItem(DEFAULT_STATE)))
            .andExpect(jsonPath("$.[*].roof").value(hasItem(DEFAULT_ROOF)))
            .andExpect(jsonPath("$.[*].securityfeatures").value(hasItem(DEFAULT_SECURITYFEATURES)))
            .andExpect(jsonPath("$.[*].utilitiesother").value(hasItem(DEFAULT_UTILITIESOTHER)))
            .andExpect(jsonPath("$.[*].commonfeatures").value(hasItem(DEFAULT_COMMONFEATURES)))
            .andExpect(jsonPath("$.[*].construction").value(hasItem(DEFAULT_CONSTRUCTION)))
            .andExpect(jsonPath("$.[*].modified").value(hasItem(DEFAULT_MODIFIED.toString())))
            .andExpect(jsonPath("$.[*].stories").value(hasItem(DEFAULT_STORIES)))
            .andExpect(jsonPath("$.[*].roomdininglength").value(hasItem(DEFAULT_ROOMDININGLENGTH)))
            .andExpect(jsonPath("$.[*].roomliving1length").value(hasItem(DEFAULT_ROOMLIVING_1_LENGTH)))
            .andExpect(jsonPath("$.[*].openhousetime").value(hasItem(DEFAULT_OPENHOUSETIME)))
            .andExpect(jsonPath("$.[*].openhouseendtime").value(hasItem(DEFAULT_OPENHOUSEENDTIME)))
            .andExpect(jsonPath("$.[*].roomliving2length").value(hasItem(DEFAULT_ROOMLIVING_2_LENGTH)))
            .andExpect(jsonPath("$.[*].lotdesc").value(hasItem(DEFAULT_LOTDESC)))
            .andExpect(jsonPath("$.[*].openhousedate").value(hasItem(DEFAULT_OPENHOUSEDATE.toString())))
            .andExpect(jsonPath("$.[*].roommasterbedlength").value(hasItem(DEFAULT_ROOMMASTERBEDLENGTH)))
            .andExpect(jsonPath("$.[*].roomother1length").value(hasItem(DEFAULT_ROOMOTHER_1_LENGTH)))
            .andExpect(jsonPath("$.[*].officesellOfficenam2").value(hasItem(DEFAULT_OFFICESELL_OFFICENAM_2)))
            .andExpect(jsonPath("$.[*].lotsize").value(hasItem(DEFAULT_LOTSIZE)))
            .andExpect(jsonPath("$.[*].streetdirsuffix").value(hasItem(DEFAULT_STREETDIRSUFFIX)))
            .andExpect(jsonPath("$.[*].photocount").value(hasItem(DEFAULT_PHOTOCOUNT)))
            .andExpect(jsonPath("$.[*].schooldistrict").value(hasItem(DEFAULT_SCHOOLDISTRICT)))
            .andExpect(jsonPath("$.[*].streetnum").value(hasItem(DEFAULT_STREETNUM)))
            .andExpect(jsonPath("$.[*].utilities").value(hasItem(DEFAULT_UTILITIES)))
            .andExpect(jsonPath("$.[*].equipment").value(hasItem(DEFAULT_EQUIPMENT)))
            .andExpect(jsonPath("$.[*].roombed4width").value(hasItem(DEFAULT_ROOMBED_4_WIDTH)))
            .andExpect(jsonPath("$.[*].roomkitchenlength").value(hasItem(DEFAULT_ROOMKITCHENLENGTH)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].garagedesc").value(hasItem(DEFAULT_GARAGEDESC)))
            .andExpect(jsonPath("$.[*].bathsfull").value(hasItem(DEFAULT_BATHSFULL)))
            .andExpect(jsonPath("$.[*].roombed3width").value(hasItem(DEFAULT_ROOMBED_3_WIDTH)))
            .andExpect(jsonPath("$.[*].roomutildesc").value(hasItem(DEFAULT_ROOMUTILDESC)))
            .andExpect(jsonPath("$.[*].roomutilitywidth").value(hasItem(DEFAULT_ROOMUTILITYWIDTH)))
            .andExpect(jsonPath("$.[*].roomfullbathlength").value(hasItem(DEFAULT_ROOMFULLBATHLENGTH)))
            .andExpect(jsonPath("$.[*].roomfullbathwidth").value(hasItem(DEFAULT_ROOMFULLBATHWIDTH)))
            .andExpect(jsonPath("$.[*].roomhalfbathlength").value(hasItem(DEFAULT_ROOMHALFBATHLENGTH)))
            .andExpect(jsonPath("$.[*].roomhalfbathwidth").value(hasItem(DEFAULT_ROOMHALFBATHWIDTH)))
            .andExpect(jsonPath("$.[*].roomexerciselength").value(hasItem(DEFAULT_ROOMEXERCISELENGTH)))
            .andExpect(jsonPath("$.[*].roomexercisewidth").value(hasItem(DEFAULT_ROOMEXERCISEWIDTH)))
            .andExpect(jsonPath("$.[*].roomstoragelength").value(hasItem(DEFAULT_ROOMSTORAGELENGTH)))
            .andExpect(jsonPath("$.[*].roomstoragewidth").value(hasItem(DEFAULT_ROOMSTORAGEWIDTH)))
            .andExpect(jsonPath("$.[*].roomgamelength").value(hasItem(DEFAULT_ROOMGAMELENGTH)))
            .andExpect(jsonPath("$.[*].roomgamewidth").value(hasItem(DEFAULT_ROOMGAMEWIDTH)))
            .andExpect(jsonPath("$.[*].roomguestlength").value(hasItem(DEFAULT_ROOMGUESTLENGTH)))
            .andExpect(jsonPath("$.[*].roomguestwidth").value(hasItem(DEFAULT_ROOMGUESTWIDTH)))
            .andExpect(jsonPath("$.[*].roomlibrarylength").value(hasItem(DEFAULT_ROOMLIBRARYLENGTH)))
            .andExpect(jsonPath("$.[*].roomlibrarywidth").value(hasItem(DEFAULT_ROOMLIBRARYWIDTH)))
            .andExpect(jsonPath("$.[*].roommedialength").value(hasItem(DEFAULT_ROOMMEDIALENGTH)))
            .andExpect(jsonPath("$.[*].roommediawidth").value(hasItem(DEFAULT_ROOMMEDIAWIDTH)))
            .andExpect(jsonPath("$.[*].roommudlength").value(hasItem(DEFAULT_ROOMMUDLENGTH)))
            .andExpect(jsonPath("$.[*].roommudwidth").value(hasItem(DEFAULT_ROOMMUDWIDTH)))
            .andExpect(jsonPath("$.[*].roomofficelength").value(hasItem(DEFAULT_ROOMOFFICELENGTH)))
            .andExpect(jsonPath("$.[*].roomofficewidth").value(hasItem(DEFAULT_ROOMOFFICEWIDTH)))
            .andExpect(jsonPath("$.[*].roomsaunalength").value(hasItem(DEFAULT_ROOMSAUNALENGTH)))
            .andExpect(jsonPath("$.[*].roomsaunawidth").value(hasItem(DEFAULT_ROOMSAUNAWIDTH)))
            .andExpect(jsonPath("$.[*].roomsecondmasterlength").value(hasItem(DEFAULT_ROOMSECONDMASTERLENGTH)))
            .andExpect(jsonPath("$.[*].roomsecondmasterwidth").value(hasItem(DEFAULT_ROOMSECONDMASTERWIDTH)))
            .andExpect(jsonPath("$.[*].roomsunlength").value(hasItem(DEFAULT_ROOMSUNLENGTH)))
            .andExpect(jsonPath("$.[*].roomsunwidth").value(hasItem(DEFAULT_ROOMSUNWIDTH)))
            .andExpect(jsonPath("$.[*].roomspalength").value(hasItem(DEFAULT_ROOMSPALENGTH)))
            .andExpect(jsonPath("$.[*].roomspawidth").value(hasItem(DEFAULT_ROOMSPAWIDTH)))
            .andExpect(jsonPath("$.[*].roomwinelength").value(hasItem(DEFAULT_ROOMWINELENGTH)))
            .andExpect(jsonPath("$.[*].roomwinewidth").value(hasItem(DEFAULT_ROOMWINEWIDTH)))
            .andExpect(jsonPath("$.[*].juniorhighschoolname").value(hasItem(DEFAULT_JUNIORHIGHSCHOOLNAME)))
            .andExpect(jsonPath("$.[*].primaryschoolname").value(hasItem(DEFAULT_PRIMARYSCHOOLNAME)))
            .andExpect(jsonPath("$.[*].seniorhighschoolname").value(hasItem(DEFAULT_SENIORHIGHSCHOOLNAME)))
            .andExpect(jsonPath("$.[*].associationfee").value(hasItem(DEFAULT_ASSOCIATIONFEE)))
            .andExpect(jsonPath("$.[*].associationfeefrequency").value(hasItem(DEFAULT_ASSOCIATIONFEEFREQUENCY)))
            .andExpect(jsonPath("$.[*].constructionmaterials").value(hasItem(DEFAULT_CONSTRUCTIONMATERIALS)))
            .andExpect(jsonPath("$.[*].heating").value(hasItem(DEFAULT_HEATING)))
            .andExpect(jsonPath("$.[*].accessoryunittype").value(hasItem(DEFAULT_ACCESSORYUNITTYPE)))
            .andExpect(jsonPath("$.[*].accessoryunityn").value(hasItem(DEFAULT_ACCESSORYUNITYN)))
            .andExpect(jsonPath("$.[*].flooring").value(hasItem(DEFAULT_FLOORING)))
            .andExpect(jsonPath("$.[*].fireplacestotal").value(hasItem(DEFAULT_FIREPLACESTOTAL)))
            .andExpect(jsonPath("$.[*].fireplacefeatures").value(hasItem(DEFAULT_FIREPLACEFEATURES)))
            .andExpect(jsonPath("$.[*].securitysystemyn").value(hasItem(DEFAULT_SECURITYSYSTEMYN)))
            .andExpect(jsonPath("$.[*].greenbuildingcertification").value(hasItem(DEFAULT_GREENBUILDINGCERTIFICATION)))
            .andExpect(jsonPath("$.[*].greenenergyefficient").value(hasItem(DEFAULT_GREENENERGYEFFICIENT)))
            .andExpect(jsonPath("$.[*].energysavingfeatures").value(hasItem(DEFAULT_ENERGYSAVINGFEATURES)))
            .andExpect(jsonPath("$.[*].lotnumber").value(hasItem(DEFAULT_LOTNUMBER)))
            .andExpect(jsonPath("$.[*].lotsizearea").value(hasItem(DEFAULT_LOTSIZEAREA)))
            .andExpect(jsonPath("$.[*].lotsizedimensions").value(hasItem(DEFAULT_LOTSIZEDIMENSIONS)))
            .andExpect(jsonPath("$.[*].easements").value(hasItem(DEFAULT_EASEMENTS)))
            .andExpect(jsonPath("$.[*].restrictions").value(hasItem(DEFAULT_RESTRICTIONS)))
            .andExpect(jsonPath("$.[*].washerdryerconnections").value(hasItem(DEFAULT_WASHERDRYERCONNECTIONS)))
            .andExpect(jsonPath("$.[*].municipalutilitydistrictyn").value(hasItem(DEFAULT_MUNICIPALUTILITYDISTRICTYN)))
            .andExpect(jsonPath("$.[*].associationfeeincludes").value(hasItem(DEFAULT_ASSOCIATIONFEEINCLUDES)))
            .andExpect(jsonPath("$.[*].associationtype").value(hasItem(DEFAULT_ASSOCIATIONTYPE)))
            .andExpect(jsonPath("$.[*].barninformation").value(hasItem(DEFAULT_BARNINFORMATION)))
            .andExpect(jsonPath("$.[*].constructionmaterialswalls").value(hasItem(DEFAULT_CONSTRUCTIONMATERIALSWALLS)))
            .andExpect(jsonPath("$.[*].countyorparish").value(hasItem(DEFAULT_COUNTYORPARISH)))
            .andExpect(jsonPath("$.[*].exteriorbuildings").value(hasItem(DEFAULT_EXTERIORBUILDINGS)))
            .andExpect(jsonPath("$.[*].farmranchfeatures").value(hasItem(DEFAULT_FARMRANCHFEATURES)))
            .andExpect(jsonPath("$.[*].fencedyardyn").value(hasItem(DEFAULT_FENCEDYARDYN)))
            .andExpect(jsonPath("$.[*].financingproposed").value(hasItem(DEFAULT_FINANCINGPROPOSED)))
            .andExpect(jsonPath("$.[*].handicapyn").value(hasItem(DEFAULT_HANDICAPYN)))
            .andExpect(jsonPath("$.[*].numberoftanksandponds").value(hasItem(DEFAULT_NUMBEROFTANKSANDPONDS)))
            .andExpect(jsonPath("$.[*].parcelnumber").value(hasItem(DEFAULT_PARCELNUMBER)))
            .andExpect(jsonPath("$.[*].virtualtoururlunbranded").value(hasItem(DEFAULT_VIRTUALTOURURLUNBRANDED)))
            .andExpect(jsonPath("$.[*].livingRoomFeature").value(hasItem(DEFAULT_LIVING_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].masterBedRoomFeature").value(hasItem(DEFAULT_MASTER_BED_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].bedRoomFeature").value(hasItem(DEFAULT_BED_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].diningRoomFeature").value(hasItem(DEFAULT_DINING_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].kitchenRoomFeature").value(hasItem(DEFAULT_KITCHEN_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].breakfastRoomFeature").value(hasItem(DEFAULT_BREAKFAST_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].studyRoomFeature").value(hasItem(DEFAULT_STUDY_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].utilityRoomFeature").value(hasItem(DEFAULT_UTILITY_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].fullBathRoomFeature").value(hasItem(DEFAULT_FULL_BATH_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].halfBathRoomFeature").value(hasItem(DEFAULT_HALF_BATH_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].exerciseRoomFeature").value(hasItem(DEFAULT_EXERCISE_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].extraStorageRoomFeature").value(hasItem(DEFAULT_EXTRA_STORAGE_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].gameRoomFeature").value(hasItem(DEFAULT_GAME_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].guestRoomFeature").value(hasItem(DEFAULT_GUEST_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].libraryRoomFeature").value(hasItem(DEFAULT_LIBRARY_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].mediaRoomFeature").value(hasItem(DEFAULT_MEDIA_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].mudRoomFeature").value(hasItem(DEFAULT_MUD_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].officeRoomFeature").value(hasItem(DEFAULT_OFFICE_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].saunaRoomFeature").value(hasItem(DEFAULT_SAUNA_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].secondMasterRoomFeature").value(hasItem(DEFAULT_SECOND_MASTER_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].sunroomRoomFeature").value(hasItem(DEFAULT_SUNROOM_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].spaRoomFeature").value(hasItem(DEFAULT_SPA_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].wineRoomFeature").value(hasItem(DEFAULT_WINE_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].otherRoomFeature").value(hasItem(DEFAULT_OTHER_ROOM_FEATURE)))
            .andExpect(jsonPath("$.[*].isLuxury").value(hasItem(DEFAULT_IS_LUXURY)))
            .andExpect(jsonPath("$.[*].isMoveInReady").value(hasItem(DEFAULT_IS_MOVE_IN_READY)))
            .andExpect(jsonPath("$.[*].photoUrl").value(hasItem(DEFAULT_PHOTO_URL)))
            .andExpect(jsonPath("$.[*].photo1Url").value(hasItem(DEFAULT_PHOTO_1_URL)))
            .andExpect(jsonPath("$.[*].photo2Url").value(hasItem(DEFAULT_PHOTO_2_URL)))
            .andExpect(jsonPath("$.[*].photo3Url").value(hasItem(DEFAULT_PHOTO_3_URL)))
            .andExpect(jsonPath("$.[*].photo4Url").value(hasItem(DEFAULT_PHOTO_4_URL)))
            .andExpect(jsonPath("$.[*].photo5Url").value(hasItem(DEFAULT_PHOTO_5_URL)))
            .andExpect(jsonPath("$.[*].photo6Url").value(hasItem(DEFAULT_PHOTO_6_URL)))
            .andExpect(jsonPath("$.[*].photo7Url").value(hasItem(DEFAULT_PHOTO_7_URL)))
            .andExpect(jsonPath("$.[*].photo8Url").value(hasItem(DEFAULT_PHOTO_8_URL)))
            .andExpect(jsonPath("$.[*].photo9Url").value(hasItem(DEFAULT_PHOTO_9_URL)))
            .andExpect(jsonPath("$.[*].photo10Url").value(hasItem(DEFAULT_PHOTO_10_URL)))
            .andExpect(jsonPath("$.[*].photo11Url").value(hasItem(DEFAULT_PHOTO_11_URL)))
            .andExpect(jsonPath("$.[*].photo12Url").value(hasItem(DEFAULT_PHOTO_12_URL)))
            .andExpect(jsonPath("$.[*].photo13Url").value(hasItem(DEFAULT_PHOTO_13_URL)))
            .andExpect(jsonPath("$.[*].photo14Url").value(hasItem(DEFAULT_PHOTO_14_URL)))
            .andExpect(jsonPath("$.[*].photo15Url").value(hasItem(DEFAULT_PHOTO_15_URL)))
            .andExpect(jsonPath("$.[*].photo16Url").value(hasItem(DEFAULT_PHOTO_16_URL)))
            .andExpect(jsonPath("$.[*].photo17Url").value(hasItem(DEFAULT_PHOTO_17_URL)))
            .andExpect(jsonPath("$.[*].photo18Url").value(hasItem(DEFAULT_PHOTO_18_URL)))
            .andExpect(jsonPath("$.[*].photo19Url").value(hasItem(DEFAULT_PHOTO_19_URL)))
            .andExpect(jsonPath("$.[*].photo20Url").value(hasItem(DEFAULT_PHOTO_20_URL)))
            .andExpect(jsonPath("$.[*].photo21Url").value(hasItem(DEFAULT_PHOTO_21_URL)))
            .andExpect(jsonPath("$.[*].photo22Url").value(hasItem(DEFAULT_PHOTO_22_URL)))
            .andExpect(jsonPath("$.[*].photo23Url").value(hasItem(DEFAULT_PHOTO_23_URL)))
            .andExpect(jsonPath("$.[*].photo24Url").value(hasItem(DEFAULT_PHOTO_24_URL)))
            .andExpect(jsonPath("$.[*].photo25Url").value(hasItem(DEFAULT_PHOTO_25_URL)))
            .andExpect(jsonPath("$.[*].photo26Url").value(hasItem(DEFAULT_PHOTO_26_URL)))
            .andExpect(jsonPath("$.[*].photo27Url").value(hasItem(DEFAULT_PHOTO_27_URL)))
            .andExpect(jsonPath("$.[*].photo28Url").value(hasItem(DEFAULT_PHOTO_28_URL)))
            .andExpect(jsonPath("$.[*].photo29Url").value(hasItem(DEFAULT_PHOTO_29_URL)))
            .andExpect(jsonPath("$.[*].photo30Url").value(hasItem(DEFAULT_PHOTO_30_URL)))
            .andExpect(jsonPath("$.[*].photo31Url").value(hasItem(DEFAULT_PHOTO_31_URL)))
            .andExpect(jsonPath("$.[*].photo32Url").value(hasItem(DEFAULT_PHOTO_32_URL)))
            .andExpect(jsonPath("$.[*].photo33Url").value(hasItem(DEFAULT_PHOTO_33_URL)))
            .andExpect(jsonPath("$.[*].photo34Url").value(hasItem(DEFAULT_PHOTO_34_URL)))
            .andExpect(jsonPath("$.[*].photo35Url").value(hasItem(DEFAULT_PHOTO_35_URL)))
            .andExpect(jsonPath("$.[*].photo36Url").value(hasItem(DEFAULT_PHOTO_36_URL)))
            .andExpect(jsonPath("$.[*].photo37Url").value(hasItem(DEFAULT_PHOTO_37_URL)))
            .andExpect(jsonPath("$.[*].photo38Url").value(hasItem(DEFAULT_PHOTO_38_URL)))
            .andExpect(jsonPath("$.[*].photo39Url").value(hasItem(DEFAULT_PHOTO_39_URL)))
            .andExpect(jsonPath("$.[*].photo40Url").value(hasItem(DEFAULT_PHOTO_40_URL)))
            .andExpect(jsonPath("$.[*].created").value(hasItem(DEFAULT_CREATED.toString())))
            .andExpect(jsonPath("$.[*].updated").value(hasItem(DEFAULT_UPDATED.toString())))
            .andExpect(jsonPath("$.[*].modifiedDate").value(hasItem(DEFAULT_MODIFIED_DATE.toString())))
            .andExpect(jsonPath("$.[*].imgDeleted").value(hasItem(DEFAULT_IMG_DELETED.booleanValue())))
            .andExpect(jsonPath("$.[*].retsServer").value(hasItem(DEFAULT_RETS_SERVER)))
            .andExpect(jsonPath("$.[*].permalink").value(hasItem(DEFAULT_PERMALINK)))
            .andExpect(jsonPath("$.[*].propertyTag").value(hasItem(DEFAULT_PROPERTY_TAG)))
            .andExpect(jsonPath("$.[*].buildentoryViews").value(hasItem(DEFAULT_BUILDENTORY_VIEWS)))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION)));
    }

    @Test
    @Transactional
    void getResProperties() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        // Get the resProperties
        restResPropertiesMockMvc
            .perform(get(ENTITY_API_URL_ID, resProperties.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resProperties.getId().intValue()))
            .andExpect(jsonPath("$.communityId").value(DEFAULT_COMMUNITY_ID))
            .andExpect(jsonPath("$.communityName").value(DEFAULT_COMMUNITY_NAME))
            .andExpect(jsonPath("$.builderId").value(DEFAULT_BUILDER_ID))
            .andExpect(jsonPath("$.specialOffers").value(DEFAULT_SPECIAL_OFFERS))
            .andExpect(jsonPath("$.brochure").value(DEFAULT_BROCHURE))
            .andExpect(jsonPath("$.floorPlanId").value(DEFAULT_FLOOR_PLAN_ID))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE))
            .andExpect(jsonPath("$.county").value(DEFAULT_COUNTY))
            .andExpect(jsonPath("$.heatsystem").value(DEFAULT_HEATSYSTEM))
            .andExpect(jsonPath("$.liststatus").value(DEFAULT_LISTSTATUS))
            .andExpect(jsonPath("$.liststatusflag").value(DEFAULT_LISTSTATUSFLAG))
            .andExpect(jsonPath("$.carportcap").value(DEFAULT_CARPORTCAP))
            .andExpect(jsonPath("$.possession").value(DEFAULT_POSSESSION))
            .andExpect(jsonPath("$.schoolname1").value(DEFAULT_SCHOOLNAME_1))
            .andExpect(jsonPath("$.subdivide").value(DEFAULT_SUBDIVIDE))
            .andExpect(jsonPath("$.vowavmyn").value(DEFAULT_VOWAVMYN))
            .andExpect(jsonPath("$.presentuse").value(DEFAULT_PRESENTUSE))
            .andExpect(jsonPath("$.proposeduse").value(DEFAULT_PROPOSEDUSE))
            .andExpect(jsonPath("$.ranchname").value(DEFAULT_RANCHNAME))
            .andExpect(jsonPath("$.roombed2width").value(DEFAULT_ROOMBED_2_WIDTH))
            .andExpect(jsonPath("$.roomdininglevel").value(DEFAULT_ROOMDININGLEVEL))
            .andExpect(jsonPath("$.roomliving2width").value(DEFAULT_ROOMLIVING_2_WIDTH))
            .andExpect(jsonPath("$.roomstudylevel").value(DEFAULT_ROOMSTUDYLEVEL))
            .andExpect(jsonPath("$.area").value(DEFAULT_AREA))
            .andExpect(jsonPath("$.areatitle").value(DEFAULT_AREATITLE))
            .andExpect(jsonPath("$.assocfee").value(DEFAULT_ASSOCFEE))
            .andExpect(jsonPath("$.financeproposed").value(DEFAULT_FINANCEPROPOSED))
            .andExpect(jsonPath("$.listpriceorig").value(DEFAULT_LISTPRICEORIG))
            .andExpect(jsonPath("$.mapcoord").value(DEFAULT_MAPCOORD))
            .andExpect(jsonPath("$.schoolname2").value(DEFAULT_SCHOOLNAME_2))
            .andExpect(jsonPath("$.roomgaragewidth").value(DEFAULT_ROOMGARAGEWIDTH))
            .andExpect(jsonPath("$.roomkitchendesc").value(DEFAULT_ROOMKITCHENDESC))
            .andExpect(jsonPath("$.roomliving1width").value(DEFAULT_ROOMLIVING_1_WIDTH))
            .andExpect(jsonPath("$.roomother2width").value(DEFAULT_ROOMOTHER_2_WIDTH))
            .andExpect(jsonPath("$.sqfttotal").value(DEFAULT_SQFTTOTAL))
            .andExpect(jsonPath("$.officelistOfficenam1").value(DEFAULT_OFFICELIST_OFFICENAM_1))
            .andExpect(jsonPath("$.schoolname3").value(DEFAULT_SCHOOLNAME_3))
            .andExpect(jsonPath("$.zipcode").value(DEFAULT_ZIPCODE))
            .andExpect(jsonPath("$.barn1length").value(DEFAULT_BARN_1_LENGTH))
            .andExpect(jsonPath("$.barn3width").value(DEFAULT_BARN_3_WIDTH))
            .andExpect(jsonPath("$.roombed2length").value(DEFAULT_ROOMBED_2_LENGTH))
            .andExpect(jsonPath("$.roombed3length").value(DEFAULT_ROOMBED_3_LENGTH))
            .andExpect(jsonPath("$.roomother1width").value(DEFAULT_ROOMOTHER_1_WIDTH))
            .andExpect(jsonPath("$.agentlistFullname").value(DEFAULT_AGENTLIST_FULLNAME))
            .andExpect(jsonPath("$.proptype").value(DEFAULT_PROPTYPE))
            .andExpect(jsonPath("$.mlsProptype").value(DEFAULT_MLS_PROPTYPE))
            .andExpect(jsonPath("$.schoolname4").value(DEFAULT_SCHOOLNAME_4))
            .andExpect(jsonPath("$.acrescultivated").value(sameNumber(DEFAULT_ACRESCULTIVATED)))
            .andExpect(jsonPath("$.barn2length").value(DEFAULT_BARN_2_LENGTH))
            .andExpect(jsonPath("$.barn2width").value(DEFAULT_BARN_2_WIDTH))
            .andExpect(jsonPath("$.complexname").value(DEFAULT_COMPLEXNAME))
            .andExpect(jsonPath("$.roombed4length").value(DEFAULT_ROOMBED_4_LENGTH))
            .andExpect(jsonPath("$.roombedbathdesc").value(DEFAULT_ROOMBEDBATHDESC))
            .andExpect(jsonPath("$.roombreakfastwidth").value(DEFAULT_ROOMBREAKFASTWIDTH))
            .andExpect(jsonPath("$.roomother").value(DEFAULT_ROOMOTHER))
            .andExpect(jsonPath("$.roomutilitylength").value(DEFAULT_ROOMUTILITYLENGTH))
            .andExpect(jsonPath("$.acres").value(sameNumber(DEFAULT_ACRES)))
            .andExpect(jsonPath("$.block").value(DEFAULT_BLOCK))
            .andExpect(jsonPath("$.directions").value(DEFAULT_DIRECTIONS))
            .andExpect(jsonPath("$.subdivision").value(DEFAULT_SUBDIVISION))
            .andExpect(jsonPath("$.yearbuilt").value(DEFAULT_YEARBUILT))
            .andExpect(jsonPath("$.yearbuiltdetails").value(DEFAULT_YEARBUILTDETAILS))
            .andExpect(jsonPath("$.agexemption").value(DEFAULT_AGEXEMPTION))
            .andExpect(jsonPath("$.barn1width").value(DEFAULT_BARN_1_WIDTH))
            .andExpect(jsonPath("$.barn3length").value(DEFAULT_BARN_3_LENGTH))
            .andExpect(jsonPath("$.roomdiningwidth").value(DEFAULT_ROOMDININGWIDTH))
            .andExpect(jsonPath("$.roomstudywidth").value(DEFAULT_ROOMSTUDYWIDTH))
            .andExpect(jsonPath("$.soiltype").value(DEFAULT_SOILTYPE))
            .andExpect(jsonPath("$.appraisername").value(DEFAULT_APPRAISERNAME))
            .andExpect(jsonPath("$.listpricelow").value(DEFAULT_LISTPRICELOW))
            .andExpect(jsonPath("$.mappage").value(DEFAULT_MAPPAGE))
            .andExpect(jsonPath("$.unitnumber").value(DEFAULT_UNITNUMBER))
            .andExpect(jsonPath("$.streetdir").value(DEFAULT_STREETDIR))
            .andExpect(jsonPath("$.streettype").value(DEFAULT_STREETTYPE))
            .andExpect(jsonPath("$.subarea").value(DEFAULT_SUBAREA))
            .andExpect(jsonPath("$.subareatitle").value(DEFAULT_SUBAREATITLE))
            .andExpect(jsonPath("$.bathshalf").value(DEFAULT_BATHSHALF))
            .andExpect(jsonPath("$.roomgaragelength").value(DEFAULT_ROOMGARAGELENGTH))
            .andExpect(jsonPath("$.propsubtype").value(DEFAULT_PROPSUBTYPE))
            .andExpect(jsonPath("$.beds").value(DEFAULT_BEDS))
            .andExpect(jsonPath("$.roommasterbedwidth").value(DEFAULT_ROOMMASTERBEDWIDTH))
            .andExpect(jsonPath("$.roomstudylength").value(DEFAULT_ROOMSTUDYLENGTH))
            .andExpect(jsonPath("$.agentlist").value(DEFAULT_AGENTLIST))
            .andExpect(jsonPath("$.streetname").value(DEFAULT_STREETNAME))
            .andExpect(jsonPath("$.roombreakfastlength").value(DEFAULT_ROOMBREAKFASTLENGTH))
            .andExpect(jsonPath("$.roomkitchenwidth").value(DEFAULT_ROOMKITCHENWIDTH))
            .andExpect(jsonPath("$.fence").value(DEFAULT_FENCE))
            .andExpect(jsonPath("$.bathstotal").value(sameNumber(DEFAULT_BATHSTOTAL)))
            .andExpect(jsonPath("$.garagecap").value(DEFAULT_GARAGECAP))
            .andExpect(jsonPath("$.sqftprice").value(sameNumber(DEFAULT_SQFTPRICE)))
            .andExpect(jsonPath("$.style").value(DEFAULT_STYLE))
            .andExpect(jsonPath("$.exterior").value(DEFAULT_EXTERIOR))
            .andExpect(jsonPath("$.foundation").value(DEFAULT_FOUNDATION))
            .andExpect(jsonPath("$.interior").value(DEFAULT_INTERIOR))
            .andExpect(jsonPath("$.poolyn").value(DEFAULT_POOLYN))
            .andExpect(jsonPath("$.poolFeature").value(DEFAULT_POOL_FEATURE))
            .andExpect(jsonPath("$.listprice").value(DEFAULT_LISTPRICE))
            .andExpect(jsonPath("$.listpricerange").value(DEFAULT_LISTPRICERANGE))
            .andExpect(jsonPath("$.mlsnum").value(DEFAULT_MLSNUM))
            .andExpect(jsonPath("$.matrixid").value(DEFAULT_MATRIXID))
            .andExpect(jsonPath("$.remarks").value(DEFAULT_REMARKS))
            .andExpect(jsonPath("$.state").value(DEFAULT_STATE))
            .andExpect(jsonPath("$.roof").value(DEFAULT_ROOF))
            .andExpect(jsonPath("$.securityfeatures").value(DEFAULT_SECURITYFEATURES))
            .andExpect(jsonPath("$.utilitiesother").value(DEFAULT_UTILITIESOTHER))
            .andExpect(jsonPath("$.commonfeatures").value(DEFAULT_COMMONFEATURES))
            .andExpect(jsonPath("$.construction").value(DEFAULT_CONSTRUCTION))
            .andExpect(jsonPath("$.modified").value(DEFAULT_MODIFIED.toString()))
            .andExpect(jsonPath("$.stories").value(DEFAULT_STORIES))
            .andExpect(jsonPath("$.roomdininglength").value(DEFAULT_ROOMDININGLENGTH))
            .andExpect(jsonPath("$.roomliving1length").value(DEFAULT_ROOMLIVING_1_LENGTH))
            .andExpect(jsonPath("$.openhousetime").value(DEFAULT_OPENHOUSETIME))
            .andExpect(jsonPath("$.openhouseendtime").value(DEFAULT_OPENHOUSEENDTIME))
            .andExpect(jsonPath("$.roomliving2length").value(DEFAULT_ROOMLIVING_2_LENGTH))
            .andExpect(jsonPath("$.lotdesc").value(DEFAULT_LOTDESC))
            .andExpect(jsonPath("$.openhousedate").value(DEFAULT_OPENHOUSEDATE.toString()))
            .andExpect(jsonPath("$.roommasterbedlength").value(DEFAULT_ROOMMASTERBEDLENGTH))
            .andExpect(jsonPath("$.roomother1length").value(DEFAULT_ROOMOTHER_1_LENGTH))
            .andExpect(jsonPath("$.officesellOfficenam2").value(DEFAULT_OFFICESELL_OFFICENAM_2))
            .andExpect(jsonPath("$.lotsize").value(DEFAULT_LOTSIZE))
            .andExpect(jsonPath("$.streetdirsuffix").value(DEFAULT_STREETDIRSUFFIX))
            .andExpect(jsonPath("$.photocount").value(DEFAULT_PHOTOCOUNT))
            .andExpect(jsonPath("$.schooldistrict").value(DEFAULT_SCHOOLDISTRICT))
            .andExpect(jsonPath("$.streetnum").value(DEFAULT_STREETNUM))
            .andExpect(jsonPath("$.utilities").value(DEFAULT_UTILITIES))
            .andExpect(jsonPath("$.equipment").value(DEFAULT_EQUIPMENT))
            .andExpect(jsonPath("$.roombed4width").value(DEFAULT_ROOMBED_4_WIDTH))
            .andExpect(jsonPath("$.roomkitchenlength").value(DEFAULT_ROOMKITCHENLENGTH))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.garagedesc").value(DEFAULT_GARAGEDESC))
            .andExpect(jsonPath("$.bathsfull").value(DEFAULT_BATHSFULL))
            .andExpect(jsonPath("$.roombed3width").value(DEFAULT_ROOMBED_3_WIDTH))
            .andExpect(jsonPath("$.roomutildesc").value(DEFAULT_ROOMUTILDESC))
            .andExpect(jsonPath("$.roomutilitywidth").value(DEFAULT_ROOMUTILITYWIDTH))
            .andExpect(jsonPath("$.roomfullbathlength").value(DEFAULT_ROOMFULLBATHLENGTH))
            .andExpect(jsonPath("$.roomfullbathwidth").value(DEFAULT_ROOMFULLBATHWIDTH))
            .andExpect(jsonPath("$.roomhalfbathlength").value(DEFAULT_ROOMHALFBATHLENGTH))
            .andExpect(jsonPath("$.roomhalfbathwidth").value(DEFAULT_ROOMHALFBATHWIDTH))
            .andExpect(jsonPath("$.roomexerciselength").value(DEFAULT_ROOMEXERCISELENGTH))
            .andExpect(jsonPath("$.roomexercisewidth").value(DEFAULT_ROOMEXERCISEWIDTH))
            .andExpect(jsonPath("$.roomstoragelength").value(DEFAULT_ROOMSTORAGELENGTH))
            .andExpect(jsonPath("$.roomstoragewidth").value(DEFAULT_ROOMSTORAGEWIDTH))
            .andExpect(jsonPath("$.roomgamelength").value(DEFAULT_ROOMGAMELENGTH))
            .andExpect(jsonPath("$.roomgamewidth").value(DEFAULT_ROOMGAMEWIDTH))
            .andExpect(jsonPath("$.roomguestlength").value(DEFAULT_ROOMGUESTLENGTH))
            .andExpect(jsonPath("$.roomguestwidth").value(DEFAULT_ROOMGUESTWIDTH))
            .andExpect(jsonPath("$.roomlibrarylength").value(DEFAULT_ROOMLIBRARYLENGTH))
            .andExpect(jsonPath("$.roomlibrarywidth").value(DEFAULT_ROOMLIBRARYWIDTH))
            .andExpect(jsonPath("$.roommedialength").value(DEFAULT_ROOMMEDIALENGTH))
            .andExpect(jsonPath("$.roommediawidth").value(DEFAULT_ROOMMEDIAWIDTH))
            .andExpect(jsonPath("$.roommudlength").value(DEFAULT_ROOMMUDLENGTH))
            .andExpect(jsonPath("$.roommudwidth").value(DEFAULT_ROOMMUDWIDTH))
            .andExpect(jsonPath("$.roomofficelength").value(DEFAULT_ROOMOFFICELENGTH))
            .andExpect(jsonPath("$.roomofficewidth").value(DEFAULT_ROOMOFFICEWIDTH))
            .andExpect(jsonPath("$.roomsaunalength").value(DEFAULT_ROOMSAUNALENGTH))
            .andExpect(jsonPath("$.roomsaunawidth").value(DEFAULT_ROOMSAUNAWIDTH))
            .andExpect(jsonPath("$.roomsecondmasterlength").value(DEFAULT_ROOMSECONDMASTERLENGTH))
            .andExpect(jsonPath("$.roomsecondmasterwidth").value(DEFAULT_ROOMSECONDMASTERWIDTH))
            .andExpect(jsonPath("$.roomsunlength").value(DEFAULT_ROOMSUNLENGTH))
            .andExpect(jsonPath("$.roomsunwidth").value(DEFAULT_ROOMSUNWIDTH))
            .andExpect(jsonPath("$.roomspalength").value(DEFAULT_ROOMSPALENGTH))
            .andExpect(jsonPath("$.roomspawidth").value(DEFAULT_ROOMSPAWIDTH))
            .andExpect(jsonPath("$.roomwinelength").value(DEFAULT_ROOMWINELENGTH))
            .andExpect(jsonPath("$.roomwinewidth").value(DEFAULT_ROOMWINEWIDTH))
            .andExpect(jsonPath("$.juniorhighschoolname").value(DEFAULT_JUNIORHIGHSCHOOLNAME))
            .andExpect(jsonPath("$.primaryschoolname").value(DEFAULT_PRIMARYSCHOOLNAME))
            .andExpect(jsonPath("$.seniorhighschoolname").value(DEFAULT_SENIORHIGHSCHOOLNAME))
            .andExpect(jsonPath("$.associationfee").value(DEFAULT_ASSOCIATIONFEE))
            .andExpect(jsonPath("$.associationfeefrequency").value(DEFAULT_ASSOCIATIONFEEFREQUENCY))
            .andExpect(jsonPath("$.constructionmaterials").value(DEFAULT_CONSTRUCTIONMATERIALS))
            .andExpect(jsonPath("$.heating").value(DEFAULT_HEATING))
            .andExpect(jsonPath("$.accessoryunittype").value(DEFAULT_ACCESSORYUNITTYPE))
            .andExpect(jsonPath("$.accessoryunityn").value(DEFAULT_ACCESSORYUNITYN))
            .andExpect(jsonPath("$.flooring").value(DEFAULT_FLOORING))
            .andExpect(jsonPath("$.fireplacestotal").value(DEFAULT_FIREPLACESTOTAL))
            .andExpect(jsonPath("$.fireplacefeatures").value(DEFAULT_FIREPLACEFEATURES))
            .andExpect(jsonPath("$.securitysystemyn").value(DEFAULT_SECURITYSYSTEMYN))
            .andExpect(jsonPath("$.greenbuildingcertification").value(DEFAULT_GREENBUILDINGCERTIFICATION))
            .andExpect(jsonPath("$.greenenergyefficient").value(DEFAULT_GREENENERGYEFFICIENT))
            .andExpect(jsonPath("$.energysavingfeatures").value(DEFAULT_ENERGYSAVINGFEATURES))
            .andExpect(jsonPath("$.lotnumber").value(DEFAULT_LOTNUMBER))
            .andExpect(jsonPath("$.lotsizearea").value(DEFAULT_LOTSIZEAREA))
            .andExpect(jsonPath("$.lotsizedimensions").value(DEFAULT_LOTSIZEDIMENSIONS))
            .andExpect(jsonPath("$.easements").value(DEFAULT_EASEMENTS))
            .andExpect(jsonPath("$.restrictions").value(DEFAULT_RESTRICTIONS))
            .andExpect(jsonPath("$.washerdryerconnections").value(DEFAULT_WASHERDRYERCONNECTIONS))
            .andExpect(jsonPath("$.municipalutilitydistrictyn").value(DEFAULT_MUNICIPALUTILITYDISTRICTYN))
            .andExpect(jsonPath("$.associationfeeincludes").value(DEFAULT_ASSOCIATIONFEEINCLUDES))
            .andExpect(jsonPath("$.associationtype").value(DEFAULT_ASSOCIATIONTYPE))
            .andExpect(jsonPath("$.barninformation").value(DEFAULT_BARNINFORMATION))
            .andExpect(jsonPath("$.constructionmaterialswalls").value(DEFAULT_CONSTRUCTIONMATERIALSWALLS))
            .andExpect(jsonPath("$.countyorparish").value(DEFAULT_COUNTYORPARISH))
            .andExpect(jsonPath("$.exteriorbuildings").value(DEFAULT_EXTERIORBUILDINGS))
            .andExpect(jsonPath("$.farmranchfeatures").value(DEFAULT_FARMRANCHFEATURES))
            .andExpect(jsonPath("$.fencedyardyn").value(DEFAULT_FENCEDYARDYN))
            .andExpect(jsonPath("$.financingproposed").value(DEFAULT_FINANCINGPROPOSED))
            .andExpect(jsonPath("$.handicapyn").value(DEFAULT_HANDICAPYN))
            .andExpect(jsonPath("$.numberoftanksandponds").value(DEFAULT_NUMBEROFTANKSANDPONDS))
            .andExpect(jsonPath("$.parcelnumber").value(DEFAULT_PARCELNUMBER))
            .andExpect(jsonPath("$.virtualtoururlunbranded").value(DEFAULT_VIRTUALTOURURLUNBRANDED))
            .andExpect(jsonPath("$.livingRoomFeature").value(DEFAULT_LIVING_ROOM_FEATURE))
            .andExpect(jsonPath("$.masterBedRoomFeature").value(DEFAULT_MASTER_BED_ROOM_FEATURE))
            .andExpect(jsonPath("$.bedRoomFeature").value(DEFAULT_BED_ROOM_FEATURE))
            .andExpect(jsonPath("$.diningRoomFeature").value(DEFAULT_DINING_ROOM_FEATURE))
            .andExpect(jsonPath("$.kitchenRoomFeature").value(DEFAULT_KITCHEN_ROOM_FEATURE))
            .andExpect(jsonPath("$.breakfastRoomFeature").value(DEFAULT_BREAKFAST_ROOM_FEATURE))
            .andExpect(jsonPath("$.studyRoomFeature").value(DEFAULT_STUDY_ROOM_FEATURE))
            .andExpect(jsonPath("$.utilityRoomFeature").value(DEFAULT_UTILITY_ROOM_FEATURE))
            .andExpect(jsonPath("$.fullBathRoomFeature").value(DEFAULT_FULL_BATH_ROOM_FEATURE))
            .andExpect(jsonPath("$.halfBathRoomFeature").value(DEFAULT_HALF_BATH_ROOM_FEATURE))
            .andExpect(jsonPath("$.exerciseRoomFeature").value(DEFAULT_EXERCISE_ROOM_FEATURE))
            .andExpect(jsonPath("$.extraStorageRoomFeature").value(DEFAULT_EXTRA_STORAGE_ROOM_FEATURE))
            .andExpect(jsonPath("$.gameRoomFeature").value(DEFAULT_GAME_ROOM_FEATURE))
            .andExpect(jsonPath("$.guestRoomFeature").value(DEFAULT_GUEST_ROOM_FEATURE))
            .andExpect(jsonPath("$.libraryRoomFeature").value(DEFAULT_LIBRARY_ROOM_FEATURE))
            .andExpect(jsonPath("$.mediaRoomFeature").value(DEFAULT_MEDIA_ROOM_FEATURE))
            .andExpect(jsonPath("$.mudRoomFeature").value(DEFAULT_MUD_ROOM_FEATURE))
            .andExpect(jsonPath("$.officeRoomFeature").value(DEFAULT_OFFICE_ROOM_FEATURE))
            .andExpect(jsonPath("$.saunaRoomFeature").value(DEFAULT_SAUNA_ROOM_FEATURE))
            .andExpect(jsonPath("$.secondMasterRoomFeature").value(DEFAULT_SECOND_MASTER_ROOM_FEATURE))
            .andExpect(jsonPath("$.sunroomRoomFeature").value(DEFAULT_SUNROOM_ROOM_FEATURE))
            .andExpect(jsonPath("$.spaRoomFeature").value(DEFAULT_SPA_ROOM_FEATURE))
            .andExpect(jsonPath("$.wineRoomFeature").value(DEFAULT_WINE_ROOM_FEATURE))
            .andExpect(jsonPath("$.otherRoomFeature").value(DEFAULT_OTHER_ROOM_FEATURE))
            .andExpect(jsonPath("$.isLuxury").value(DEFAULT_IS_LUXURY))
            .andExpect(jsonPath("$.isMoveInReady").value(DEFAULT_IS_MOVE_IN_READY))
            .andExpect(jsonPath("$.photoUrl").value(DEFAULT_PHOTO_URL))
            .andExpect(jsonPath("$.photo1Url").value(DEFAULT_PHOTO_1_URL))
            .andExpect(jsonPath("$.photo2Url").value(DEFAULT_PHOTO_2_URL))
            .andExpect(jsonPath("$.photo3Url").value(DEFAULT_PHOTO_3_URL))
            .andExpect(jsonPath("$.photo4Url").value(DEFAULT_PHOTO_4_URL))
            .andExpect(jsonPath("$.photo5Url").value(DEFAULT_PHOTO_5_URL))
            .andExpect(jsonPath("$.photo6Url").value(DEFAULT_PHOTO_6_URL))
            .andExpect(jsonPath("$.photo7Url").value(DEFAULT_PHOTO_7_URL))
            .andExpect(jsonPath("$.photo8Url").value(DEFAULT_PHOTO_8_URL))
            .andExpect(jsonPath("$.photo9Url").value(DEFAULT_PHOTO_9_URL))
            .andExpect(jsonPath("$.photo10Url").value(DEFAULT_PHOTO_10_URL))
            .andExpect(jsonPath("$.photo11Url").value(DEFAULT_PHOTO_11_URL))
            .andExpect(jsonPath("$.photo12Url").value(DEFAULT_PHOTO_12_URL))
            .andExpect(jsonPath("$.photo13Url").value(DEFAULT_PHOTO_13_URL))
            .andExpect(jsonPath("$.photo14Url").value(DEFAULT_PHOTO_14_URL))
            .andExpect(jsonPath("$.photo15Url").value(DEFAULT_PHOTO_15_URL))
            .andExpect(jsonPath("$.photo16Url").value(DEFAULT_PHOTO_16_URL))
            .andExpect(jsonPath("$.photo17Url").value(DEFAULT_PHOTO_17_URL))
            .andExpect(jsonPath("$.photo18Url").value(DEFAULT_PHOTO_18_URL))
            .andExpect(jsonPath("$.photo19Url").value(DEFAULT_PHOTO_19_URL))
            .andExpect(jsonPath("$.photo20Url").value(DEFAULT_PHOTO_20_URL))
            .andExpect(jsonPath("$.photo21Url").value(DEFAULT_PHOTO_21_URL))
            .andExpect(jsonPath("$.photo22Url").value(DEFAULT_PHOTO_22_URL))
            .andExpect(jsonPath("$.photo23Url").value(DEFAULT_PHOTO_23_URL))
            .andExpect(jsonPath("$.photo24Url").value(DEFAULT_PHOTO_24_URL))
            .andExpect(jsonPath("$.photo25Url").value(DEFAULT_PHOTO_25_URL))
            .andExpect(jsonPath("$.photo26Url").value(DEFAULT_PHOTO_26_URL))
            .andExpect(jsonPath("$.photo27Url").value(DEFAULT_PHOTO_27_URL))
            .andExpect(jsonPath("$.photo28Url").value(DEFAULT_PHOTO_28_URL))
            .andExpect(jsonPath("$.photo29Url").value(DEFAULT_PHOTO_29_URL))
            .andExpect(jsonPath("$.photo30Url").value(DEFAULT_PHOTO_30_URL))
            .andExpect(jsonPath("$.photo31Url").value(DEFAULT_PHOTO_31_URL))
            .andExpect(jsonPath("$.photo32Url").value(DEFAULT_PHOTO_32_URL))
            .andExpect(jsonPath("$.photo33Url").value(DEFAULT_PHOTO_33_URL))
            .andExpect(jsonPath("$.photo34Url").value(DEFAULT_PHOTO_34_URL))
            .andExpect(jsonPath("$.photo35Url").value(DEFAULT_PHOTO_35_URL))
            .andExpect(jsonPath("$.photo36Url").value(DEFAULT_PHOTO_36_URL))
            .andExpect(jsonPath("$.photo37Url").value(DEFAULT_PHOTO_37_URL))
            .andExpect(jsonPath("$.photo38Url").value(DEFAULT_PHOTO_38_URL))
            .andExpect(jsonPath("$.photo39Url").value(DEFAULT_PHOTO_39_URL))
            .andExpect(jsonPath("$.photo40Url").value(DEFAULT_PHOTO_40_URL))
            .andExpect(jsonPath("$.created").value(DEFAULT_CREATED.toString()))
            .andExpect(jsonPath("$.updated").value(DEFAULT_UPDATED.toString()))
            .andExpect(jsonPath("$.modifiedDate").value(DEFAULT_MODIFIED_DATE.toString()))
            .andExpect(jsonPath("$.imgDeleted").value(DEFAULT_IMG_DELETED.booleanValue()))
            .andExpect(jsonPath("$.retsServer").value(DEFAULT_RETS_SERVER))
            .andExpect(jsonPath("$.permalink").value(DEFAULT_PERMALINK))
            .andExpect(jsonPath("$.propertyTag").value(DEFAULT_PROPERTY_TAG))
            .andExpect(jsonPath("$.buildentoryViews").value(DEFAULT_BUILDENTORY_VIEWS))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION));
    }

    @Test
    @Transactional
    void getNonExistingResProperties() throws Exception {
        // Get the resProperties
        restResPropertiesMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewResProperties() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();

        // Update the resProperties
        ResProperties updatedResProperties = resPropertiesRepository.findById(resProperties.getId()).get();
        // Disconnect from session so that the updates on updatedResProperties are not directly saved in db
        em.detach(updatedResProperties);
        updatedResProperties
            .communityId(UPDATED_COMMUNITY_ID)
            .communityName(UPDATED_COMMUNITY_NAME)
            .builderId(UPDATED_BUILDER_ID)
            .specialOffers(UPDATED_SPECIAL_OFFERS)
            .brochure(UPDATED_BROCHURE)
            .floorPlanId(UPDATED_FLOOR_PLAN_ID)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .county(UPDATED_COUNTY)
            .heatsystem(UPDATED_HEATSYSTEM)
            .liststatus(UPDATED_LISTSTATUS)
            .liststatusflag(UPDATED_LISTSTATUSFLAG)
            .carportcap(UPDATED_CARPORTCAP)
            .possession(UPDATED_POSSESSION)
            .schoolname1(UPDATED_SCHOOLNAME_1)
            .subdivide(UPDATED_SUBDIVIDE)
            .vowavmyn(UPDATED_VOWAVMYN)
            .presentuse(UPDATED_PRESENTUSE)
            .proposeduse(UPDATED_PROPOSEDUSE)
            .ranchname(UPDATED_RANCHNAME)
            .roombed2width(UPDATED_ROOMBED_2_WIDTH)
            .roomdininglevel(UPDATED_ROOMDININGLEVEL)
            .roomliving2width(UPDATED_ROOMLIVING_2_WIDTH)
            .roomstudylevel(UPDATED_ROOMSTUDYLEVEL)
            .area(UPDATED_AREA)
            .areatitle(UPDATED_AREATITLE)
            .assocfee(UPDATED_ASSOCFEE)
            .financeproposed(UPDATED_FINANCEPROPOSED)
            .listpriceorig(UPDATED_LISTPRICEORIG)
            .mapcoord(UPDATED_MAPCOORD)
            .schoolname2(UPDATED_SCHOOLNAME_2)
            .roomgaragewidth(UPDATED_ROOMGARAGEWIDTH)
            .roomkitchendesc(UPDATED_ROOMKITCHENDESC)
            .roomliving1width(UPDATED_ROOMLIVING_1_WIDTH)
            .roomother2width(UPDATED_ROOMOTHER_2_WIDTH)
            .sqfttotal(UPDATED_SQFTTOTAL)
            .officelistOfficenam1(UPDATED_OFFICELIST_OFFICENAM_1)
            .schoolname3(UPDATED_SCHOOLNAME_3)
            .zipcode(UPDATED_ZIPCODE)
            .barn1length(UPDATED_BARN_1_LENGTH)
            .barn3width(UPDATED_BARN_3_WIDTH)
            .roombed2length(UPDATED_ROOMBED_2_LENGTH)
            .roombed3length(UPDATED_ROOMBED_3_LENGTH)
            .roomother1width(UPDATED_ROOMOTHER_1_WIDTH)
            .agentlistFullname(UPDATED_AGENTLIST_FULLNAME)
            .proptype(UPDATED_PROPTYPE)
            .mlsProptype(UPDATED_MLS_PROPTYPE)
            .schoolname4(UPDATED_SCHOOLNAME_4)
            .acrescultivated(UPDATED_ACRESCULTIVATED)
            .barn2length(UPDATED_BARN_2_LENGTH)
            .barn2width(UPDATED_BARN_2_WIDTH)
            .complexname(UPDATED_COMPLEXNAME)
            .roombed4length(UPDATED_ROOMBED_4_LENGTH)
            .roombedbathdesc(UPDATED_ROOMBEDBATHDESC)
            .roombreakfastwidth(UPDATED_ROOMBREAKFASTWIDTH)
            .roomother(UPDATED_ROOMOTHER)
            .roomutilitylength(UPDATED_ROOMUTILITYLENGTH)
            .acres(UPDATED_ACRES)
            .block(UPDATED_BLOCK)
            .directions(UPDATED_DIRECTIONS)
            .subdivision(UPDATED_SUBDIVISION)
            .yearbuilt(UPDATED_YEARBUILT)
            .yearbuiltdetails(UPDATED_YEARBUILTDETAILS)
            .agexemption(UPDATED_AGEXEMPTION)
            .barn1width(UPDATED_BARN_1_WIDTH)
            .barn3length(UPDATED_BARN_3_LENGTH)
            .roomdiningwidth(UPDATED_ROOMDININGWIDTH)
            .roomstudywidth(UPDATED_ROOMSTUDYWIDTH)
            .soiltype(UPDATED_SOILTYPE)
            .appraisername(UPDATED_APPRAISERNAME)
            .listpricelow(UPDATED_LISTPRICELOW)
            .mappage(UPDATED_MAPPAGE)
            .unitnumber(UPDATED_UNITNUMBER)
            .streetdir(UPDATED_STREETDIR)
            .streettype(UPDATED_STREETTYPE)
            .subarea(UPDATED_SUBAREA)
            .subareatitle(UPDATED_SUBAREATITLE)
            .bathshalf(UPDATED_BATHSHALF)
            .roomgaragelength(UPDATED_ROOMGARAGELENGTH)
            .propsubtype(UPDATED_PROPSUBTYPE)
            .beds(UPDATED_BEDS)
            .roommasterbedwidth(UPDATED_ROOMMASTERBEDWIDTH)
            .roomstudylength(UPDATED_ROOMSTUDYLENGTH)
            .agentlist(UPDATED_AGENTLIST)
            .streetname(UPDATED_STREETNAME)
            .roombreakfastlength(UPDATED_ROOMBREAKFASTLENGTH)
            .roomkitchenwidth(UPDATED_ROOMKITCHENWIDTH)
            .fence(UPDATED_FENCE)
            .bathstotal(UPDATED_BATHSTOTAL)
            .garagecap(UPDATED_GARAGECAP)
            .sqftprice(UPDATED_SQFTPRICE)
            .style(UPDATED_STYLE)
            .exterior(UPDATED_EXTERIOR)
            .foundation(UPDATED_FOUNDATION)
            .interior(UPDATED_INTERIOR)
            .poolyn(UPDATED_POOLYN)
            .poolFeature(UPDATED_POOL_FEATURE)
            .listprice(UPDATED_LISTPRICE)
            .listpricerange(UPDATED_LISTPRICERANGE)
            .mlsnum(UPDATED_MLSNUM)
            .matrixid(UPDATED_MATRIXID)
            .remarks(UPDATED_REMARKS)
            .state(UPDATED_STATE)
            .roof(UPDATED_ROOF)
            .securityfeatures(UPDATED_SECURITYFEATURES)
            .utilitiesother(UPDATED_UTILITIESOTHER)
            .commonfeatures(UPDATED_COMMONFEATURES)
            .construction(UPDATED_CONSTRUCTION)
            .modified(UPDATED_MODIFIED)
            .stories(UPDATED_STORIES)
            .roomdininglength(UPDATED_ROOMDININGLENGTH)
            .roomliving1length(UPDATED_ROOMLIVING_1_LENGTH)
            .openhousetime(UPDATED_OPENHOUSETIME)
            .openhouseendtime(UPDATED_OPENHOUSEENDTIME)
            .roomliving2length(UPDATED_ROOMLIVING_2_LENGTH)
            .lotdesc(UPDATED_LOTDESC)
            .openhousedate(UPDATED_OPENHOUSEDATE)
            .roommasterbedlength(UPDATED_ROOMMASTERBEDLENGTH)
            .roomother1length(UPDATED_ROOMOTHER_1_LENGTH)
            .officesellOfficenam2(UPDATED_OFFICESELL_OFFICENAM_2)
            .lotsize(UPDATED_LOTSIZE)
            .streetdirsuffix(UPDATED_STREETDIRSUFFIX)
            .photocount(UPDATED_PHOTOCOUNT)
            .schooldistrict(UPDATED_SCHOOLDISTRICT)
            .streetnum(UPDATED_STREETNUM)
            .utilities(UPDATED_UTILITIES)
            .equipment(UPDATED_EQUIPMENT)
            .roombed4width(UPDATED_ROOMBED_4_WIDTH)
            .roomkitchenlength(UPDATED_ROOMKITCHENLENGTH)
            .city(UPDATED_CITY)
            .garagedesc(UPDATED_GARAGEDESC)
            .bathsfull(UPDATED_BATHSFULL)
            .roombed3width(UPDATED_ROOMBED_3_WIDTH)
            .roomutildesc(UPDATED_ROOMUTILDESC)
            .roomutilitywidth(UPDATED_ROOMUTILITYWIDTH)
            .roomfullbathlength(UPDATED_ROOMFULLBATHLENGTH)
            .roomfullbathwidth(UPDATED_ROOMFULLBATHWIDTH)
            .roomhalfbathlength(UPDATED_ROOMHALFBATHLENGTH)
            .roomhalfbathwidth(UPDATED_ROOMHALFBATHWIDTH)
            .roomexerciselength(UPDATED_ROOMEXERCISELENGTH)
            .roomexercisewidth(UPDATED_ROOMEXERCISEWIDTH)
            .roomstoragelength(UPDATED_ROOMSTORAGELENGTH)
            .roomstoragewidth(UPDATED_ROOMSTORAGEWIDTH)
            .roomgamelength(UPDATED_ROOMGAMELENGTH)
            .roomgamewidth(UPDATED_ROOMGAMEWIDTH)
            .roomguestlength(UPDATED_ROOMGUESTLENGTH)
            .roomguestwidth(UPDATED_ROOMGUESTWIDTH)
            .roomlibrarylength(UPDATED_ROOMLIBRARYLENGTH)
            .roomlibrarywidth(UPDATED_ROOMLIBRARYWIDTH)
            .roommedialength(UPDATED_ROOMMEDIALENGTH)
            .roommediawidth(UPDATED_ROOMMEDIAWIDTH)
            .roommudlength(UPDATED_ROOMMUDLENGTH)
            .roommudwidth(UPDATED_ROOMMUDWIDTH)
            .roomofficelength(UPDATED_ROOMOFFICELENGTH)
            .roomofficewidth(UPDATED_ROOMOFFICEWIDTH)
            .roomsaunalength(UPDATED_ROOMSAUNALENGTH)
            .roomsaunawidth(UPDATED_ROOMSAUNAWIDTH)
            .roomsecondmasterlength(UPDATED_ROOMSECONDMASTERLENGTH)
            .roomsecondmasterwidth(UPDATED_ROOMSECONDMASTERWIDTH)
            .roomsunlength(UPDATED_ROOMSUNLENGTH)
            .roomsunwidth(UPDATED_ROOMSUNWIDTH)
            .roomspalength(UPDATED_ROOMSPALENGTH)
            .roomspawidth(UPDATED_ROOMSPAWIDTH)
            .roomwinelength(UPDATED_ROOMWINELENGTH)
            .roomwinewidth(UPDATED_ROOMWINEWIDTH)
            .juniorhighschoolname(UPDATED_JUNIORHIGHSCHOOLNAME)
            .primaryschoolname(UPDATED_PRIMARYSCHOOLNAME)
            .seniorhighschoolname(UPDATED_SENIORHIGHSCHOOLNAME)
            .associationfee(UPDATED_ASSOCIATIONFEE)
            .associationfeefrequency(UPDATED_ASSOCIATIONFEEFREQUENCY)
            .constructionmaterials(UPDATED_CONSTRUCTIONMATERIALS)
            .heating(UPDATED_HEATING)
            .accessoryunittype(UPDATED_ACCESSORYUNITTYPE)
            .accessoryunityn(UPDATED_ACCESSORYUNITYN)
            .flooring(UPDATED_FLOORING)
            .fireplacestotal(UPDATED_FIREPLACESTOTAL)
            .fireplacefeatures(UPDATED_FIREPLACEFEATURES)
            .securitysystemyn(UPDATED_SECURITYSYSTEMYN)
            .greenbuildingcertification(UPDATED_GREENBUILDINGCERTIFICATION)
            .greenenergyefficient(UPDATED_GREENENERGYEFFICIENT)
            .energysavingfeatures(UPDATED_ENERGYSAVINGFEATURES)
            .lotnumber(UPDATED_LOTNUMBER)
            .lotsizearea(UPDATED_LOTSIZEAREA)
            .lotsizedimensions(UPDATED_LOTSIZEDIMENSIONS)
            .easements(UPDATED_EASEMENTS)
            .restrictions(UPDATED_RESTRICTIONS)
            .washerdryerconnections(UPDATED_WASHERDRYERCONNECTIONS)
            .municipalutilitydistrictyn(UPDATED_MUNICIPALUTILITYDISTRICTYN)
            .associationfeeincludes(UPDATED_ASSOCIATIONFEEINCLUDES)
            .associationtype(UPDATED_ASSOCIATIONTYPE)
            .barninformation(UPDATED_BARNINFORMATION)
            .constructionmaterialswalls(UPDATED_CONSTRUCTIONMATERIALSWALLS)
            .countyorparish(UPDATED_COUNTYORPARISH)
            .exteriorbuildings(UPDATED_EXTERIORBUILDINGS)
            .farmranchfeatures(UPDATED_FARMRANCHFEATURES)
            .fencedyardyn(UPDATED_FENCEDYARDYN)
            .financingproposed(UPDATED_FINANCINGPROPOSED)
            .handicapyn(UPDATED_HANDICAPYN)
            .numberoftanksandponds(UPDATED_NUMBEROFTANKSANDPONDS)
            .parcelnumber(UPDATED_PARCELNUMBER)
            .virtualtoururlunbranded(UPDATED_VIRTUALTOURURLUNBRANDED)
            .livingRoomFeature(UPDATED_LIVING_ROOM_FEATURE)
            .masterBedRoomFeature(UPDATED_MASTER_BED_ROOM_FEATURE)
            .bedRoomFeature(UPDATED_BED_ROOM_FEATURE)
            .diningRoomFeature(UPDATED_DINING_ROOM_FEATURE)
            .kitchenRoomFeature(UPDATED_KITCHEN_ROOM_FEATURE)
            .breakfastRoomFeature(UPDATED_BREAKFAST_ROOM_FEATURE)
            .studyRoomFeature(UPDATED_STUDY_ROOM_FEATURE)
            .utilityRoomFeature(UPDATED_UTILITY_ROOM_FEATURE)
            .fullBathRoomFeature(UPDATED_FULL_BATH_ROOM_FEATURE)
            .halfBathRoomFeature(UPDATED_HALF_BATH_ROOM_FEATURE)
            .exerciseRoomFeature(UPDATED_EXERCISE_ROOM_FEATURE)
            .extraStorageRoomFeature(UPDATED_EXTRA_STORAGE_ROOM_FEATURE)
            .gameRoomFeature(UPDATED_GAME_ROOM_FEATURE)
            .guestRoomFeature(UPDATED_GUEST_ROOM_FEATURE)
            .libraryRoomFeature(UPDATED_LIBRARY_ROOM_FEATURE)
            .mediaRoomFeature(UPDATED_MEDIA_ROOM_FEATURE)
            .mudRoomFeature(UPDATED_MUD_ROOM_FEATURE)
            .officeRoomFeature(UPDATED_OFFICE_ROOM_FEATURE)
            .saunaRoomFeature(UPDATED_SAUNA_ROOM_FEATURE)
            .secondMasterRoomFeature(UPDATED_SECOND_MASTER_ROOM_FEATURE)
            .sunroomRoomFeature(UPDATED_SUNROOM_ROOM_FEATURE)
            .spaRoomFeature(UPDATED_SPA_ROOM_FEATURE)
            .wineRoomFeature(UPDATED_WINE_ROOM_FEATURE)
            .otherRoomFeature(UPDATED_OTHER_ROOM_FEATURE)
            .isLuxury(UPDATED_IS_LUXURY)
            .isMoveInReady(UPDATED_IS_MOVE_IN_READY)
            .photoUrl(UPDATED_PHOTO_URL)
            .photo1Url(UPDATED_PHOTO_1_URL)
            .photo2Url(UPDATED_PHOTO_2_URL)
            .photo3Url(UPDATED_PHOTO_3_URL)
            .photo4Url(UPDATED_PHOTO_4_URL)
            .photo5Url(UPDATED_PHOTO_5_URL)
            .photo6Url(UPDATED_PHOTO_6_URL)
            .photo7Url(UPDATED_PHOTO_7_URL)
            .photo8Url(UPDATED_PHOTO_8_URL)
            .photo9Url(UPDATED_PHOTO_9_URL)
            .photo10Url(UPDATED_PHOTO_10_URL)
            .photo11Url(UPDATED_PHOTO_11_URL)
            .photo12Url(UPDATED_PHOTO_12_URL)
            .photo13Url(UPDATED_PHOTO_13_URL)
            .photo14Url(UPDATED_PHOTO_14_URL)
            .photo15Url(UPDATED_PHOTO_15_URL)
            .photo16Url(UPDATED_PHOTO_16_URL)
            .photo17Url(UPDATED_PHOTO_17_URL)
            .photo18Url(UPDATED_PHOTO_18_URL)
            .photo19Url(UPDATED_PHOTO_19_URL)
            .photo20Url(UPDATED_PHOTO_20_URL)
            .photo21Url(UPDATED_PHOTO_21_URL)
            .photo22Url(UPDATED_PHOTO_22_URL)
            .photo23Url(UPDATED_PHOTO_23_URL)
            .photo24Url(UPDATED_PHOTO_24_URL)
            .photo25Url(UPDATED_PHOTO_25_URL)
            .photo26Url(UPDATED_PHOTO_26_URL)
            .photo27Url(UPDATED_PHOTO_27_URL)
            .photo28Url(UPDATED_PHOTO_28_URL)
            .photo29Url(UPDATED_PHOTO_29_URL)
            .photo30Url(UPDATED_PHOTO_30_URL)
            .photo31Url(UPDATED_PHOTO_31_URL)
            .photo32Url(UPDATED_PHOTO_32_URL)
            .photo33Url(UPDATED_PHOTO_33_URL)
            .photo34Url(UPDATED_PHOTO_34_URL)
            .photo35Url(UPDATED_PHOTO_35_URL)
            .photo36Url(UPDATED_PHOTO_36_URL)
            .photo37Url(UPDATED_PHOTO_37_URL)
            .photo38Url(UPDATED_PHOTO_38_URL)
            .photo39Url(UPDATED_PHOTO_39_URL)
            .photo40Url(UPDATED_PHOTO_40_URL)
            .created(UPDATED_CREATED)
            .updated(UPDATED_UPDATED)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .imgDeleted(UPDATED_IMG_DELETED)
            .retsServer(UPDATED_RETS_SERVER)
            .permalink(UPDATED_PERMALINK)
            .propertyTag(UPDATED_PROPERTY_TAG)
            .buildentoryViews(UPDATED_BUILDENTORY_VIEWS)
            .location(UPDATED_LOCATION);

        restResPropertiesMockMvc
            .perform(
                put(ENTITY_API_URL_ID, updatedResProperties.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedResProperties))
            )
            .andExpect(status().isOk());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
        ResProperties testResProperties = resPropertiesList.get(resPropertiesList.size() - 1);
        assertThat(testResProperties.getCommunityId()).isEqualTo(UPDATED_COMMUNITY_ID);
        assertThat(testResProperties.getCommunityName()).isEqualTo(UPDATED_COMMUNITY_NAME);
        assertThat(testResProperties.getBuilderId()).isEqualTo(UPDATED_BUILDER_ID);
        assertThat(testResProperties.getSpecialOffers()).isEqualTo(UPDATED_SPECIAL_OFFERS);
        assertThat(testResProperties.getBrochure()).isEqualTo(UPDATED_BROCHURE);
        assertThat(testResProperties.getFloorPlanId()).isEqualTo(UPDATED_FLOOR_PLAN_ID);
        assertThat(testResProperties.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testResProperties.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testResProperties.getCounty()).isEqualTo(UPDATED_COUNTY);
        assertThat(testResProperties.getHeatsystem()).isEqualTo(UPDATED_HEATSYSTEM);
        assertThat(testResProperties.getListstatus()).isEqualTo(UPDATED_LISTSTATUS);
        assertThat(testResProperties.getListstatusflag()).isEqualTo(UPDATED_LISTSTATUSFLAG);
        assertThat(testResProperties.getCarportcap()).isEqualTo(UPDATED_CARPORTCAP);
        assertThat(testResProperties.getPossession()).isEqualTo(UPDATED_POSSESSION);
        assertThat(testResProperties.getSchoolname1()).isEqualTo(UPDATED_SCHOOLNAME_1);
        assertThat(testResProperties.getSubdivide()).isEqualTo(UPDATED_SUBDIVIDE);
        assertThat(testResProperties.getVowavmyn()).isEqualTo(UPDATED_VOWAVMYN);
        assertThat(testResProperties.getPresentuse()).isEqualTo(UPDATED_PRESENTUSE);
        assertThat(testResProperties.getProposeduse()).isEqualTo(UPDATED_PROPOSEDUSE);
        assertThat(testResProperties.getRanchname()).isEqualTo(UPDATED_RANCHNAME);
        assertThat(testResProperties.getRoombed2width()).isEqualTo(UPDATED_ROOMBED_2_WIDTH);
        assertThat(testResProperties.getRoomdininglevel()).isEqualTo(UPDATED_ROOMDININGLEVEL);
        assertThat(testResProperties.getRoomliving2width()).isEqualTo(UPDATED_ROOMLIVING_2_WIDTH);
        assertThat(testResProperties.getRoomstudylevel()).isEqualTo(UPDATED_ROOMSTUDYLEVEL);
        assertThat(testResProperties.getArea()).isEqualTo(UPDATED_AREA);
        assertThat(testResProperties.getAreatitle()).isEqualTo(UPDATED_AREATITLE);
        assertThat(testResProperties.getAssocfee()).isEqualTo(UPDATED_ASSOCFEE);
        assertThat(testResProperties.getFinanceproposed()).isEqualTo(UPDATED_FINANCEPROPOSED);
        assertThat(testResProperties.getListpriceorig()).isEqualTo(UPDATED_LISTPRICEORIG);
        assertThat(testResProperties.getMapcoord()).isEqualTo(UPDATED_MAPCOORD);
        assertThat(testResProperties.getSchoolname2()).isEqualTo(UPDATED_SCHOOLNAME_2);
        assertThat(testResProperties.getRoomgaragewidth()).isEqualTo(UPDATED_ROOMGARAGEWIDTH);
        assertThat(testResProperties.getRoomkitchendesc()).isEqualTo(UPDATED_ROOMKITCHENDESC);
        assertThat(testResProperties.getRoomliving1width()).isEqualTo(UPDATED_ROOMLIVING_1_WIDTH);
        assertThat(testResProperties.getRoomother2width()).isEqualTo(UPDATED_ROOMOTHER_2_WIDTH);
        assertThat(testResProperties.getSqfttotal()).isEqualTo(UPDATED_SQFTTOTAL);
        assertThat(testResProperties.getOfficelistOfficenam1()).isEqualTo(UPDATED_OFFICELIST_OFFICENAM_1);
        assertThat(testResProperties.getSchoolname3()).isEqualTo(UPDATED_SCHOOLNAME_3);
        assertThat(testResProperties.getZipcode()).isEqualTo(UPDATED_ZIPCODE);
        assertThat(testResProperties.getBarn1length()).isEqualTo(UPDATED_BARN_1_LENGTH);
        assertThat(testResProperties.getBarn3width()).isEqualTo(UPDATED_BARN_3_WIDTH);
        assertThat(testResProperties.getRoombed2length()).isEqualTo(UPDATED_ROOMBED_2_LENGTH);
        assertThat(testResProperties.getRoombed3length()).isEqualTo(UPDATED_ROOMBED_3_LENGTH);
        assertThat(testResProperties.getRoomother1width()).isEqualTo(UPDATED_ROOMOTHER_1_WIDTH);
        assertThat(testResProperties.getAgentlistFullname()).isEqualTo(UPDATED_AGENTLIST_FULLNAME);
        assertThat(testResProperties.getProptype()).isEqualTo(UPDATED_PROPTYPE);
        assertThat(testResProperties.getMlsProptype()).isEqualTo(UPDATED_MLS_PROPTYPE);
        assertThat(testResProperties.getSchoolname4()).isEqualTo(UPDATED_SCHOOLNAME_4);
        assertThat(testResProperties.getAcrescultivated()).isEqualTo(UPDATED_ACRESCULTIVATED);
        assertThat(testResProperties.getBarn2length()).isEqualTo(UPDATED_BARN_2_LENGTH);
        assertThat(testResProperties.getBarn2width()).isEqualTo(UPDATED_BARN_2_WIDTH);
        assertThat(testResProperties.getComplexname()).isEqualTo(UPDATED_COMPLEXNAME);
        assertThat(testResProperties.getRoombed4length()).isEqualTo(UPDATED_ROOMBED_4_LENGTH);
        assertThat(testResProperties.getRoombedbathdesc()).isEqualTo(UPDATED_ROOMBEDBATHDESC);
        assertThat(testResProperties.getRoombreakfastwidth()).isEqualTo(UPDATED_ROOMBREAKFASTWIDTH);
        assertThat(testResProperties.getRoomother()).isEqualTo(UPDATED_ROOMOTHER);
        assertThat(testResProperties.getRoomutilitylength()).isEqualTo(UPDATED_ROOMUTILITYLENGTH);
        assertThat(testResProperties.getAcres()).isEqualTo(UPDATED_ACRES);
        assertThat(testResProperties.getBlock()).isEqualTo(UPDATED_BLOCK);
        assertThat(testResProperties.getDirections()).isEqualTo(UPDATED_DIRECTIONS);
        assertThat(testResProperties.getSubdivision()).isEqualTo(UPDATED_SUBDIVISION);
        assertThat(testResProperties.getYearbuilt()).isEqualTo(UPDATED_YEARBUILT);
        assertThat(testResProperties.getYearbuiltdetails()).isEqualTo(UPDATED_YEARBUILTDETAILS);
        assertThat(testResProperties.getAgexemption()).isEqualTo(UPDATED_AGEXEMPTION);
        assertThat(testResProperties.getBarn1width()).isEqualTo(UPDATED_BARN_1_WIDTH);
        assertThat(testResProperties.getBarn3length()).isEqualTo(UPDATED_BARN_3_LENGTH);
        assertThat(testResProperties.getRoomdiningwidth()).isEqualTo(UPDATED_ROOMDININGWIDTH);
        assertThat(testResProperties.getRoomstudywidth()).isEqualTo(UPDATED_ROOMSTUDYWIDTH);
        assertThat(testResProperties.getSoiltype()).isEqualTo(UPDATED_SOILTYPE);
        assertThat(testResProperties.getAppraisername()).isEqualTo(UPDATED_APPRAISERNAME);
        assertThat(testResProperties.getListpricelow()).isEqualTo(UPDATED_LISTPRICELOW);
        assertThat(testResProperties.getMappage()).isEqualTo(UPDATED_MAPPAGE);
        assertThat(testResProperties.getUnitnumber()).isEqualTo(UPDATED_UNITNUMBER);
        assertThat(testResProperties.getStreetdir()).isEqualTo(UPDATED_STREETDIR);
        assertThat(testResProperties.getStreettype()).isEqualTo(UPDATED_STREETTYPE);
        assertThat(testResProperties.getSubarea()).isEqualTo(UPDATED_SUBAREA);
        assertThat(testResProperties.getSubareatitle()).isEqualTo(UPDATED_SUBAREATITLE);
        assertThat(testResProperties.getBathshalf()).isEqualTo(UPDATED_BATHSHALF);
        assertThat(testResProperties.getRoomgaragelength()).isEqualTo(UPDATED_ROOMGARAGELENGTH);
        assertThat(testResProperties.getPropsubtype()).isEqualTo(UPDATED_PROPSUBTYPE);
        assertThat(testResProperties.getBeds()).isEqualTo(UPDATED_BEDS);
        assertThat(testResProperties.getRoommasterbedwidth()).isEqualTo(UPDATED_ROOMMASTERBEDWIDTH);
        assertThat(testResProperties.getRoomstudylength()).isEqualTo(UPDATED_ROOMSTUDYLENGTH);
        assertThat(testResProperties.getAgentlist()).isEqualTo(UPDATED_AGENTLIST);
        assertThat(testResProperties.getStreetname()).isEqualTo(UPDATED_STREETNAME);
        assertThat(testResProperties.getRoombreakfastlength()).isEqualTo(UPDATED_ROOMBREAKFASTLENGTH);
        assertThat(testResProperties.getRoomkitchenwidth()).isEqualTo(UPDATED_ROOMKITCHENWIDTH);
        assertThat(testResProperties.getFence()).isEqualTo(UPDATED_FENCE);
        assertThat(testResProperties.getBathstotal()).isEqualTo(UPDATED_BATHSTOTAL);
        assertThat(testResProperties.getGaragecap()).isEqualTo(UPDATED_GARAGECAP);
        assertThat(testResProperties.getSqftprice()).isEqualTo(UPDATED_SQFTPRICE);
        assertThat(testResProperties.getStyle()).isEqualTo(UPDATED_STYLE);
        assertThat(testResProperties.getExterior()).isEqualTo(UPDATED_EXTERIOR);
        assertThat(testResProperties.getFoundation()).isEqualTo(UPDATED_FOUNDATION);
        assertThat(testResProperties.getInterior()).isEqualTo(UPDATED_INTERIOR);
        assertThat(testResProperties.getPoolyn()).isEqualTo(UPDATED_POOLYN);
        assertThat(testResProperties.getPoolFeature()).isEqualTo(UPDATED_POOL_FEATURE);
        assertThat(testResProperties.getListprice()).isEqualTo(UPDATED_LISTPRICE);
        assertThat(testResProperties.getListpricerange()).isEqualTo(UPDATED_LISTPRICERANGE);
        assertThat(testResProperties.getMlsnum()).isEqualTo(UPDATED_MLSNUM);
        assertThat(testResProperties.getMatrixid()).isEqualTo(UPDATED_MATRIXID);
        assertThat(testResProperties.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testResProperties.getState()).isEqualTo(UPDATED_STATE);
        assertThat(testResProperties.getRoof()).isEqualTo(UPDATED_ROOF);
        assertThat(testResProperties.getSecurityfeatures()).isEqualTo(UPDATED_SECURITYFEATURES);
        assertThat(testResProperties.getUtilitiesother()).isEqualTo(UPDATED_UTILITIESOTHER);
        assertThat(testResProperties.getCommonfeatures()).isEqualTo(UPDATED_COMMONFEATURES);
        assertThat(testResProperties.getConstruction()).isEqualTo(UPDATED_CONSTRUCTION);
        assertThat(testResProperties.getModified()).isEqualTo(UPDATED_MODIFIED);
        assertThat(testResProperties.getStories()).isEqualTo(UPDATED_STORIES);
        assertThat(testResProperties.getRoomdininglength()).isEqualTo(UPDATED_ROOMDININGLENGTH);
        assertThat(testResProperties.getRoomliving1length()).isEqualTo(UPDATED_ROOMLIVING_1_LENGTH);
        assertThat(testResProperties.getOpenhousetime()).isEqualTo(UPDATED_OPENHOUSETIME);
        assertThat(testResProperties.getOpenhouseendtime()).isEqualTo(UPDATED_OPENHOUSEENDTIME);
        assertThat(testResProperties.getRoomliving2length()).isEqualTo(UPDATED_ROOMLIVING_2_LENGTH);
        assertThat(testResProperties.getLotdesc()).isEqualTo(UPDATED_LOTDESC);
        assertThat(testResProperties.getOpenhousedate()).isEqualTo(UPDATED_OPENHOUSEDATE);
        assertThat(testResProperties.getRoommasterbedlength()).isEqualTo(UPDATED_ROOMMASTERBEDLENGTH);
        assertThat(testResProperties.getRoomother1length()).isEqualTo(UPDATED_ROOMOTHER_1_LENGTH);
        assertThat(testResProperties.getOfficesellOfficenam2()).isEqualTo(UPDATED_OFFICESELL_OFFICENAM_2);
        assertThat(testResProperties.getLotsize()).isEqualTo(UPDATED_LOTSIZE);
        assertThat(testResProperties.getStreetdirsuffix()).isEqualTo(UPDATED_STREETDIRSUFFIX);
        assertThat(testResProperties.getPhotocount()).isEqualTo(UPDATED_PHOTOCOUNT);
        assertThat(testResProperties.getSchooldistrict()).isEqualTo(UPDATED_SCHOOLDISTRICT);
        assertThat(testResProperties.getStreetnum()).isEqualTo(UPDATED_STREETNUM);
        assertThat(testResProperties.getUtilities()).isEqualTo(UPDATED_UTILITIES);
        assertThat(testResProperties.getEquipment()).isEqualTo(UPDATED_EQUIPMENT);
        assertThat(testResProperties.getRoombed4width()).isEqualTo(UPDATED_ROOMBED_4_WIDTH);
        assertThat(testResProperties.getRoomkitchenlength()).isEqualTo(UPDATED_ROOMKITCHENLENGTH);
        assertThat(testResProperties.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testResProperties.getGaragedesc()).isEqualTo(UPDATED_GARAGEDESC);
        assertThat(testResProperties.getBathsfull()).isEqualTo(UPDATED_BATHSFULL);
        assertThat(testResProperties.getRoombed3width()).isEqualTo(UPDATED_ROOMBED_3_WIDTH);
        assertThat(testResProperties.getRoomutildesc()).isEqualTo(UPDATED_ROOMUTILDESC);
        assertThat(testResProperties.getRoomutilitywidth()).isEqualTo(UPDATED_ROOMUTILITYWIDTH);
        assertThat(testResProperties.getRoomfullbathlength()).isEqualTo(UPDATED_ROOMFULLBATHLENGTH);
        assertThat(testResProperties.getRoomfullbathwidth()).isEqualTo(UPDATED_ROOMFULLBATHWIDTH);
        assertThat(testResProperties.getRoomhalfbathlength()).isEqualTo(UPDATED_ROOMHALFBATHLENGTH);
        assertThat(testResProperties.getRoomhalfbathwidth()).isEqualTo(UPDATED_ROOMHALFBATHWIDTH);
        assertThat(testResProperties.getRoomexerciselength()).isEqualTo(UPDATED_ROOMEXERCISELENGTH);
        assertThat(testResProperties.getRoomexercisewidth()).isEqualTo(UPDATED_ROOMEXERCISEWIDTH);
        assertThat(testResProperties.getRoomstoragelength()).isEqualTo(UPDATED_ROOMSTORAGELENGTH);
        assertThat(testResProperties.getRoomstoragewidth()).isEqualTo(UPDATED_ROOMSTORAGEWIDTH);
        assertThat(testResProperties.getRoomgamelength()).isEqualTo(UPDATED_ROOMGAMELENGTH);
        assertThat(testResProperties.getRoomgamewidth()).isEqualTo(UPDATED_ROOMGAMEWIDTH);
        assertThat(testResProperties.getRoomguestlength()).isEqualTo(UPDATED_ROOMGUESTLENGTH);
        assertThat(testResProperties.getRoomguestwidth()).isEqualTo(UPDATED_ROOMGUESTWIDTH);
        assertThat(testResProperties.getRoomlibrarylength()).isEqualTo(UPDATED_ROOMLIBRARYLENGTH);
        assertThat(testResProperties.getRoomlibrarywidth()).isEqualTo(UPDATED_ROOMLIBRARYWIDTH);
        assertThat(testResProperties.getRoommedialength()).isEqualTo(UPDATED_ROOMMEDIALENGTH);
        assertThat(testResProperties.getRoommediawidth()).isEqualTo(UPDATED_ROOMMEDIAWIDTH);
        assertThat(testResProperties.getRoommudlength()).isEqualTo(UPDATED_ROOMMUDLENGTH);
        assertThat(testResProperties.getRoommudwidth()).isEqualTo(UPDATED_ROOMMUDWIDTH);
        assertThat(testResProperties.getRoomofficelength()).isEqualTo(UPDATED_ROOMOFFICELENGTH);
        assertThat(testResProperties.getRoomofficewidth()).isEqualTo(UPDATED_ROOMOFFICEWIDTH);
        assertThat(testResProperties.getRoomsaunalength()).isEqualTo(UPDATED_ROOMSAUNALENGTH);
        assertThat(testResProperties.getRoomsaunawidth()).isEqualTo(UPDATED_ROOMSAUNAWIDTH);
        assertThat(testResProperties.getRoomsecondmasterlength()).isEqualTo(UPDATED_ROOMSECONDMASTERLENGTH);
        assertThat(testResProperties.getRoomsecondmasterwidth()).isEqualTo(UPDATED_ROOMSECONDMASTERWIDTH);
        assertThat(testResProperties.getRoomsunlength()).isEqualTo(UPDATED_ROOMSUNLENGTH);
        assertThat(testResProperties.getRoomsunwidth()).isEqualTo(UPDATED_ROOMSUNWIDTH);
        assertThat(testResProperties.getRoomspalength()).isEqualTo(UPDATED_ROOMSPALENGTH);
        assertThat(testResProperties.getRoomspawidth()).isEqualTo(UPDATED_ROOMSPAWIDTH);
        assertThat(testResProperties.getRoomwinelength()).isEqualTo(UPDATED_ROOMWINELENGTH);
        assertThat(testResProperties.getRoomwinewidth()).isEqualTo(UPDATED_ROOMWINEWIDTH);
        assertThat(testResProperties.getJuniorhighschoolname()).isEqualTo(UPDATED_JUNIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getPrimaryschoolname()).isEqualTo(UPDATED_PRIMARYSCHOOLNAME);
        assertThat(testResProperties.getSeniorhighschoolname()).isEqualTo(UPDATED_SENIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getAssociationfee()).isEqualTo(UPDATED_ASSOCIATIONFEE);
        assertThat(testResProperties.getAssociationfeefrequency()).isEqualTo(UPDATED_ASSOCIATIONFEEFREQUENCY);
        assertThat(testResProperties.getConstructionmaterials()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALS);
        assertThat(testResProperties.getHeating()).isEqualTo(UPDATED_HEATING);
        assertThat(testResProperties.getAccessoryunittype()).isEqualTo(UPDATED_ACCESSORYUNITTYPE);
        assertThat(testResProperties.getAccessoryunityn()).isEqualTo(UPDATED_ACCESSORYUNITYN);
        assertThat(testResProperties.getFlooring()).isEqualTo(UPDATED_FLOORING);
        assertThat(testResProperties.getFireplacestotal()).isEqualTo(UPDATED_FIREPLACESTOTAL);
        assertThat(testResProperties.getFireplacefeatures()).isEqualTo(UPDATED_FIREPLACEFEATURES);
        assertThat(testResProperties.getSecuritysystemyn()).isEqualTo(UPDATED_SECURITYSYSTEMYN);
        assertThat(testResProperties.getGreenbuildingcertification()).isEqualTo(UPDATED_GREENBUILDINGCERTIFICATION);
        assertThat(testResProperties.getGreenenergyefficient()).isEqualTo(UPDATED_GREENENERGYEFFICIENT);
        assertThat(testResProperties.getEnergysavingfeatures()).isEqualTo(UPDATED_ENERGYSAVINGFEATURES);
        assertThat(testResProperties.getLotnumber()).isEqualTo(UPDATED_LOTNUMBER);
        assertThat(testResProperties.getLotsizearea()).isEqualTo(UPDATED_LOTSIZEAREA);
        assertThat(testResProperties.getLotsizedimensions()).isEqualTo(UPDATED_LOTSIZEDIMENSIONS);
        assertThat(testResProperties.getEasements()).isEqualTo(UPDATED_EASEMENTS);
        assertThat(testResProperties.getRestrictions()).isEqualTo(UPDATED_RESTRICTIONS);
        assertThat(testResProperties.getWasherdryerconnections()).isEqualTo(UPDATED_WASHERDRYERCONNECTIONS);
        assertThat(testResProperties.getMunicipalutilitydistrictyn()).isEqualTo(UPDATED_MUNICIPALUTILITYDISTRICTYN);
        assertThat(testResProperties.getAssociationfeeincludes()).isEqualTo(UPDATED_ASSOCIATIONFEEINCLUDES);
        assertThat(testResProperties.getAssociationtype()).isEqualTo(UPDATED_ASSOCIATIONTYPE);
        assertThat(testResProperties.getBarninformation()).isEqualTo(UPDATED_BARNINFORMATION);
        assertThat(testResProperties.getConstructionmaterialswalls()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALSWALLS);
        assertThat(testResProperties.getCountyorparish()).isEqualTo(UPDATED_COUNTYORPARISH);
        assertThat(testResProperties.getExteriorbuildings()).isEqualTo(UPDATED_EXTERIORBUILDINGS);
        assertThat(testResProperties.getFarmranchfeatures()).isEqualTo(UPDATED_FARMRANCHFEATURES);
        assertThat(testResProperties.getFencedyardyn()).isEqualTo(UPDATED_FENCEDYARDYN);
        assertThat(testResProperties.getFinancingproposed()).isEqualTo(UPDATED_FINANCINGPROPOSED);
        assertThat(testResProperties.getHandicapyn()).isEqualTo(UPDATED_HANDICAPYN);
        assertThat(testResProperties.getNumberoftanksandponds()).isEqualTo(UPDATED_NUMBEROFTANKSANDPONDS);
        assertThat(testResProperties.getParcelnumber()).isEqualTo(UPDATED_PARCELNUMBER);
        assertThat(testResProperties.getVirtualtoururlunbranded()).isEqualTo(UPDATED_VIRTUALTOURURLUNBRANDED);
        assertThat(testResProperties.getLivingRoomFeature()).isEqualTo(UPDATED_LIVING_ROOM_FEATURE);
        assertThat(testResProperties.getMasterBedRoomFeature()).isEqualTo(UPDATED_MASTER_BED_ROOM_FEATURE);
        assertThat(testResProperties.getBedRoomFeature()).isEqualTo(UPDATED_BED_ROOM_FEATURE);
        assertThat(testResProperties.getDiningRoomFeature()).isEqualTo(UPDATED_DINING_ROOM_FEATURE);
        assertThat(testResProperties.getKitchenRoomFeature()).isEqualTo(UPDATED_KITCHEN_ROOM_FEATURE);
        assertThat(testResProperties.getBreakfastRoomFeature()).isEqualTo(UPDATED_BREAKFAST_ROOM_FEATURE);
        assertThat(testResProperties.getStudyRoomFeature()).isEqualTo(UPDATED_STUDY_ROOM_FEATURE);
        assertThat(testResProperties.getUtilityRoomFeature()).isEqualTo(UPDATED_UTILITY_ROOM_FEATURE);
        assertThat(testResProperties.getFullBathRoomFeature()).isEqualTo(UPDATED_FULL_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getHalfBathRoomFeature()).isEqualTo(UPDATED_HALF_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getExerciseRoomFeature()).isEqualTo(UPDATED_EXERCISE_ROOM_FEATURE);
        assertThat(testResProperties.getExtraStorageRoomFeature()).isEqualTo(UPDATED_EXTRA_STORAGE_ROOM_FEATURE);
        assertThat(testResProperties.getGameRoomFeature()).isEqualTo(UPDATED_GAME_ROOM_FEATURE);
        assertThat(testResProperties.getGuestRoomFeature()).isEqualTo(UPDATED_GUEST_ROOM_FEATURE);
        assertThat(testResProperties.getLibraryRoomFeature()).isEqualTo(UPDATED_LIBRARY_ROOM_FEATURE);
        assertThat(testResProperties.getMediaRoomFeature()).isEqualTo(UPDATED_MEDIA_ROOM_FEATURE);
        assertThat(testResProperties.getMudRoomFeature()).isEqualTo(UPDATED_MUD_ROOM_FEATURE);
        assertThat(testResProperties.getOfficeRoomFeature()).isEqualTo(UPDATED_OFFICE_ROOM_FEATURE);
        assertThat(testResProperties.getSaunaRoomFeature()).isEqualTo(UPDATED_SAUNA_ROOM_FEATURE);
        assertThat(testResProperties.getSecondMasterRoomFeature()).isEqualTo(UPDATED_SECOND_MASTER_ROOM_FEATURE);
        assertThat(testResProperties.getSunroomRoomFeature()).isEqualTo(UPDATED_SUNROOM_ROOM_FEATURE);
        assertThat(testResProperties.getSpaRoomFeature()).isEqualTo(UPDATED_SPA_ROOM_FEATURE);
        assertThat(testResProperties.getWineRoomFeature()).isEqualTo(UPDATED_WINE_ROOM_FEATURE);
        assertThat(testResProperties.getOtherRoomFeature()).isEqualTo(UPDATED_OTHER_ROOM_FEATURE);
        assertThat(testResProperties.getIsLuxury()).isEqualTo(UPDATED_IS_LUXURY);
        assertThat(testResProperties.getIsMoveInReady()).isEqualTo(UPDATED_IS_MOVE_IN_READY);
        assertThat(testResProperties.getPhotoUrl()).isEqualTo(UPDATED_PHOTO_URL);
        assertThat(testResProperties.getPhoto1Url()).isEqualTo(UPDATED_PHOTO_1_URL);
        assertThat(testResProperties.getPhoto2Url()).isEqualTo(UPDATED_PHOTO_2_URL);
        assertThat(testResProperties.getPhoto3Url()).isEqualTo(UPDATED_PHOTO_3_URL);
        assertThat(testResProperties.getPhoto4Url()).isEqualTo(UPDATED_PHOTO_4_URL);
        assertThat(testResProperties.getPhoto5Url()).isEqualTo(UPDATED_PHOTO_5_URL);
        assertThat(testResProperties.getPhoto6Url()).isEqualTo(UPDATED_PHOTO_6_URL);
        assertThat(testResProperties.getPhoto7Url()).isEqualTo(UPDATED_PHOTO_7_URL);
        assertThat(testResProperties.getPhoto8Url()).isEqualTo(UPDATED_PHOTO_8_URL);
        assertThat(testResProperties.getPhoto9Url()).isEqualTo(UPDATED_PHOTO_9_URL);
        assertThat(testResProperties.getPhoto10Url()).isEqualTo(UPDATED_PHOTO_10_URL);
        assertThat(testResProperties.getPhoto11Url()).isEqualTo(UPDATED_PHOTO_11_URL);
        assertThat(testResProperties.getPhoto12Url()).isEqualTo(UPDATED_PHOTO_12_URL);
        assertThat(testResProperties.getPhoto13Url()).isEqualTo(UPDATED_PHOTO_13_URL);
        assertThat(testResProperties.getPhoto14Url()).isEqualTo(UPDATED_PHOTO_14_URL);
        assertThat(testResProperties.getPhoto15Url()).isEqualTo(UPDATED_PHOTO_15_URL);
        assertThat(testResProperties.getPhoto16Url()).isEqualTo(UPDATED_PHOTO_16_URL);
        assertThat(testResProperties.getPhoto17Url()).isEqualTo(UPDATED_PHOTO_17_URL);
        assertThat(testResProperties.getPhoto18Url()).isEqualTo(UPDATED_PHOTO_18_URL);
        assertThat(testResProperties.getPhoto19Url()).isEqualTo(UPDATED_PHOTO_19_URL);
        assertThat(testResProperties.getPhoto20Url()).isEqualTo(UPDATED_PHOTO_20_URL);
        assertThat(testResProperties.getPhoto21Url()).isEqualTo(UPDATED_PHOTO_21_URL);
        assertThat(testResProperties.getPhoto22Url()).isEqualTo(UPDATED_PHOTO_22_URL);
        assertThat(testResProperties.getPhoto23Url()).isEqualTo(UPDATED_PHOTO_23_URL);
        assertThat(testResProperties.getPhoto24Url()).isEqualTo(UPDATED_PHOTO_24_URL);
        assertThat(testResProperties.getPhoto25Url()).isEqualTo(UPDATED_PHOTO_25_URL);
        assertThat(testResProperties.getPhoto26Url()).isEqualTo(UPDATED_PHOTO_26_URL);
        assertThat(testResProperties.getPhoto27Url()).isEqualTo(UPDATED_PHOTO_27_URL);
        assertThat(testResProperties.getPhoto28Url()).isEqualTo(UPDATED_PHOTO_28_URL);
        assertThat(testResProperties.getPhoto29Url()).isEqualTo(UPDATED_PHOTO_29_URL);
        assertThat(testResProperties.getPhoto30Url()).isEqualTo(UPDATED_PHOTO_30_URL);
        assertThat(testResProperties.getPhoto31Url()).isEqualTo(UPDATED_PHOTO_31_URL);
        assertThat(testResProperties.getPhoto32Url()).isEqualTo(UPDATED_PHOTO_32_URL);
        assertThat(testResProperties.getPhoto33Url()).isEqualTo(UPDATED_PHOTO_33_URL);
        assertThat(testResProperties.getPhoto34Url()).isEqualTo(UPDATED_PHOTO_34_URL);
        assertThat(testResProperties.getPhoto35Url()).isEqualTo(UPDATED_PHOTO_35_URL);
        assertThat(testResProperties.getPhoto36Url()).isEqualTo(UPDATED_PHOTO_36_URL);
        assertThat(testResProperties.getPhoto37Url()).isEqualTo(UPDATED_PHOTO_37_URL);
        assertThat(testResProperties.getPhoto38Url()).isEqualTo(UPDATED_PHOTO_38_URL);
        assertThat(testResProperties.getPhoto39Url()).isEqualTo(UPDATED_PHOTO_39_URL);
        assertThat(testResProperties.getPhoto40Url()).isEqualTo(UPDATED_PHOTO_40_URL);
        assertThat(testResProperties.getCreated()).isEqualTo(UPDATED_CREATED);
        assertThat(testResProperties.getUpdated()).isEqualTo(UPDATED_UPDATED);
        assertThat(testResProperties.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
        assertThat(testResProperties.getImgDeleted()).isEqualTo(UPDATED_IMG_DELETED);
        assertThat(testResProperties.getRetsServer()).isEqualTo(UPDATED_RETS_SERVER);
        assertThat(testResProperties.getPermalink()).isEqualTo(UPDATED_PERMALINK);
        assertThat(testResProperties.getPropertyTag()).isEqualTo(UPDATED_PROPERTY_TAG);
        assertThat(testResProperties.getBuildentoryViews()).isEqualTo(UPDATED_BUILDENTORY_VIEWS);
        assertThat(testResProperties.getLocation()).isEqualTo(UPDATED_LOCATION);
    }

    @Test
    @Transactional
    void putNonExistingResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(
                put(ENTITY_API_URL_ID, resProperties.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(resProperties))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(resProperties))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(resProperties)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateResPropertiesWithPatch() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();

        // Update the resProperties using partial update
        ResProperties partialUpdatedResProperties = new ResProperties();
        partialUpdatedResProperties.setId(resProperties.getId());

        partialUpdatedResProperties
            .communityId(UPDATED_COMMUNITY_ID)
            .communityName(UPDATED_COMMUNITY_NAME)
            .builderId(UPDATED_BUILDER_ID)
            .longitude(UPDATED_LONGITUDE)
            .county(UPDATED_COUNTY)
            .carportcap(UPDATED_CARPORTCAP)
            .possession(UPDATED_POSSESSION)
            .schoolname1(UPDATED_SCHOOLNAME_1)
            .vowavmyn(UPDATED_VOWAVMYN)
            .presentuse(UPDATED_PRESENTUSE)
            .proposeduse(UPDATED_PROPOSEDUSE)
            .roomliving2width(UPDATED_ROOMLIVING_2_WIDTH)
            .roomstudylevel(UPDATED_ROOMSTUDYLEVEL)
            .area(UPDATED_AREA)
            .areatitle(UPDATED_AREATITLE)
            .assocfee(UPDATED_ASSOCFEE)
            .mapcoord(UPDATED_MAPCOORD)
            .roomgaragewidth(UPDATED_ROOMGARAGEWIDTH)
            .roomother2width(UPDATED_ROOMOTHER_2_WIDTH)
            .sqfttotal(UPDATED_SQFTTOTAL)
            .schoolname3(UPDATED_SCHOOLNAME_3)
            .zipcode(UPDATED_ZIPCODE)
            .barn1length(UPDATED_BARN_1_LENGTH)
            .barn3width(UPDATED_BARN_3_WIDTH)
            .roombed2length(UPDATED_ROOMBED_2_LENGTH)
            .agentlistFullname(UPDATED_AGENTLIST_FULLNAME)
            .proptype(UPDATED_PROPTYPE)
            .mlsProptype(UPDATED_MLS_PROPTYPE)
            .acrescultivated(UPDATED_ACRESCULTIVATED)
            .barn2width(UPDATED_BARN_2_WIDTH)
            .roombedbathdesc(UPDATED_ROOMBEDBATHDESC)
            .subdivision(UPDATED_SUBDIVISION)
            .yearbuilt(UPDATED_YEARBUILT)
            .yearbuiltdetails(UPDATED_YEARBUILTDETAILS)
            .agexemption(UPDATED_AGEXEMPTION)
            .roomdiningwidth(UPDATED_ROOMDININGWIDTH)
            .soiltype(UPDATED_SOILTYPE)
            .appraisername(UPDATED_APPRAISERNAME)
            .unitnumber(UPDATED_UNITNUMBER)
            .streetdir(UPDATED_STREETDIR)
            .streettype(UPDATED_STREETTYPE)
            .subareatitle(UPDATED_SUBAREATITLE)
            .propsubtype(UPDATED_PROPSUBTYPE)
            .beds(UPDATED_BEDS)
            .roommasterbedwidth(UPDATED_ROOMMASTERBEDWIDTH)
            .roomstudylength(UPDATED_ROOMSTUDYLENGTH)
            .roombreakfastlength(UPDATED_ROOMBREAKFASTLENGTH)
            .garagecap(UPDATED_GARAGECAP)
            .sqftprice(UPDATED_SQFTPRICE)
            .foundation(UPDATED_FOUNDATION)
            .poolyn(UPDATED_POOLYN)
            .poolFeature(UPDATED_POOL_FEATURE)
            .listprice(UPDATED_LISTPRICE)
            .listpricerange(UPDATED_LISTPRICERANGE)
            .roof(UPDATED_ROOF)
            .securityfeatures(UPDATED_SECURITYFEATURES)
            .stories(UPDATED_STORIES)
            .roomliving1length(UPDATED_ROOMLIVING_1_LENGTH)
            .openhousetime(UPDATED_OPENHOUSETIME)
            .roomliving2length(UPDATED_ROOMLIVING_2_LENGTH)
            .lotdesc(UPDATED_LOTDESC)
            .officesellOfficenam2(UPDATED_OFFICESELL_OFFICENAM_2)
            .streetdirsuffix(UPDATED_STREETDIRSUFFIX)
            .schooldistrict(UPDATED_SCHOOLDISTRICT)
            .utilities(UPDATED_UTILITIES)
            .equipment(UPDATED_EQUIPMENT)
            .roomkitchenlength(UPDATED_ROOMKITCHENLENGTH)
            .city(UPDATED_CITY)
            .roombed3width(UPDATED_ROOMBED_3_WIDTH)
            .roomutildesc(UPDATED_ROOMUTILDESC)
            .roomfullbathlength(UPDATED_ROOMFULLBATHLENGTH)
            .roomfullbathwidth(UPDATED_ROOMFULLBATHWIDTH)
            .roomexercisewidth(UPDATED_ROOMEXERCISEWIDTH)
            .roomstoragewidth(UPDATED_ROOMSTORAGEWIDTH)
            .roomgamewidth(UPDATED_ROOMGAMEWIDTH)
            .roomguestlength(UPDATED_ROOMGUESTLENGTH)
            .roomguestwidth(UPDATED_ROOMGUESTWIDTH)
            .roomlibrarywidth(UPDATED_ROOMLIBRARYWIDTH)
            .roommedialength(UPDATED_ROOMMEDIALENGTH)
            .roommediawidth(UPDATED_ROOMMEDIAWIDTH)
            .roommudlength(UPDATED_ROOMMUDLENGTH)
            .roommudwidth(UPDATED_ROOMMUDWIDTH)
            .roomsecondmasterwidth(UPDATED_ROOMSECONDMASTERWIDTH)
            .roomsunlength(UPDATED_ROOMSUNLENGTH)
            .roomsunwidth(UPDATED_ROOMSUNWIDTH)
            .roomwinelength(UPDATED_ROOMWINELENGTH)
            .seniorhighschoolname(UPDATED_SENIORHIGHSCHOOLNAME)
            .constructionmaterials(UPDATED_CONSTRUCTIONMATERIALS)
            .heating(UPDATED_HEATING)
            .accessoryunityn(UPDATED_ACCESSORYUNITYN)
            .fireplacefeatures(UPDATED_FIREPLACEFEATURES)
            .securitysystemyn(UPDATED_SECURITYSYSTEMYN)
            .greenbuildingcertification(UPDATED_GREENBUILDINGCERTIFICATION)
            .greenenergyefficient(UPDATED_GREENENERGYEFFICIENT)
            .lotnumber(UPDATED_LOTNUMBER)
            .lotsizearea(UPDATED_LOTSIZEAREA)
            .lotsizedimensions(UPDATED_LOTSIZEDIMENSIONS)
            .easements(UPDATED_EASEMENTS)
            .washerdryerconnections(UPDATED_WASHERDRYERCONNECTIONS)
            .associationfeeincludes(UPDATED_ASSOCIATIONFEEINCLUDES)
            .barninformation(UPDATED_BARNINFORMATION)
            .constructionmaterialswalls(UPDATED_CONSTRUCTIONMATERIALSWALLS)
            .numberoftanksandponds(UPDATED_NUMBEROFTANKSANDPONDS)
            .livingRoomFeature(UPDATED_LIVING_ROOM_FEATURE)
            .masterBedRoomFeature(UPDATED_MASTER_BED_ROOM_FEATURE)
            .bedRoomFeature(UPDATED_BED_ROOM_FEATURE)
            .diningRoomFeature(UPDATED_DINING_ROOM_FEATURE)
            .breakfastRoomFeature(UPDATED_BREAKFAST_ROOM_FEATURE)
            .fullBathRoomFeature(UPDATED_FULL_BATH_ROOM_FEATURE)
            .halfBathRoomFeature(UPDATED_HALF_BATH_ROOM_FEATURE)
            .exerciseRoomFeature(UPDATED_EXERCISE_ROOM_FEATURE)
            .extraStorageRoomFeature(UPDATED_EXTRA_STORAGE_ROOM_FEATURE)
            .gameRoomFeature(UPDATED_GAME_ROOM_FEATURE)
            .guestRoomFeature(UPDATED_GUEST_ROOM_FEATURE)
            .libraryRoomFeature(UPDATED_LIBRARY_ROOM_FEATURE)
            .mediaRoomFeature(UPDATED_MEDIA_ROOM_FEATURE)
            .mudRoomFeature(UPDATED_MUD_ROOM_FEATURE)
            .officeRoomFeature(UPDATED_OFFICE_ROOM_FEATURE)
            .saunaRoomFeature(UPDATED_SAUNA_ROOM_FEATURE)
            .spaRoomFeature(UPDATED_SPA_ROOM_FEATURE)
            .otherRoomFeature(UPDATED_OTHER_ROOM_FEATURE)
            .isLuxury(UPDATED_IS_LUXURY)
            .isMoveInReady(UPDATED_IS_MOVE_IN_READY)
            .photoUrl(UPDATED_PHOTO_URL)
            .photo2Url(UPDATED_PHOTO_2_URL)
            .photo3Url(UPDATED_PHOTO_3_URL)
            .photo4Url(UPDATED_PHOTO_4_URL)
            .photo6Url(UPDATED_PHOTO_6_URL)
            .photo7Url(UPDATED_PHOTO_7_URL)
            .photo9Url(UPDATED_PHOTO_9_URL)
            .photo11Url(UPDATED_PHOTO_11_URL)
            .photo12Url(UPDATED_PHOTO_12_URL)
            .photo14Url(UPDATED_PHOTO_14_URL)
            .photo15Url(UPDATED_PHOTO_15_URL)
            .photo23Url(UPDATED_PHOTO_23_URL)
            .photo24Url(UPDATED_PHOTO_24_URL)
            .photo25Url(UPDATED_PHOTO_25_URL)
            .photo30Url(UPDATED_PHOTO_30_URL)
            .photo31Url(UPDATED_PHOTO_31_URL)
            .photo33Url(UPDATED_PHOTO_33_URL)
            .photo34Url(UPDATED_PHOTO_34_URL)
            .photo36Url(UPDATED_PHOTO_36_URL)
            .photo37Url(UPDATED_PHOTO_37_URL)
            .updated(UPDATED_UPDATED)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .permalink(UPDATED_PERMALINK)
            .buildentoryViews(UPDATED_BUILDENTORY_VIEWS)
            .location(UPDATED_LOCATION);

        restResPropertiesMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResProperties.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedResProperties))
            )
            .andExpect(status().isOk());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
        ResProperties testResProperties = resPropertiesList.get(resPropertiesList.size() - 1);
        assertThat(testResProperties.getCommunityId()).isEqualTo(UPDATED_COMMUNITY_ID);
        assertThat(testResProperties.getCommunityName()).isEqualTo(UPDATED_COMMUNITY_NAME);
        assertThat(testResProperties.getBuilderId()).isEqualTo(UPDATED_BUILDER_ID);
        assertThat(testResProperties.getSpecialOffers()).isEqualTo(DEFAULT_SPECIAL_OFFERS);
        assertThat(testResProperties.getBrochure()).isEqualTo(DEFAULT_BROCHURE);
        assertThat(testResProperties.getFloorPlanId()).isEqualTo(DEFAULT_FLOOR_PLAN_ID);
        assertThat(testResProperties.getLatitude()).isEqualTo(DEFAULT_LATITUDE);
        assertThat(testResProperties.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testResProperties.getCounty()).isEqualTo(UPDATED_COUNTY);
        assertThat(testResProperties.getHeatsystem()).isEqualTo(DEFAULT_HEATSYSTEM);
        assertThat(testResProperties.getListstatus()).isEqualTo(DEFAULT_LISTSTATUS);
        assertThat(testResProperties.getListstatusflag()).isEqualTo(DEFAULT_LISTSTATUSFLAG);
        assertThat(testResProperties.getCarportcap()).isEqualTo(UPDATED_CARPORTCAP);
        assertThat(testResProperties.getPossession()).isEqualTo(UPDATED_POSSESSION);
        assertThat(testResProperties.getSchoolname1()).isEqualTo(UPDATED_SCHOOLNAME_1);
        assertThat(testResProperties.getSubdivide()).isEqualTo(DEFAULT_SUBDIVIDE);
        assertThat(testResProperties.getVowavmyn()).isEqualTo(UPDATED_VOWAVMYN);
        assertThat(testResProperties.getPresentuse()).isEqualTo(UPDATED_PRESENTUSE);
        assertThat(testResProperties.getProposeduse()).isEqualTo(UPDATED_PROPOSEDUSE);
        assertThat(testResProperties.getRanchname()).isEqualTo(DEFAULT_RANCHNAME);
        assertThat(testResProperties.getRoombed2width()).isEqualTo(DEFAULT_ROOMBED_2_WIDTH);
        assertThat(testResProperties.getRoomdininglevel()).isEqualTo(DEFAULT_ROOMDININGLEVEL);
        assertThat(testResProperties.getRoomliving2width()).isEqualTo(UPDATED_ROOMLIVING_2_WIDTH);
        assertThat(testResProperties.getRoomstudylevel()).isEqualTo(UPDATED_ROOMSTUDYLEVEL);
        assertThat(testResProperties.getArea()).isEqualTo(UPDATED_AREA);
        assertThat(testResProperties.getAreatitle()).isEqualTo(UPDATED_AREATITLE);
        assertThat(testResProperties.getAssocfee()).isEqualTo(UPDATED_ASSOCFEE);
        assertThat(testResProperties.getFinanceproposed()).isEqualTo(DEFAULT_FINANCEPROPOSED);
        assertThat(testResProperties.getListpriceorig()).isEqualTo(DEFAULT_LISTPRICEORIG);
        assertThat(testResProperties.getMapcoord()).isEqualTo(UPDATED_MAPCOORD);
        assertThat(testResProperties.getSchoolname2()).isEqualTo(DEFAULT_SCHOOLNAME_2);
        assertThat(testResProperties.getRoomgaragewidth()).isEqualTo(UPDATED_ROOMGARAGEWIDTH);
        assertThat(testResProperties.getRoomkitchendesc()).isEqualTo(DEFAULT_ROOMKITCHENDESC);
        assertThat(testResProperties.getRoomliving1width()).isEqualTo(DEFAULT_ROOMLIVING_1_WIDTH);
        assertThat(testResProperties.getRoomother2width()).isEqualTo(UPDATED_ROOMOTHER_2_WIDTH);
        assertThat(testResProperties.getSqfttotal()).isEqualTo(UPDATED_SQFTTOTAL);
        assertThat(testResProperties.getOfficelistOfficenam1()).isEqualTo(DEFAULT_OFFICELIST_OFFICENAM_1);
        assertThat(testResProperties.getSchoolname3()).isEqualTo(UPDATED_SCHOOLNAME_3);
        assertThat(testResProperties.getZipcode()).isEqualTo(UPDATED_ZIPCODE);
        assertThat(testResProperties.getBarn1length()).isEqualTo(UPDATED_BARN_1_LENGTH);
        assertThat(testResProperties.getBarn3width()).isEqualTo(UPDATED_BARN_3_WIDTH);
        assertThat(testResProperties.getRoombed2length()).isEqualTo(UPDATED_ROOMBED_2_LENGTH);
        assertThat(testResProperties.getRoombed3length()).isEqualTo(DEFAULT_ROOMBED_3_LENGTH);
        assertThat(testResProperties.getRoomother1width()).isEqualTo(DEFAULT_ROOMOTHER_1_WIDTH);
        assertThat(testResProperties.getAgentlistFullname()).isEqualTo(UPDATED_AGENTLIST_FULLNAME);
        assertThat(testResProperties.getProptype()).isEqualTo(UPDATED_PROPTYPE);
        assertThat(testResProperties.getMlsProptype()).isEqualTo(UPDATED_MLS_PROPTYPE);
        assertThat(testResProperties.getSchoolname4()).isEqualTo(DEFAULT_SCHOOLNAME_4);
        assertThat(testResProperties.getAcrescultivated()).isEqualByComparingTo(UPDATED_ACRESCULTIVATED);
        assertThat(testResProperties.getBarn2length()).isEqualTo(DEFAULT_BARN_2_LENGTH);
        assertThat(testResProperties.getBarn2width()).isEqualTo(UPDATED_BARN_2_WIDTH);
        assertThat(testResProperties.getComplexname()).isEqualTo(DEFAULT_COMPLEXNAME);
        assertThat(testResProperties.getRoombed4length()).isEqualTo(DEFAULT_ROOMBED_4_LENGTH);
        assertThat(testResProperties.getRoombedbathdesc()).isEqualTo(UPDATED_ROOMBEDBATHDESC);
        assertThat(testResProperties.getRoombreakfastwidth()).isEqualTo(DEFAULT_ROOMBREAKFASTWIDTH);
        assertThat(testResProperties.getRoomother()).isEqualTo(DEFAULT_ROOMOTHER);
        assertThat(testResProperties.getRoomutilitylength()).isEqualTo(DEFAULT_ROOMUTILITYLENGTH);
        assertThat(testResProperties.getAcres()).isEqualByComparingTo(DEFAULT_ACRES);
        assertThat(testResProperties.getBlock()).isEqualTo(DEFAULT_BLOCK);
        assertThat(testResProperties.getDirections()).isEqualTo(DEFAULT_DIRECTIONS);
        assertThat(testResProperties.getSubdivision()).isEqualTo(UPDATED_SUBDIVISION);
        assertThat(testResProperties.getYearbuilt()).isEqualTo(UPDATED_YEARBUILT);
        assertThat(testResProperties.getYearbuiltdetails()).isEqualTo(UPDATED_YEARBUILTDETAILS);
        assertThat(testResProperties.getAgexemption()).isEqualTo(UPDATED_AGEXEMPTION);
        assertThat(testResProperties.getBarn1width()).isEqualTo(DEFAULT_BARN_1_WIDTH);
        assertThat(testResProperties.getBarn3length()).isEqualTo(DEFAULT_BARN_3_LENGTH);
        assertThat(testResProperties.getRoomdiningwidth()).isEqualTo(UPDATED_ROOMDININGWIDTH);
        assertThat(testResProperties.getRoomstudywidth()).isEqualTo(DEFAULT_ROOMSTUDYWIDTH);
        assertThat(testResProperties.getSoiltype()).isEqualTo(UPDATED_SOILTYPE);
        assertThat(testResProperties.getAppraisername()).isEqualTo(UPDATED_APPRAISERNAME);
        assertThat(testResProperties.getListpricelow()).isEqualTo(DEFAULT_LISTPRICELOW);
        assertThat(testResProperties.getMappage()).isEqualTo(DEFAULT_MAPPAGE);
        assertThat(testResProperties.getUnitnumber()).isEqualTo(UPDATED_UNITNUMBER);
        assertThat(testResProperties.getStreetdir()).isEqualTo(UPDATED_STREETDIR);
        assertThat(testResProperties.getStreettype()).isEqualTo(UPDATED_STREETTYPE);
        assertThat(testResProperties.getSubarea()).isEqualTo(DEFAULT_SUBAREA);
        assertThat(testResProperties.getSubareatitle()).isEqualTo(UPDATED_SUBAREATITLE);
        assertThat(testResProperties.getBathshalf()).isEqualTo(DEFAULT_BATHSHALF);
        assertThat(testResProperties.getRoomgaragelength()).isEqualTo(DEFAULT_ROOMGARAGELENGTH);
        assertThat(testResProperties.getPropsubtype()).isEqualTo(UPDATED_PROPSUBTYPE);
        assertThat(testResProperties.getBeds()).isEqualTo(UPDATED_BEDS);
        assertThat(testResProperties.getRoommasterbedwidth()).isEqualTo(UPDATED_ROOMMASTERBEDWIDTH);
        assertThat(testResProperties.getRoomstudylength()).isEqualTo(UPDATED_ROOMSTUDYLENGTH);
        assertThat(testResProperties.getAgentlist()).isEqualTo(DEFAULT_AGENTLIST);
        assertThat(testResProperties.getStreetname()).isEqualTo(DEFAULT_STREETNAME);
        assertThat(testResProperties.getRoombreakfastlength()).isEqualTo(UPDATED_ROOMBREAKFASTLENGTH);
        assertThat(testResProperties.getRoomkitchenwidth()).isEqualTo(DEFAULT_ROOMKITCHENWIDTH);
        assertThat(testResProperties.getFence()).isEqualTo(DEFAULT_FENCE);
        assertThat(testResProperties.getBathstotal()).isEqualByComparingTo(DEFAULT_BATHSTOTAL);
        assertThat(testResProperties.getGaragecap()).isEqualTo(UPDATED_GARAGECAP);
        assertThat(testResProperties.getSqftprice()).isEqualByComparingTo(UPDATED_SQFTPRICE);
        assertThat(testResProperties.getStyle()).isEqualTo(DEFAULT_STYLE);
        assertThat(testResProperties.getExterior()).isEqualTo(DEFAULT_EXTERIOR);
        assertThat(testResProperties.getFoundation()).isEqualTo(UPDATED_FOUNDATION);
        assertThat(testResProperties.getInterior()).isEqualTo(DEFAULT_INTERIOR);
        assertThat(testResProperties.getPoolyn()).isEqualTo(UPDATED_POOLYN);
        assertThat(testResProperties.getPoolFeature()).isEqualTo(UPDATED_POOL_FEATURE);
        assertThat(testResProperties.getListprice()).isEqualTo(UPDATED_LISTPRICE);
        assertThat(testResProperties.getListpricerange()).isEqualTo(UPDATED_LISTPRICERANGE);
        assertThat(testResProperties.getMlsnum()).isEqualTo(DEFAULT_MLSNUM);
        assertThat(testResProperties.getMatrixid()).isEqualTo(DEFAULT_MATRIXID);
        assertThat(testResProperties.getRemarks()).isEqualTo(DEFAULT_REMARKS);
        assertThat(testResProperties.getState()).isEqualTo(DEFAULT_STATE);
        assertThat(testResProperties.getRoof()).isEqualTo(UPDATED_ROOF);
        assertThat(testResProperties.getSecurityfeatures()).isEqualTo(UPDATED_SECURITYFEATURES);
        assertThat(testResProperties.getUtilitiesother()).isEqualTo(DEFAULT_UTILITIESOTHER);
        assertThat(testResProperties.getCommonfeatures()).isEqualTo(DEFAULT_COMMONFEATURES);
        assertThat(testResProperties.getConstruction()).isEqualTo(DEFAULT_CONSTRUCTION);
        assertThat(testResProperties.getModified()).isEqualTo(DEFAULT_MODIFIED);
        assertThat(testResProperties.getStories()).isEqualTo(UPDATED_STORIES);
        assertThat(testResProperties.getRoomdininglength()).isEqualTo(DEFAULT_ROOMDININGLENGTH);
        assertThat(testResProperties.getRoomliving1length()).isEqualTo(UPDATED_ROOMLIVING_1_LENGTH);
        assertThat(testResProperties.getOpenhousetime()).isEqualTo(UPDATED_OPENHOUSETIME);
        assertThat(testResProperties.getOpenhouseendtime()).isEqualTo(DEFAULT_OPENHOUSEENDTIME);
        assertThat(testResProperties.getRoomliving2length()).isEqualTo(UPDATED_ROOMLIVING_2_LENGTH);
        assertThat(testResProperties.getLotdesc()).isEqualTo(UPDATED_LOTDESC);
        assertThat(testResProperties.getOpenhousedate()).isEqualTo(DEFAULT_OPENHOUSEDATE);
        assertThat(testResProperties.getRoommasterbedlength()).isEqualTo(DEFAULT_ROOMMASTERBEDLENGTH);
        assertThat(testResProperties.getRoomother1length()).isEqualTo(DEFAULT_ROOMOTHER_1_LENGTH);
        assertThat(testResProperties.getOfficesellOfficenam2()).isEqualTo(UPDATED_OFFICESELL_OFFICENAM_2);
        assertThat(testResProperties.getLotsize()).isEqualTo(DEFAULT_LOTSIZE);
        assertThat(testResProperties.getStreetdirsuffix()).isEqualTo(UPDATED_STREETDIRSUFFIX);
        assertThat(testResProperties.getPhotocount()).isEqualTo(DEFAULT_PHOTOCOUNT);
        assertThat(testResProperties.getSchooldistrict()).isEqualTo(UPDATED_SCHOOLDISTRICT);
        assertThat(testResProperties.getStreetnum()).isEqualTo(DEFAULT_STREETNUM);
        assertThat(testResProperties.getUtilities()).isEqualTo(UPDATED_UTILITIES);
        assertThat(testResProperties.getEquipment()).isEqualTo(UPDATED_EQUIPMENT);
        assertThat(testResProperties.getRoombed4width()).isEqualTo(DEFAULT_ROOMBED_4_WIDTH);
        assertThat(testResProperties.getRoomkitchenlength()).isEqualTo(UPDATED_ROOMKITCHENLENGTH);
        assertThat(testResProperties.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testResProperties.getGaragedesc()).isEqualTo(DEFAULT_GARAGEDESC);
        assertThat(testResProperties.getBathsfull()).isEqualTo(DEFAULT_BATHSFULL);
        assertThat(testResProperties.getRoombed3width()).isEqualTo(UPDATED_ROOMBED_3_WIDTH);
        assertThat(testResProperties.getRoomutildesc()).isEqualTo(UPDATED_ROOMUTILDESC);
        assertThat(testResProperties.getRoomutilitywidth()).isEqualTo(DEFAULT_ROOMUTILITYWIDTH);
        assertThat(testResProperties.getRoomfullbathlength()).isEqualTo(UPDATED_ROOMFULLBATHLENGTH);
        assertThat(testResProperties.getRoomfullbathwidth()).isEqualTo(UPDATED_ROOMFULLBATHWIDTH);
        assertThat(testResProperties.getRoomhalfbathlength()).isEqualTo(DEFAULT_ROOMHALFBATHLENGTH);
        assertThat(testResProperties.getRoomhalfbathwidth()).isEqualTo(DEFAULT_ROOMHALFBATHWIDTH);
        assertThat(testResProperties.getRoomexerciselength()).isEqualTo(DEFAULT_ROOMEXERCISELENGTH);
        assertThat(testResProperties.getRoomexercisewidth()).isEqualTo(UPDATED_ROOMEXERCISEWIDTH);
        assertThat(testResProperties.getRoomstoragelength()).isEqualTo(DEFAULT_ROOMSTORAGELENGTH);
        assertThat(testResProperties.getRoomstoragewidth()).isEqualTo(UPDATED_ROOMSTORAGEWIDTH);
        assertThat(testResProperties.getRoomgamelength()).isEqualTo(DEFAULT_ROOMGAMELENGTH);
        assertThat(testResProperties.getRoomgamewidth()).isEqualTo(UPDATED_ROOMGAMEWIDTH);
        assertThat(testResProperties.getRoomguestlength()).isEqualTo(UPDATED_ROOMGUESTLENGTH);
        assertThat(testResProperties.getRoomguestwidth()).isEqualTo(UPDATED_ROOMGUESTWIDTH);
        assertThat(testResProperties.getRoomlibrarylength()).isEqualTo(DEFAULT_ROOMLIBRARYLENGTH);
        assertThat(testResProperties.getRoomlibrarywidth()).isEqualTo(UPDATED_ROOMLIBRARYWIDTH);
        assertThat(testResProperties.getRoommedialength()).isEqualTo(UPDATED_ROOMMEDIALENGTH);
        assertThat(testResProperties.getRoommediawidth()).isEqualTo(UPDATED_ROOMMEDIAWIDTH);
        assertThat(testResProperties.getRoommudlength()).isEqualTo(UPDATED_ROOMMUDLENGTH);
        assertThat(testResProperties.getRoommudwidth()).isEqualTo(UPDATED_ROOMMUDWIDTH);
        assertThat(testResProperties.getRoomofficelength()).isEqualTo(DEFAULT_ROOMOFFICELENGTH);
        assertThat(testResProperties.getRoomofficewidth()).isEqualTo(DEFAULT_ROOMOFFICEWIDTH);
        assertThat(testResProperties.getRoomsaunalength()).isEqualTo(DEFAULT_ROOMSAUNALENGTH);
        assertThat(testResProperties.getRoomsaunawidth()).isEqualTo(DEFAULT_ROOMSAUNAWIDTH);
        assertThat(testResProperties.getRoomsecondmasterlength()).isEqualTo(DEFAULT_ROOMSECONDMASTERLENGTH);
        assertThat(testResProperties.getRoomsecondmasterwidth()).isEqualTo(UPDATED_ROOMSECONDMASTERWIDTH);
        assertThat(testResProperties.getRoomsunlength()).isEqualTo(UPDATED_ROOMSUNLENGTH);
        assertThat(testResProperties.getRoomsunwidth()).isEqualTo(UPDATED_ROOMSUNWIDTH);
        assertThat(testResProperties.getRoomspalength()).isEqualTo(DEFAULT_ROOMSPALENGTH);
        assertThat(testResProperties.getRoomspawidth()).isEqualTo(DEFAULT_ROOMSPAWIDTH);
        assertThat(testResProperties.getRoomwinelength()).isEqualTo(UPDATED_ROOMWINELENGTH);
        assertThat(testResProperties.getRoomwinewidth()).isEqualTo(DEFAULT_ROOMWINEWIDTH);
        assertThat(testResProperties.getJuniorhighschoolname()).isEqualTo(DEFAULT_JUNIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getPrimaryschoolname()).isEqualTo(DEFAULT_PRIMARYSCHOOLNAME);
        assertThat(testResProperties.getSeniorhighschoolname()).isEqualTo(UPDATED_SENIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getAssociationfee()).isEqualTo(DEFAULT_ASSOCIATIONFEE);
        assertThat(testResProperties.getAssociationfeefrequency()).isEqualTo(DEFAULT_ASSOCIATIONFEEFREQUENCY);
        assertThat(testResProperties.getConstructionmaterials()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALS);
        assertThat(testResProperties.getHeating()).isEqualTo(UPDATED_HEATING);
        assertThat(testResProperties.getAccessoryunittype()).isEqualTo(DEFAULT_ACCESSORYUNITTYPE);
        assertThat(testResProperties.getAccessoryunityn()).isEqualTo(UPDATED_ACCESSORYUNITYN);
        assertThat(testResProperties.getFlooring()).isEqualTo(DEFAULT_FLOORING);
        assertThat(testResProperties.getFireplacestotal()).isEqualTo(DEFAULT_FIREPLACESTOTAL);
        assertThat(testResProperties.getFireplacefeatures()).isEqualTo(UPDATED_FIREPLACEFEATURES);
        assertThat(testResProperties.getSecuritysystemyn()).isEqualTo(UPDATED_SECURITYSYSTEMYN);
        assertThat(testResProperties.getGreenbuildingcertification()).isEqualTo(UPDATED_GREENBUILDINGCERTIFICATION);
        assertThat(testResProperties.getGreenenergyefficient()).isEqualTo(UPDATED_GREENENERGYEFFICIENT);
        assertThat(testResProperties.getEnergysavingfeatures()).isEqualTo(DEFAULT_ENERGYSAVINGFEATURES);
        assertThat(testResProperties.getLotnumber()).isEqualTo(UPDATED_LOTNUMBER);
        assertThat(testResProperties.getLotsizearea()).isEqualTo(UPDATED_LOTSIZEAREA);
        assertThat(testResProperties.getLotsizedimensions()).isEqualTo(UPDATED_LOTSIZEDIMENSIONS);
        assertThat(testResProperties.getEasements()).isEqualTo(UPDATED_EASEMENTS);
        assertThat(testResProperties.getRestrictions()).isEqualTo(DEFAULT_RESTRICTIONS);
        assertThat(testResProperties.getWasherdryerconnections()).isEqualTo(UPDATED_WASHERDRYERCONNECTIONS);
        assertThat(testResProperties.getMunicipalutilitydistrictyn()).isEqualTo(DEFAULT_MUNICIPALUTILITYDISTRICTYN);
        assertThat(testResProperties.getAssociationfeeincludes()).isEqualTo(UPDATED_ASSOCIATIONFEEINCLUDES);
        assertThat(testResProperties.getAssociationtype()).isEqualTo(DEFAULT_ASSOCIATIONTYPE);
        assertThat(testResProperties.getBarninformation()).isEqualTo(UPDATED_BARNINFORMATION);
        assertThat(testResProperties.getConstructionmaterialswalls()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALSWALLS);
        assertThat(testResProperties.getCountyorparish()).isEqualTo(DEFAULT_COUNTYORPARISH);
        assertThat(testResProperties.getExteriorbuildings()).isEqualTo(DEFAULT_EXTERIORBUILDINGS);
        assertThat(testResProperties.getFarmranchfeatures()).isEqualTo(DEFAULT_FARMRANCHFEATURES);
        assertThat(testResProperties.getFencedyardyn()).isEqualTo(DEFAULT_FENCEDYARDYN);
        assertThat(testResProperties.getFinancingproposed()).isEqualTo(DEFAULT_FINANCINGPROPOSED);
        assertThat(testResProperties.getHandicapyn()).isEqualTo(DEFAULT_HANDICAPYN);
        assertThat(testResProperties.getNumberoftanksandponds()).isEqualTo(UPDATED_NUMBEROFTANKSANDPONDS);
        assertThat(testResProperties.getParcelnumber()).isEqualTo(DEFAULT_PARCELNUMBER);
        assertThat(testResProperties.getVirtualtoururlunbranded()).isEqualTo(DEFAULT_VIRTUALTOURURLUNBRANDED);
        assertThat(testResProperties.getLivingRoomFeature()).isEqualTo(UPDATED_LIVING_ROOM_FEATURE);
        assertThat(testResProperties.getMasterBedRoomFeature()).isEqualTo(UPDATED_MASTER_BED_ROOM_FEATURE);
        assertThat(testResProperties.getBedRoomFeature()).isEqualTo(UPDATED_BED_ROOM_FEATURE);
        assertThat(testResProperties.getDiningRoomFeature()).isEqualTo(UPDATED_DINING_ROOM_FEATURE);
        assertThat(testResProperties.getKitchenRoomFeature()).isEqualTo(DEFAULT_KITCHEN_ROOM_FEATURE);
        assertThat(testResProperties.getBreakfastRoomFeature()).isEqualTo(UPDATED_BREAKFAST_ROOM_FEATURE);
        assertThat(testResProperties.getStudyRoomFeature()).isEqualTo(DEFAULT_STUDY_ROOM_FEATURE);
        assertThat(testResProperties.getUtilityRoomFeature()).isEqualTo(DEFAULT_UTILITY_ROOM_FEATURE);
        assertThat(testResProperties.getFullBathRoomFeature()).isEqualTo(UPDATED_FULL_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getHalfBathRoomFeature()).isEqualTo(UPDATED_HALF_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getExerciseRoomFeature()).isEqualTo(UPDATED_EXERCISE_ROOM_FEATURE);
        assertThat(testResProperties.getExtraStorageRoomFeature()).isEqualTo(UPDATED_EXTRA_STORAGE_ROOM_FEATURE);
        assertThat(testResProperties.getGameRoomFeature()).isEqualTo(UPDATED_GAME_ROOM_FEATURE);
        assertThat(testResProperties.getGuestRoomFeature()).isEqualTo(UPDATED_GUEST_ROOM_FEATURE);
        assertThat(testResProperties.getLibraryRoomFeature()).isEqualTo(UPDATED_LIBRARY_ROOM_FEATURE);
        assertThat(testResProperties.getMediaRoomFeature()).isEqualTo(UPDATED_MEDIA_ROOM_FEATURE);
        assertThat(testResProperties.getMudRoomFeature()).isEqualTo(UPDATED_MUD_ROOM_FEATURE);
        assertThat(testResProperties.getOfficeRoomFeature()).isEqualTo(UPDATED_OFFICE_ROOM_FEATURE);
        assertThat(testResProperties.getSaunaRoomFeature()).isEqualTo(UPDATED_SAUNA_ROOM_FEATURE);
        assertThat(testResProperties.getSecondMasterRoomFeature()).isEqualTo(DEFAULT_SECOND_MASTER_ROOM_FEATURE);
        assertThat(testResProperties.getSunroomRoomFeature()).isEqualTo(DEFAULT_SUNROOM_ROOM_FEATURE);
        assertThat(testResProperties.getSpaRoomFeature()).isEqualTo(UPDATED_SPA_ROOM_FEATURE);
        assertThat(testResProperties.getWineRoomFeature()).isEqualTo(DEFAULT_WINE_ROOM_FEATURE);
        assertThat(testResProperties.getOtherRoomFeature()).isEqualTo(UPDATED_OTHER_ROOM_FEATURE);
        assertThat(testResProperties.getIsLuxury()).isEqualTo(UPDATED_IS_LUXURY);
        assertThat(testResProperties.getIsMoveInReady()).isEqualTo(UPDATED_IS_MOVE_IN_READY);
        assertThat(testResProperties.getPhotoUrl()).isEqualTo(UPDATED_PHOTO_URL);
        assertThat(testResProperties.getPhoto1Url()).isEqualTo(DEFAULT_PHOTO_1_URL);
        assertThat(testResProperties.getPhoto2Url()).isEqualTo(UPDATED_PHOTO_2_URL);
        assertThat(testResProperties.getPhoto3Url()).isEqualTo(UPDATED_PHOTO_3_URL);
        assertThat(testResProperties.getPhoto4Url()).isEqualTo(UPDATED_PHOTO_4_URL);
        assertThat(testResProperties.getPhoto5Url()).isEqualTo(DEFAULT_PHOTO_5_URL);
        assertThat(testResProperties.getPhoto6Url()).isEqualTo(UPDATED_PHOTO_6_URL);
        assertThat(testResProperties.getPhoto7Url()).isEqualTo(UPDATED_PHOTO_7_URL);
        assertThat(testResProperties.getPhoto8Url()).isEqualTo(DEFAULT_PHOTO_8_URL);
        assertThat(testResProperties.getPhoto9Url()).isEqualTo(UPDATED_PHOTO_9_URL);
        assertThat(testResProperties.getPhoto10Url()).isEqualTo(DEFAULT_PHOTO_10_URL);
        assertThat(testResProperties.getPhoto11Url()).isEqualTo(UPDATED_PHOTO_11_URL);
        assertThat(testResProperties.getPhoto12Url()).isEqualTo(UPDATED_PHOTO_12_URL);
        assertThat(testResProperties.getPhoto13Url()).isEqualTo(DEFAULT_PHOTO_13_URL);
        assertThat(testResProperties.getPhoto14Url()).isEqualTo(UPDATED_PHOTO_14_URL);
        assertThat(testResProperties.getPhoto15Url()).isEqualTo(UPDATED_PHOTO_15_URL);
        assertThat(testResProperties.getPhoto16Url()).isEqualTo(DEFAULT_PHOTO_16_URL);
        assertThat(testResProperties.getPhoto17Url()).isEqualTo(DEFAULT_PHOTO_17_URL);
        assertThat(testResProperties.getPhoto18Url()).isEqualTo(DEFAULT_PHOTO_18_URL);
        assertThat(testResProperties.getPhoto19Url()).isEqualTo(DEFAULT_PHOTO_19_URL);
        assertThat(testResProperties.getPhoto20Url()).isEqualTo(DEFAULT_PHOTO_20_URL);
        assertThat(testResProperties.getPhoto21Url()).isEqualTo(DEFAULT_PHOTO_21_URL);
        assertThat(testResProperties.getPhoto22Url()).isEqualTo(DEFAULT_PHOTO_22_URL);
        assertThat(testResProperties.getPhoto23Url()).isEqualTo(UPDATED_PHOTO_23_URL);
        assertThat(testResProperties.getPhoto24Url()).isEqualTo(UPDATED_PHOTO_24_URL);
        assertThat(testResProperties.getPhoto25Url()).isEqualTo(UPDATED_PHOTO_25_URL);
        assertThat(testResProperties.getPhoto26Url()).isEqualTo(DEFAULT_PHOTO_26_URL);
        assertThat(testResProperties.getPhoto27Url()).isEqualTo(DEFAULT_PHOTO_27_URL);
        assertThat(testResProperties.getPhoto28Url()).isEqualTo(DEFAULT_PHOTO_28_URL);
        assertThat(testResProperties.getPhoto29Url()).isEqualTo(DEFAULT_PHOTO_29_URL);
        assertThat(testResProperties.getPhoto30Url()).isEqualTo(UPDATED_PHOTO_30_URL);
        assertThat(testResProperties.getPhoto31Url()).isEqualTo(UPDATED_PHOTO_31_URL);
        assertThat(testResProperties.getPhoto32Url()).isEqualTo(DEFAULT_PHOTO_32_URL);
        assertThat(testResProperties.getPhoto33Url()).isEqualTo(UPDATED_PHOTO_33_URL);
        assertThat(testResProperties.getPhoto34Url()).isEqualTo(UPDATED_PHOTO_34_URL);
        assertThat(testResProperties.getPhoto35Url()).isEqualTo(DEFAULT_PHOTO_35_URL);
        assertThat(testResProperties.getPhoto36Url()).isEqualTo(UPDATED_PHOTO_36_URL);
        assertThat(testResProperties.getPhoto37Url()).isEqualTo(UPDATED_PHOTO_37_URL);
        assertThat(testResProperties.getPhoto38Url()).isEqualTo(DEFAULT_PHOTO_38_URL);
        assertThat(testResProperties.getPhoto39Url()).isEqualTo(DEFAULT_PHOTO_39_URL);
        assertThat(testResProperties.getPhoto40Url()).isEqualTo(DEFAULT_PHOTO_40_URL);
        assertThat(testResProperties.getCreated()).isEqualTo(DEFAULT_CREATED);
        assertThat(testResProperties.getUpdated()).isEqualTo(UPDATED_UPDATED);
        assertThat(testResProperties.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
        assertThat(testResProperties.getImgDeleted()).isEqualTo(DEFAULT_IMG_DELETED);
        assertThat(testResProperties.getRetsServer()).isEqualTo(DEFAULT_RETS_SERVER);
        assertThat(testResProperties.getPermalink()).isEqualTo(UPDATED_PERMALINK);
        assertThat(testResProperties.getPropertyTag()).isEqualTo(DEFAULT_PROPERTY_TAG);
        assertThat(testResProperties.getBuildentoryViews()).isEqualTo(UPDATED_BUILDENTORY_VIEWS);
        assertThat(testResProperties.getLocation()).isEqualTo(UPDATED_LOCATION);
    }

    @Test
    @Transactional
    void fullUpdateResPropertiesWithPatch() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();

        // Update the resProperties using partial update
        ResProperties partialUpdatedResProperties = new ResProperties();
        partialUpdatedResProperties.setId(resProperties.getId());

        partialUpdatedResProperties
            .communityId(UPDATED_COMMUNITY_ID)
            .communityName(UPDATED_COMMUNITY_NAME)
            .builderId(UPDATED_BUILDER_ID)
            .specialOffers(UPDATED_SPECIAL_OFFERS)
            .brochure(UPDATED_BROCHURE)
            .floorPlanId(UPDATED_FLOOR_PLAN_ID)
            .latitude(UPDATED_LATITUDE)
            .longitude(UPDATED_LONGITUDE)
            .county(UPDATED_COUNTY)
            .heatsystem(UPDATED_HEATSYSTEM)
            .liststatus(UPDATED_LISTSTATUS)
            .liststatusflag(UPDATED_LISTSTATUSFLAG)
            .carportcap(UPDATED_CARPORTCAP)
            .possession(UPDATED_POSSESSION)
            .schoolname1(UPDATED_SCHOOLNAME_1)
            .subdivide(UPDATED_SUBDIVIDE)
            .vowavmyn(UPDATED_VOWAVMYN)
            .presentuse(UPDATED_PRESENTUSE)
            .proposeduse(UPDATED_PROPOSEDUSE)
            .ranchname(UPDATED_RANCHNAME)
            .roombed2width(UPDATED_ROOMBED_2_WIDTH)
            .roomdininglevel(UPDATED_ROOMDININGLEVEL)
            .roomliving2width(UPDATED_ROOMLIVING_2_WIDTH)
            .roomstudylevel(UPDATED_ROOMSTUDYLEVEL)
            .area(UPDATED_AREA)
            .areatitle(UPDATED_AREATITLE)
            .assocfee(UPDATED_ASSOCFEE)
            .financeproposed(UPDATED_FINANCEPROPOSED)
            .listpriceorig(UPDATED_LISTPRICEORIG)
            .mapcoord(UPDATED_MAPCOORD)
            .schoolname2(UPDATED_SCHOOLNAME_2)
            .roomgaragewidth(UPDATED_ROOMGARAGEWIDTH)
            .roomkitchendesc(UPDATED_ROOMKITCHENDESC)
            .roomliving1width(UPDATED_ROOMLIVING_1_WIDTH)
            .roomother2width(UPDATED_ROOMOTHER_2_WIDTH)
            .sqfttotal(UPDATED_SQFTTOTAL)
            .officelistOfficenam1(UPDATED_OFFICELIST_OFFICENAM_1)
            .schoolname3(UPDATED_SCHOOLNAME_3)
            .zipcode(UPDATED_ZIPCODE)
            .barn1length(UPDATED_BARN_1_LENGTH)
            .barn3width(UPDATED_BARN_3_WIDTH)
            .roombed2length(UPDATED_ROOMBED_2_LENGTH)
            .roombed3length(UPDATED_ROOMBED_3_LENGTH)
            .roomother1width(UPDATED_ROOMOTHER_1_WIDTH)
            .agentlistFullname(UPDATED_AGENTLIST_FULLNAME)
            .proptype(UPDATED_PROPTYPE)
            .mlsProptype(UPDATED_MLS_PROPTYPE)
            .schoolname4(UPDATED_SCHOOLNAME_4)
            .acrescultivated(UPDATED_ACRESCULTIVATED)
            .barn2length(UPDATED_BARN_2_LENGTH)
            .barn2width(UPDATED_BARN_2_WIDTH)
            .complexname(UPDATED_COMPLEXNAME)
            .roombed4length(UPDATED_ROOMBED_4_LENGTH)
            .roombedbathdesc(UPDATED_ROOMBEDBATHDESC)
            .roombreakfastwidth(UPDATED_ROOMBREAKFASTWIDTH)
            .roomother(UPDATED_ROOMOTHER)
            .roomutilitylength(UPDATED_ROOMUTILITYLENGTH)
            .acres(UPDATED_ACRES)
            .block(UPDATED_BLOCK)
            .directions(UPDATED_DIRECTIONS)
            .subdivision(UPDATED_SUBDIVISION)
            .yearbuilt(UPDATED_YEARBUILT)
            .yearbuiltdetails(UPDATED_YEARBUILTDETAILS)
            .agexemption(UPDATED_AGEXEMPTION)
            .barn1width(UPDATED_BARN_1_WIDTH)
            .barn3length(UPDATED_BARN_3_LENGTH)
            .roomdiningwidth(UPDATED_ROOMDININGWIDTH)
            .roomstudywidth(UPDATED_ROOMSTUDYWIDTH)
            .soiltype(UPDATED_SOILTYPE)
            .appraisername(UPDATED_APPRAISERNAME)
            .listpricelow(UPDATED_LISTPRICELOW)
            .mappage(UPDATED_MAPPAGE)
            .unitnumber(UPDATED_UNITNUMBER)
            .streetdir(UPDATED_STREETDIR)
            .streettype(UPDATED_STREETTYPE)
            .subarea(UPDATED_SUBAREA)
            .subareatitle(UPDATED_SUBAREATITLE)
            .bathshalf(UPDATED_BATHSHALF)
            .roomgaragelength(UPDATED_ROOMGARAGELENGTH)
            .propsubtype(UPDATED_PROPSUBTYPE)
            .beds(UPDATED_BEDS)
            .roommasterbedwidth(UPDATED_ROOMMASTERBEDWIDTH)
            .roomstudylength(UPDATED_ROOMSTUDYLENGTH)
            .agentlist(UPDATED_AGENTLIST)
            .streetname(UPDATED_STREETNAME)
            .roombreakfastlength(UPDATED_ROOMBREAKFASTLENGTH)
            .roomkitchenwidth(UPDATED_ROOMKITCHENWIDTH)
            .fence(UPDATED_FENCE)
            .bathstotal(UPDATED_BATHSTOTAL)
            .garagecap(UPDATED_GARAGECAP)
            .sqftprice(UPDATED_SQFTPRICE)
            .style(UPDATED_STYLE)
            .exterior(UPDATED_EXTERIOR)
            .foundation(UPDATED_FOUNDATION)
            .interior(UPDATED_INTERIOR)
            .poolyn(UPDATED_POOLYN)
            .poolFeature(UPDATED_POOL_FEATURE)
            .listprice(UPDATED_LISTPRICE)
            .listpricerange(UPDATED_LISTPRICERANGE)
            .mlsnum(UPDATED_MLSNUM)
            .matrixid(UPDATED_MATRIXID)
            .remarks(UPDATED_REMARKS)
            .state(UPDATED_STATE)
            .roof(UPDATED_ROOF)
            .securityfeatures(UPDATED_SECURITYFEATURES)
            .utilitiesother(UPDATED_UTILITIESOTHER)
            .commonfeatures(UPDATED_COMMONFEATURES)
            .construction(UPDATED_CONSTRUCTION)
            .modified(UPDATED_MODIFIED)
            .stories(UPDATED_STORIES)
            .roomdininglength(UPDATED_ROOMDININGLENGTH)
            .roomliving1length(UPDATED_ROOMLIVING_1_LENGTH)
            .openhousetime(UPDATED_OPENHOUSETIME)
            .openhouseendtime(UPDATED_OPENHOUSEENDTIME)
            .roomliving2length(UPDATED_ROOMLIVING_2_LENGTH)
            .lotdesc(UPDATED_LOTDESC)
            .openhousedate(UPDATED_OPENHOUSEDATE)
            .roommasterbedlength(UPDATED_ROOMMASTERBEDLENGTH)
            .roomother1length(UPDATED_ROOMOTHER_1_LENGTH)
            .officesellOfficenam2(UPDATED_OFFICESELL_OFFICENAM_2)
            .lotsize(UPDATED_LOTSIZE)
            .streetdirsuffix(UPDATED_STREETDIRSUFFIX)
            .photocount(UPDATED_PHOTOCOUNT)
            .schooldistrict(UPDATED_SCHOOLDISTRICT)
            .streetnum(UPDATED_STREETNUM)
            .utilities(UPDATED_UTILITIES)
            .equipment(UPDATED_EQUIPMENT)
            .roombed4width(UPDATED_ROOMBED_4_WIDTH)
            .roomkitchenlength(UPDATED_ROOMKITCHENLENGTH)
            .city(UPDATED_CITY)
            .garagedesc(UPDATED_GARAGEDESC)
            .bathsfull(UPDATED_BATHSFULL)
            .roombed3width(UPDATED_ROOMBED_3_WIDTH)
            .roomutildesc(UPDATED_ROOMUTILDESC)
            .roomutilitywidth(UPDATED_ROOMUTILITYWIDTH)
            .roomfullbathlength(UPDATED_ROOMFULLBATHLENGTH)
            .roomfullbathwidth(UPDATED_ROOMFULLBATHWIDTH)
            .roomhalfbathlength(UPDATED_ROOMHALFBATHLENGTH)
            .roomhalfbathwidth(UPDATED_ROOMHALFBATHWIDTH)
            .roomexerciselength(UPDATED_ROOMEXERCISELENGTH)
            .roomexercisewidth(UPDATED_ROOMEXERCISEWIDTH)
            .roomstoragelength(UPDATED_ROOMSTORAGELENGTH)
            .roomstoragewidth(UPDATED_ROOMSTORAGEWIDTH)
            .roomgamelength(UPDATED_ROOMGAMELENGTH)
            .roomgamewidth(UPDATED_ROOMGAMEWIDTH)
            .roomguestlength(UPDATED_ROOMGUESTLENGTH)
            .roomguestwidth(UPDATED_ROOMGUESTWIDTH)
            .roomlibrarylength(UPDATED_ROOMLIBRARYLENGTH)
            .roomlibrarywidth(UPDATED_ROOMLIBRARYWIDTH)
            .roommedialength(UPDATED_ROOMMEDIALENGTH)
            .roommediawidth(UPDATED_ROOMMEDIAWIDTH)
            .roommudlength(UPDATED_ROOMMUDLENGTH)
            .roommudwidth(UPDATED_ROOMMUDWIDTH)
            .roomofficelength(UPDATED_ROOMOFFICELENGTH)
            .roomofficewidth(UPDATED_ROOMOFFICEWIDTH)
            .roomsaunalength(UPDATED_ROOMSAUNALENGTH)
            .roomsaunawidth(UPDATED_ROOMSAUNAWIDTH)
            .roomsecondmasterlength(UPDATED_ROOMSECONDMASTERLENGTH)
            .roomsecondmasterwidth(UPDATED_ROOMSECONDMASTERWIDTH)
            .roomsunlength(UPDATED_ROOMSUNLENGTH)
            .roomsunwidth(UPDATED_ROOMSUNWIDTH)
            .roomspalength(UPDATED_ROOMSPALENGTH)
            .roomspawidth(UPDATED_ROOMSPAWIDTH)
            .roomwinelength(UPDATED_ROOMWINELENGTH)
            .roomwinewidth(UPDATED_ROOMWINEWIDTH)
            .juniorhighschoolname(UPDATED_JUNIORHIGHSCHOOLNAME)
            .primaryschoolname(UPDATED_PRIMARYSCHOOLNAME)
            .seniorhighschoolname(UPDATED_SENIORHIGHSCHOOLNAME)
            .associationfee(UPDATED_ASSOCIATIONFEE)
            .associationfeefrequency(UPDATED_ASSOCIATIONFEEFREQUENCY)
            .constructionmaterials(UPDATED_CONSTRUCTIONMATERIALS)
            .heating(UPDATED_HEATING)
            .accessoryunittype(UPDATED_ACCESSORYUNITTYPE)
            .accessoryunityn(UPDATED_ACCESSORYUNITYN)
            .flooring(UPDATED_FLOORING)
            .fireplacestotal(UPDATED_FIREPLACESTOTAL)
            .fireplacefeatures(UPDATED_FIREPLACEFEATURES)
            .securitysystemyn(UPDATED_SECURITYSYSTEMYN)
            .greenbuildingcertification(UPDATED_GREENBUILDINGCERTIFICATION)
            .greenenergyefficient(UPDATED_GREENENERGYEFFICIENT)
            .energysavingfeatures(UPDATED_ENERGYSAVINGFEATURES)
            .lotnumber(UPDATED_LOTNUMBER)
            .lotsizearea(UPDATED_LOTSIZEAREA)
            .lotsizedimensions(UPDATED_LOTSIZEDIMENSIONS)
            .easements(UPDATED_EASEMENTS)
            .restrictions(UPDATED_RESTRICTIONS)
            .washerdryerconnections(UPDATED_WASHERDRYERCONNECTIONS)
            .municipalutilitydistrictyn(UPDATED_MUNICIPALUTILITYDISTRICTYN)
            .associationfeeincludes(UPDATED_ASSOCIATIONFEEINCLUDES)
            .associationtype(UPDATED_ASSOCIATIONTYPE)
            .barninformation(UPDATED_BARNINFORMATION)
            .constructionmaterialswalls(UPDATED_CONSTRUCTIONMATERIALSWALLS)
            .countyorparish(UPDATED_COUNTYORPARISH)
            .exteriorbuildings(UPDATED_EXTERIORBUILDINGS)
            .farmranchfeatures(UPDATED_FARMRANCHFEATURES)
            .fencedyardyn(UPDATED_FENCEDYARDYN)
            .financingproposed(UPDATED_FINANCINGPROPOSED)
            .handicapyn(UPDATED_HANDICAPYN)
            .numberoftanksandponds(UPDATED_NUMBEROFTANKSANDPONDS)
            .parcelnumber(UPDATED_PARCELNUMBER)
            .virtualtoururlunbranded(UPDATED_VIRTUALTOURURLUNBRANDED)
            .livingRoomFeature(UPDATED_LIVING_ROOM_FEATURE)
            .masterBedRoomFeature(UPDATED_MASTER_BED_ROOM_FEATURE)
            .bedRoomFeature(UPDATED_BED_ROOM_FEATURE)
            .diningRoomFeature(UPDATED_DINING_ROOM_FEATURE)
            .kitchenRoomFeature(UPDATED_KITCHEN_ROOM_FEATURE)
            .breakfastRoomFeature(UPDATED_BREAKFAST_ROOM_FEATURE)
            .studyRoomFeature(UPDATED_STUDY_ROOM_FEATURE)
            .utilityRoomFeature(UPDATED_UTILITY_ROOM_FEATURE)
            .fullBathRoomFeature(UPDATED_FULL_BATH_ROOM_FEATURE)
            .halfBathRoomFeature(UPDATED_HALF_BATH_ROOM_FEATURE)
            .exerciseRoomFeature(UPDATED_EXERCISE_ROOM_FEATURE)
            .extraStorageRoomFeature(UPDATED_EXTRA_STORAGE_ROOM_FEATURE)
            .gameRoomFeature(UPDATED_GAME_ROOM_FEATURE)
            .guestRoomFeature(UPDATED_GUEST_ROOM_FEATURE)
            .libraryRoomFeature(UPDATED_LIBRARY_ROOM_FEATURE)
            .mediaRoomFeature(UPDATED_MEDIA_ROOM_FEATURE)
            .mudRoomFeature(UPDATED_MUD_ROOM_FEATURE)
            .officeRoomFeature(UPDATED_OFFICE_ROOM_FEATURE)
            .saunaRoomFeature(UPDATED_SAUNA_ROOM_FEATURE)
            .secondMasterRoomFeature(UPDATED_SECOND_MASTER_ROOM_FEATURE)
            .sunroomRoomFeature(UPDATED_SUNROOM_ROOM_FEATURE)
            .spaRoomFeature(UPDATED_SPA_ROOM_FEATURE)
            .wineRoomFeature(UPDATED_WINE_ROOM_FEATURE)
            .otherRoomFeature(UPDATED_OTHER_ROOM_FEATURE)
            .isLuxury(UPDATED_IS_LUXURY)
            .isMoveInReady(UPDATED_IS_MOVE_IN_READY)
            .photoUrl(UPDATED_PHOTO_URL)
            .photo1Url(UPDATED_PHOTO_1_URL)
            .photo2Url(UPDATED_PHOTO_2_URL)
            .photo3Url(UPDATED_PHOTO_3_URL)
            .photo4Url(UPDATED_PHOTO_4_URL)
            .photo5Url(UPDATED_PHOTO_5_URL)
            .photo6Url(UPDATED_PHOTO_6_URL)
            .photo7Url(UPDATED_PHOTO_7_URL)
            .photo8Url(UPDATED_PHOTO_8_URL)
            .photo9Url(UPDATED_PHOTO_9_URL)
            .photo10Url(UPDATED_PHOTO_10_URL)
            .photo11Url(UPDATED_PHOTO_11_URL)
            .photo12Url(UPDATED_PHOTO_12_URL)
            .photo13Url(UPDATED_PHOTO_13_URL)
            .photo14Url(UPDATED_PHOTO_14_URL)
            .photo15Url(UPDATED_PHOTO_15_URL)
            .photo16Url(UPDATED_PHOTO_16_URL)
            .photo17Url(UPDATED_PHOTO_17_URL)
            .photo18Url(UPDATED_PHOTO_18_URL)
            .photo19Url(UPDATED_PHOTO_19_URL)
            .photo20Url(UPDATED_PHOTO_20_URL)
            .photo21Url(UPDATED_PHOTO_21_URL)
            .photo22Url(UPDATED_PHOTO_22_URL)
            .photo23Url(UPDATED_PHOTO_23_URL)
            .photo24Url(UPDATED_PHOTO_24_URL)
            .photo25Url(UPDATED_PHOTO_25_URL)
            .photo26Url(UPDATED_PHOTO_26_URL)
            .photo27Url(UPDATED_PHOTO_27_URL)
            .photo28Url(UPDATED_PHOTO_28_URL)
            .photo29Url(UPDATED_PHOTO_29_URL)
            .photo30Url(UPDATED_PHOTO_30_URL)
            .photo31Url(UPDATED_PHOTO_31_URL)
            .photo32Url(UPDATED_PHOTO_32_URL)
            .photo33Url(UPDATED_PHOTO_33_URL)
            .photo34Url(UPDATED_PHOTO_34_URL)
            .photo35Url(UPDATED_PHOTO_35_URL)
            .photo36Url(UPDATED_PHOTO_36_URL)
            .photo37Url(UPDATED_PHOTO_37_URL)
            .photo38Url(UPDATED_PHOTO_38_URL)
            .photo39Url(UPDATED_PHOTO_39_URL)
            .photo40Url(UPDATED_PHOTO_40_URL)
            .created(UPDATED_CREATED)
            .updated(UPDATED_UPDATED)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .imgDeleted(UPDATED_IMG_DELETED)
            .retsServer(UPDATED_RETS_SERVER)
            .permalink(UPDATED_PERMALINK)
            .propertyTag(UPDATED_PROPERTY_TAG)
            .buildentoryViews(UPDATED_BUILDENTORY_VIEWS)
            .location(UPDATED_LOCATION);

        restResPropertiesMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedResProperties.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedResProperties))
            )
            .andExpect(status().isOk());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
        ResProperties testResProperties = resPropertiesList.get(resPropertiesList.size() - 1);
        assertThat(testResProperties.getCommunityId()).isEqualTo(UPDATED_COMMUNITY_ID);
        assertThat(testResProperties.getCommunityName()).isEqualTo(UPDATED_COMMUNITY_NAME);
        assertThat(testResProperties.getBuilderId()).isEqualTo(UPDATED_BUILDER_ID);
        assertThat(testResProperties.getSpecialOffers()).isEqualTo(UPDATED_SPECIAL_OFFERS);
        assertThat(testResProperties.getBrochure()).isEqualTo(UPDATED_BROCHURE);
        assertThat(testResProperties.getFloorPlanId()).isEqualTo(UPDATED_FLOOR_PLAN_ID);
        assertThat(testResProperties.getLatitude()).isEqualTo(UPDATED_LATITUDE);
        assertThat(testResProperties.getLongitude()).isEqualTo(UPDATED_LONGITUDE);
        assertThat(testResProperties.getCounty()).isEqualTo(UPDATED_COUNTY);
        assertThat(testResProperties.getHeatsystem()).isEqualTo(UPDATED_HEATSYSTEM);
        assertThat(testResProperties.getListstatus()).isEqualTo(UPDATED_LISTSTATUS);
        assertThat(testResProperties.getListstatusflag()).isEqualTo(UPDATED_LISTSTATUSFLAG);
        assertThat(testResProperties.getCarportcap()).isEqualTo(UPDATED_CARPORTCAP);
        assertThat(testResProperties.getPossession()).isEqualTo(UPDATED_POSSESSION);
        assertThat(testResProperties.getSchoolname1()).isEqualTo(UPDATED_SCHOOLNAME_1);
        assertThat(testResProperties.getSubdivide()).isEqualTo(UPDATED_SUBDIVIDE);
        assertThat(testResProperties.getVowavmyn()).isEqualTo(UPDATED_VOWAVMYN);
        assertThat(testResProperties.getPresentuse()).isEqualTo(UPDATED_PRESENTUSE);
        assertThat(testResProperties.getProposeduse()).isEqualTo(UPDATED_PROPOSEDUSE);
        assertThat(testResProperties.getRanchname()).isEqualTo(UPDATED_RANCHNAME);
        assertThat(testResProperties.getRoombed2width()).isEqualTo(UPDATED_ROOMBED_2_WIDTH);
        assertThat(testResProperties.getRoomdininglevel()).isEqualTo(UPDATED_ROOMDININGLEVEL);
        assertThat(testResProperties.getRoomliving2width()).isEqualTo(UPDATED_ROOMLIVING_2_WIDTH);
        assertThat(testResProperties.getRoomstudylevel()).isEqualTo(UPDATED_ROOMSTUDYLEVEL);
        assertThat(testResProperties.getArea()).isEqualTo(UPDATED_AREA);
        assertThat(testResProperties.getAreatitle()).isEqualTo(UPDATED_AREATITLE);
        assertThat(testResProperties.getAssocfee()).isEqualTo(UPDATED_ASSOCFEE);
        assertThat(testResProperties.getFinanceproposed()).isEqualTo(UPDATED_FINANCEPROPOSED);
        assertThat(testResProperties.getListpriceorig()).isEqualTo(UPDATED_LISTPRICEORIG);
        assertThat(testResProperties.getMapcoord()).isEqualTo(UPDATED_MAPCOORD);
        assertThat(testResProperties.getSchoolname2()).isEqualTo(UPDATED_SCHOOLNAME_2);
        assertThat(testResProperties.getRoomgaragewidth()).isEqualTo(UPDATED_ROOMGARAGEWIDTH);
        assertThat(testResProperties.getRoomkitchendesc()).isEqualTo(UPDATED_ROOMKITCHENDESC);
        assertThat(testResProperties.getRoomliving1width()).isEqualTo(UPDATED_ROOMLIVING_1_WIDTH);
        assertThat(testResProperties.getRoomother2width()).isEqualTo(UPDATED_ROOMOTHER_2_WIDTH);
        assertThat(testResProperties.getSqfttotal()).isEqualTo(UPDATED_SQFTTOTAL);
        assertThat(testResProperties.getOfficelistOfficenam1()).isEqualTo(UPDATED_OFFICELIST_OFFICENAM_1);
        assertThat(testResProperties.getSchoolname3()).isEqualTo(UPDATED_SCHOOLNAME_3);
        assertThat(testResProperties.getZipcode()).isEqualTo(UPDATED_ZIPCODE);
        assertThat(testResProperties.getBarn1length()).isEqualTo(UPDATED_BARN_1_LENGTH);
        assertThat(testResProperties.getBarn3width()).isEqualTo(UPDATED_BARN_3_WIDTH);
        assertThat(testResProperties.getRoombed2length()).isEqualTo(UPDATED_ROOMBED_2_LENGTH);
        assertThat(testResProperties.getRoombed3length()).isEqualTo(UPDATED_ROOMBED_3_LENGTH);
        assertThat(testResProperties.getRoomother1width()).isEqualTo(UPDATED_ROOMOTHER_1_WIDTH);
        assertThat(testResProperties.getAgentlistFullname()).isEqualTo(UPDATED_AGENTLIST_FULLNAME);
        assertThat(testResProperties.getProptype()).isEqualTo(UPDATED_PROPTYPE);
        assertThat(testResProperties.getMlsProptype()).isEqualTo(UPDATED_MLS_PROPTYPE);
        assertThat(testResProperties.getSchoolname4()).isEqualTo(UPDATED_SCHOOLNAME_4);
        assertThat(testResProperties.getAcrescultivated()).isEqualByComparingTo(UPDATED_ACRESCULTIVATED);
        assertThat(testResProperties.getBarn2length()).isEqualTo(UPDATED_BARN_2_LENGTH);
        assertThat(testResProperties.getBarn2width()).isEqualTo(UPDATED_BARN_2_WIDTH);
        assertThat(testResProperties.getComplexname()).isEqualTo(UPDATED_COMPLEXNAME);
        assertThat(testResProperties.getRoombed4length()).isEqualTo(UPDATED_ROOMBED_4_LENGTH);
        assertThat(testResProperties.getRoombedbathdesc()).isEqualTo(UPDATED_ROOMBEDBATHDESC);
        assertThat(testResProperties.getRoombreakfastwidth()).isEqualTo(UPDATED_ROOMBREAKFASTWIDTH);
        assertThat(testResProperties.getRoomother()).isEqualTo(UPDATED_ROOMOTHER);
        assertThat(testResProperties.getRoomutilitylength()).isEqualTo(UPDATED_ROOMUTILITYLENGTH);
        assertThat(testResProperties.getAcres()).isEqualByComparingTo(UPDATED_ACRES);
        assertThat(testResProperties.getBlock()).isEqualTo(UPDATED_BLOCK);
        assertThat(testResProperties.getDirections()).isEqualTo(UPDATED_DIRECTIONS);
        assertThat(testResProperties.getSubdivision()).isEqualTo(UPDATED_SUBDIVISION);
        assertThat(testResProperties.getYearbuilt()).isEqualTo(UPDATED_YEARBUILT);
        assertThat(testResProperties.getYearbuiltdetails()).isEqualTo(UPDATED_YEARBUILTDETAILS);
        assertThat(testResProperties.getAgexemption()).isEqualTo(UPDATED_AGEXEMPTION);
        assertThat(testResProperties.getBarn1width()).isEqualTo(UPDATED_BARN_1_WIDTH);
        assertThat(testResProperties.getBarn3length()).isEqualTo(UPDATED_BARN_3_LENGTH);
        assertThat(testResProperties.getRoomdiningwidth()).isEqualTo(UPDATED_ROOMDININGWIDTH);
        assertThat(testResProperties.getRoomstudywidth()).isEqualTo(UPDATED_ROOMSTUDYWIDTH);
        assertThat(testResProperties.getSoiltype()).isEqualTo(UPDATED_SOILTYPE);
        assertThat(testResProperties.getAppraisername()).isEqualTo(UPDATED_APPRAISERNAME);
        assertThat(testResProperties.getListpricelow()).isEqualTo(UPDATED_LISTPRICELOW);
        assertThat(testResProperties.getMappage()).isEqualTo(UPDATED_MAPPAGE);
        assertThat(testResProperties.getUnitnumber()).isEqualTo(UPDATED_UNITNUMBER);
        assertThat(testResProperties.getStreetdir()).isEqualTo(UPDATED_STREETDIR);
        assertThat(testResProperties.getStreettype()).isEqualTo(UPDATED_STREETTYPE);
        assertThat(testResProperties.getSubarea()).isEqualTo(UPDATED_SUBAREA);
        assertThat(testResProperties.getSubareatitle()).isEqualTo(UPDATED_SUBAREATITLE);
        assertThat(testResProperties.getBathshalf()).isEqualTo(UPDATED_BATHSHALF);
        assertThat(testResProperties.getRoomgaragelength()).isEqualTo(UPDATED_ROOMGARAGELENGTH);
        assertThat(testResProperties.getPropsubtype()).isEqualTo(UPDATED_PROPSUBTYPE);
        assertThat(testResProperties.getBeds()).isEqualTo(UPDATED_BEDS);
        assertThat(testResProperties.getRoommasterbedwidth()).isEqualTo(UPDATED_ROOMMASTERBEDWIDTH);
        assertThat(testResProperties.getRoomstudylength()).isEqualTo(UPDATED_ROOMSTUDYLENGTH);
        assertThat(testResProperties.getAgentlist()).isEqualTo(UPDATED_AGENTLIST);
        assertThat(testResProperties.getStreetname()).isEqualTo(UPDATED_STREETNAME);
        assertThat(testResProperties.getRoombreakfastlength()).isEqualTo(UPDATED_ROOMBREAKFASTLENGTH);
        assertThat(testResProperties.getRoomkitchenwidth()).isEqualTo(UPDATED_ROOMKITCHENWIDTH);
        assertThat(testResProperties.getFence()).isEqualTo(UPDATED_FENCE);
        assertThat(testResProperties.getBathstotal()).isEqualByComparingTo(UPDATED_BATHSTOTAL);
        assertThat(testResProperties.getGaragecap()).isEqualTo(UPDATED_GARAGECAP);
        assertThat(testResProperties.getSqftprice()).isEqualByComparingTo(UPDATED_SQFTPRICE);
        assertThat(testResProperties.getStyle()).isEqualTo(UPDATED_STYLE);
        assertThat(testResProperties.getExterior()).isEqualTo(UPDATED_EXTERIOR);
        assertThat(testResProperties.getFoundation()).isEqualTo(UPDATED_FOUNDATION);
        assertThat(testResProperties.getInterior()).isEqualTo(UPDATED_INTERIOR);
        assertThat(testResProperties.getPoolyn()).isEqualTo(UPDATED_POOLYN);
        assertThat(testResProperties.getPoolFeature()).isEqualTo(UPDATED_POOL_FEATURE);
        assertThat(testResProperties.getListprice()).isEqualTo(UPDATED_LISTPRICE);
        assertThat(testResProperties.getListpricerange()).isEqualTo(UPDATED_LISTPRICERANGE);
        assertThat(testResProperties.getMlsnum()).isEqualTo(UPDATED_MLSNUM);
        assertThat(testResProperties.getMatrixid()).isEqualTo(UPDATED_MATRIXID);
        assertThat(testResProperties.getRemarks()).isEqualTo(UPDATED_REMARKS);
        assertThat(testResProperties.getState()).isEqualTo(UPDATED_STATE);
        assertThat(testResProperties.getRoof()).isEqualTo(UPDATED_ROOF);
        assertThat(testResProperties.getSecurityfeatures()).isEqualTo(UPDATED_SECURITYFEATURES);
        assertThat(testResProperties.getUtilitiesother()).isEqualTo(UPDATED_UTILITIESOTHER);
        assertThat(testResProperties.getCommonfeatures()).isEqualTo(UPDATED_COMMONFEATURES);
        assertThat(testResProperties.getConstruction()).isEqualTo(UPDATED_CONSTRUCTION);
        assertThat(testResProperties.getModified()).isEqualTo(UPDATED_MODIFIED);
        assertThat(testResProperties.getStories()).isEqualTo(UPDATED_STORIES);
        assertThat(testResProperties.getRoomdininglength()).isEqualTo(UPDATED_ROOMDININGLENGTH);
        assertThat(testResProperties.getRoomliving1length()).isEqualTo(UPDATED_ROOMLIVING_1_LENGTH);
        assertThat(testResProperties.getOpenhousetime()).isEqualTo(UPDATED_OPENHOUSETIME);
        assertThat(testResProperties.getOpenhouseendtime()).isEqualTo(UPDATED_OPENHOUSEENDTIME);
        assertThat(testResProperties.getRoomliving2length()).isEqualTo(UPDATED_ROOMLIVING_2_LENGTH);
        assertThat(testResProperties.getLotdesc()).isEqualTo(UPDATED_LOTDESC);
        assertThat(testResProperties.getOpenhousedate()).isEqualTo(UPDATED_OPENHOUSEDATE);
        assertThat(testResProperties.getRoommasterbedlength()).isEqualTo(UPDATED_ROOMMASTERBEDLENGTH);
        assertThat(testResProperties.getRoomother1length()).isEqualTo(UPDATED_ROOMOTHER_1_LENGTH);
        assertThat(testResProperties.getOfficesellOfficenam2()).isEqualTo(UPDATED_OFFICESELL_OFFICENAM_2);
        assertThat(testResProperties.getLotsize()).isEqualTo(UPDATED_LOTSIZE);
        assertThat(testResProperties.getStreetdirsuffix()).isEqualTo(UPDATED_STREETDIRSUFFIX);
        assertThat(testResProperties.getPhotocount()).isEqualTo(UPDATED_PHOTOCOUNT);
        assertThat(testResProperties.getSchooldistrict()).isEqualTo(UPDATED_SCHOOLDISTRICT);
        assertThat(testResProperties.getStreetnum()).isEqualTo(UPDATED_STREETNUM);
        assertThat(testResProperties.getUtilities()).isEqualTo(UPDATED_UTILITIES);
        assertThat(testResProperties.getEquipment()).isEqualTo(UPDATED_EQUIPMENT);
        assertThat(testResProperties.getRoombed4width()).isEqualTo(UPDATED_ROOMBED_4_WIDTH);
        assertThat(testResProperties.getRoomkitchenlength()).isEqualTo(UPDATED_ROOMKITCHENLENGTH);
        assertThat(testResProperties.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testResProperties.getGaragedesc()).isEqualTo(UPDATED_GARAGEDESC);
        assertThat(testResProperties.getBathsfull()).isEqualTo(UPDATED_BATHSFULL);
        assertThat(testResProperties.getRoombed3width()).isEqualTo(UPDATED_ROOMBED_3_WIDTH);
        assertThat(testResProperties.getRoomutildesc()).isEqualTo(UPDATED_ROOMUTILDESC);
        assertThat(testResProperties.getRoomutilitywidth()).isEqualTo(UPDATED_ROOMUTILITYWIDTH);
        assertThat(testResProperties.getRoomfullbathlength()).isEqualTo(UPDATED_ROOMFULLBATHLENGTH);
        assertThat(testResProperties.getRoomfullbathwidth()).isEqualTo(UPDATED_ROOMFULLBATHWIDTH);
        assertThat(testResProperties.getRoomhalfbathlength()).isEqualTo(UPDATED_ROOMHALFBATHLENGTH);
        assertThat(testResProperties.getRoomhalfbathwidth()).isEqualTo(UPDATED_ROOMHALFBATHWIDTH);
        assertThat(testResProperties.getRoomexerciselength()).isEqualTo(UPDATED_ROOMEXERCISELENGTH);
        assertThat(testResProperties.getRoomexercisewidth()).isEqualTo(UPDATED_ROOMEXERCISEWIDTH);
        assertThat(testResProperties.getRoomstoragelength()).isEqualTo(UPDATED_ROOMSTORAGELENGTH);
        assertThat(testResProperties.getRoomstoragewidth()).isEqualTo(UPDATED_ROOMSTORAGEWIDTH);
        assertThat(testResProperties.getRoomgamelength()).isEqualTo(UPDATED_ROOMGAMELENGTH);
        assertThat(testResProperties.getRoomgamewidth()).isEqualTo(UPDATED_ROOMGAMEWIDTH);
        assertThat(testResProperties.getRoomguestlength()).isEqualTo(UPDATED_ROOMGUESTLENGTH);
        assertThat(testResProperties.getRoomguestwidth()).isEqualTo(UPDATED_ROOMGUESTWIDTH);
        assertThat(testResProperties.getRoomlibrarylength()).isEqualTo(UPDATED_ROOMLIBRARYLENGTH);
        assertThat(testResProperties.getRoomlibrarywidth()).isEqualTo(UPDATED_ROOMLIBRARYWIDTH);
        assertThat(testResProperties.getRoommedialength()).isEqualTo(UPDATED_ROOMMEDIALENGTH);
        assertThat(testResProperties.getRoommediawidth()).isEqualTo(UPDATED_ROOMMEDIAWIDTH);
        assertThat(testResProperties.getRoommudlength()).isEqualTo(UPDATED_ROOMMUDLENGTH);
        assertThat(testResProperties.getRoommudwidth()).isEqualTo(UPDATED_ROOMMUDWIDTH);
        assertThat(testResProperties.getRoomofficelength()).isEqualTo(UPDATED_ROOMOFFICELENGTH);
        assertThat(testResProperties.getRoomofficewidth()).isEqualTo(UPDATED_ROOMOFFICEWIDTH);
        assertThat(testResProperties.getRoomsaunalength()).isEqualTo(UPDATED_ROOMSAUNALENGTH);
        assertThat(testResProperties.getRoomsaunawidth()).isEqualTo(UPDATED_ROOMSAUNAWIDTH);
        assertThat(testResProperties.getRoomsecondmasterlength()).isEqualTo(UPDATED_ROOMSECONDMASTERLENGTH);
        assertThat(testResProperties.getRoomsecondmasterwidth()).isEqualTo(UPDATED_ROOMSECONDMASTERWIDTH);
        assertThat(testResProperties.getRoomsunlength()).isEqualTo(UPDATED_ROOMSUNLENGTH);
        assertThat(testResProperties.getRoomsunwidth()).isEqualTo(UPDATED_ROOMSUNWIDTH);
        assertThat(testResProperties.getRoomspalength()).isEqualTo(UPDATED_ROOMSPALENGTH);
        assertThat(testResProperties.getRoomspawidth()).isEqualTo(UPDATED_ROOMSPAWIDTH);
        assertThat(testResProperties.getRoomwinelength()).isEqualTo(UPDATED_ROOMWINELENGTH);
        assertThat(testResProperties.getRoomwinewidth()).isEqualTo(UPDATED_ROOMWINEWIDTH);
        assertThat(testResProperties.getJuniorhighschoolname()).isEqualTo(UPDATED_JUNIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getPrimaryschoolname()).isEqualTo(UPDATED_PRIMARYSCHOOLNAME);
        assertThat(testResProperties.getSeniorhighschoolname()).isEqualTo(UPDATED_SENIORHIGHSCHOOLNAME);
        assertThat(testResProperties.getAssociationfee()).isEqualTo(UPDATED_ASSOCIATIONFEE);
        assertThat(testResProperties.getAssociationfeefrequency()).isEqualTo(UPDATED_ASSOCIATIONFEEFREQUENCY);
        assertThat(testResProperties.getConstructionmaterials()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALS);
        assertThat(testResProperties.getHeating()).isEqualTo(UPDATED_HEATING);
        assertThat(testResProperties.getAccessoryunittype()).isEqualTo(UPDATED_ACCESSORYUNITTYPE);
        assertThat(testResProperties.getAccessoryunityn()).isEqualTo(UPDATED_ACCESSORYUNITYN);
        assertThat(testResProperties.getFlooring()).isEqualTo(UPDATED_FLOORING);
        assertThat(testResProperties.getFireplacestotal()).isEqualTo(UPDATED_FIREPLACESTOTAL);
        assertThat(testResProperties.getFireplacefeatures()).isEqualTo(UPDATED_FIREPLACEFEATURES);
        assertThat(testResProperties.getSecuritysystemyn()).isEqualTo(UPDATED_SECURITYSYSTEMYN);
        assertThat(testResProperties.getGreenbuildingcertification()).isEqualTo(UPDATED_GREENBUILDINGCERTIFICATION);
        assertThat(testResProperties.getGreenenergyefficient()).isEqualTo(UPDATED_GREENENERGYEFFICIENT);
        assertThat(testResProperties.getEnergysavingfeatures()).isEqualTo(UPDATED_ENERGYSAVINGFEATURES);
        assertThat(testResProperties.getLotnumber()).isEqualTo(UPDATED_LOTNUMBER);
        assertThat(testResProperties.getLotsizearea()).isEqualTo(UPDATED_LOTSIZEAREA);
        assertThat(testResProperties.getLotsizedimensions()).isEqualTo(UPDATED_LOTSIZEDIMENSIONS);
        assertThat(testResProperties.getEasements()).isEqualTo(UPDATED_EASEMENTS);
        assertThat(testResProperties.getRestrictions()).isEqualTo(UPDATED_RESTRICTIONS);
        assertThat(testResProperties.getWasherdryerconnections()).isEqualTo(UPDATED_WASHERDRYERCONNECTIONS);
        assertThat(testResProperties.getMunicipalutilitydistrictyn()).isEqualTo(UPDATED_MUNICIPALUTILITYDISTRICTYN);
        assertThat(testResProperties.getAssociationfeeincludes()).isEqualTo(UPDATED_ASSOCIATIONFEEINCLUDES);
        assertThat(testResProperties.getAssociationtype()).isEqualTo(UPDATED_ASSOCIATIONTYPE);
        assertThat(testResProperties.getBarninformation()).isEqualTo(UPDATED_BARNINFORMATION);
        assertThat(testResProperties.getConstructionmaterialswalls()).isEqualTo(UPDATED_CONSTRUCTIONMATERIALSWALLS);
        assertThat(testResProperties.getCountyorparish()).isEqualTo(UPDATED_COUNTYORPARISH);
        assertThat(testResProperties.getExteriorbuildings()).isEqualTo(UPDATED_EXTERIORBUILDINGS);
        assertThat(testResProperties.getFarmranchfeatures()).isEqualTo(UPDATED_FARMRANCHFEATURES);
        assertThat(testResProperties.getFencedyardyn()).isEqualTo(UPDATED_FENCEDYARDYN);
        assertThat(testResProperties.getFinancingproposed()).isEqualTo(UPDATED_FINANCINGPROPOSED);
        assertThat(testResProperties.getHandicapyn()).isEqualTo(UPDATED_HANDICAPYN);
        assertThat(testResProperties.getNumberoftanksandponds()).isEqualTo(UPDATED_NUMBEROFTANKSANDPONDS);
        assertThat(testResProperties.getParcelnumber()).isEqualTo(UPDATED_PARCELNUMBER);
        assertThat(testResProperties.getVirtualtoururlunbranded()).isEqualTo(UPDATED_VIRTUALTOURURLUNBRANDED);
        assertThat(testResProperties.getLivingRoomFeature()).isEqualTo(UPDATED_LIVING_ROOM_FEATURE);
        assertThat(testResProperties.getMasterBedRoomFeature()).isEqualTo(UPDATED_MASTER_BED_ROOM_FEATURE);
        assertThat(testResProperties.getBedRoomFeature()).isEqualTo(UPDATED_BED_ROOM_FEATURE);
        assertThat(testResProperties.getDiningRoomFeature()).isEqualTo(UPDATED_DINING_ROOM_FEATURE);
        assertThat(testResProperties.getKitchenRoomFeature()).isEqualTo(UPDATED_KITCHEN_ROOM_FEATURE);
        assertThat(testResProperties.getBreakfastRoomFeature()).isEqualTo(UPDATED_BREAKFAST_ROOM_FEATURE);
        assertThat(testResProperties.getStudyRoomFeature()).isEqualTo(UPDATED_STUDY_ROOM_FEATURE);
        assertThat(testResProperties.getUtilityRoomFeature()).isEqualTo(UPDATED_UTILITY_ROOM_FEATURE);
        assertThat(testResProperties.getFullBathRoomFeature()).isEqualTo(UPDATED_FULL_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getHalfBathRoomFeature()).isEqualTo(UPDATED_HALF_BATH_ROOM_FEATURE);
        assertThat(testResProperties.getExerciseRoomFeature()).isEqualTo(UPDATED_EXERCISE_ROOM_FEATURE);
        assertThat(testResProperties.getExtraStorageRoomFeature()).isEqualTo(UPDATED_EXTRA_STORAGE_ROOM_FEATURE);
        assertThat(testResProperties.getGameRoomFeature()).isEqualTo(UPDATED_GAME_ROOM_FEATURE);
        assertThat(testResProperties.getGuestRoomFeature()).isEqualTo(UPDATED_GUEST_ROOM_FEATURE);
        assertThat(testResProperties.getLibraryRoomFeature()).isEqualTo(UPDATED_LIBRARY_ROOM_FEATURE);
        assertThat(testResProperties.getMediaRoomFeature()).isEqualTo(UPDATED_MEDIA_ROOM_FEATURE);
        assertThat(testResProperties.getMudRoomFeature()).isEqualTo(UPDATED_MUD_ROOM_FEATURE);
        assertThat(testResProperties.getOfficeRoomFeature()).isEqualTo(UPDATED_OFFICE_ROOM_FEATURE);
        assertThat(testResProperties.getSaunaRoomFeature()).isEqualTo(UPDATED_SAUNA_ROOM_FEATURE);
        assertThat(testResProperties.getSecondMasterRoomFeature()).isEqualTo(UPDATED_SECOND_MASTER_ROOM_FEATURE);
        assertThat(testResProperties.getSunroomRoomFeature()).isEqualTo(UPDATED_SUNROOM_ROOM_FEATURE);
        assertThat(testResProperties.getSpaRoomFeature()).isEqualTo(UPDATED_SPA_ROOM_FEATURE);
        assertThat(testResProperties.getWineRoomFeature()).isEqualTo(UPDATED_WINE_ROOM_FEATURE);
        assertThat(testResProperties.getOtherRoomFeature()).isEqualTo(UPDATED_OTHER_ROOM_FEATURE);
        assertThat(testResProperties.getIsLuxury()).isEqualTo(UPDATED_IS_LUXURY);
        assertThat(testResProperties.getIsMoveInReady()).isEqualTo(UPDATED_IS_MOVE_IN_READY);
        assertThat(testResProperties.getPhotoUrl()).isEqualTo(UPDATED_PHOTO_URL);
        assertThat(testResProperties.getPhoto1Url()).isEqualTo(UPDATED_PHOTO_1_URL);
        assertThat(testResProperties.getPhoto2Url()).isEqualTo(UPDATED_PHOTO_2_URL);
        assertThat(testResProperties.getPhoto3Url()).isEqualTo(UPDATED_PHOTO_3_URL);
        assertThat(testResProperties.getPhoto4Url()).isEqualTo(UPDATED_PHOTO_4_URL);
        assertThat(testResProperties.getPhoto5Url()).isEqualTo(UPDATED_PHOTO_5_URL);
        assertThat(testResProperties.getPhoto6Url()).isEqualTo(UPDATED_PHOTO_6_URL);
        assertThat(testResProperties.getPhoto7Url()).isEqualTo(UPDATED_PHOTO_7_URL);
        assertThat(testResProperties.getPhoto8Url()).isEqualTo(UPDATED_PHOTO_8_URL);
        assertThat(testResProperties.getPhoto9Url()).isEqualTo(UPDATED_PHOTO_9_URL);
        assertThat(testResProperties.getPhoto10Url()).isEqualTo(UPDATED_PHOTO_10_URL);
        assertThat(testResProperties.getPhoto11Url()).isEqualTo(UPDATED_PHOTO_11_URL);
        assertThat(testResProperties.getPhoto12Url()).isEqualTo(UPDATED_PHOTO_12_URL);
        assertThat(testResProperties.getPhoto13Url()).isEqualTo(UPDATED_PHOTO_13_URL);
        assertThat(testResProperties.getPhoto14Url()).isEqualTo(UPDATED_PHOTO_14_URL);
        assertThat(testResProperties.getPhoto15Url()).isEqualTo(UPDATED_PHOTO_15_URL);
        assertThat(testResProperties.getPhoto16Url()).isEqualTo(UPDATED_PHOTO_16_URL);
        assertThat(testResProperties.getPhoto17Url()).isEqualTo(UPDATED_PHOTO_17_URL);
        assertThat(testResProperties.getPhoto18Url()).isEqualTo(UPDATED_PHOTO_18_URL);
        assertThat(testResProperties.getPhoto19Url()).isEqualTo(UPDATED_PHOTO_19_URL);
        assertThat(testResProperties.getPhoto20Url()).isEqualTo(UPDATED_PHOTO_20_URL);
        assertThat(testResProperties.getPhoto21Url()).isEqualTo(UPDATED_PHOTO_21_URL);
        assertThat(testResProperties.getPhoto22Url()).isEqualTo(UPDATED_PHOTO_22_URL);
        assertThat(testResProperties.getPhoto23Url()).isEqualTo(UPDATED_PHOTO_23_URL);
        assertThat(testResProperties.getPhoto24Url()).isEqualTo(UPDATED_PHOTO_24_URL);
        assertThat(testResProperties.getPhoto25Url()).isEqualTo(UPDATED_PHOTO_25_URL);
        assertThat(testResProperties.getPhoto26Url()).isEqualTo(UPDATED_PHOTO_26_URL);
        assertThat(testResProperties.getPhoto27Url()).isEqualTo(UPDATED_PHOTO_27_URL);
        assertThat(testResProperties.getPhoto28Url()).isEqualTo(UPDATED_PHOTO_28_URL);
        assertThat(testResProperties.getPhoto29Url()).isEqualTo(UPDATED_PHOTO_29_URL);
        assertThat(testResProperties.getPhoto30Url()).isEqualTo(UPDATED_PHOTO_30_URL);
        assertThat(testResProperties.getPhoto31Url()).isEqualTo(UPDATED_PHOTO_31_URL);
        assertThat(testResProperties.getPhoto32Url()).isEqualTo(UPDATED_PHOTO_32_URL);
        assertThat(testResProperties.getPhoto33Url()).isEqualTo(UPDATED_PHOTO_33_URL);
        assertThat(testResProperties.getPhoto34Url()).isEqualTo(UPDATED_PHOTO_34_URL);
        assertThat(testResProperties.getPhoto35Url()).isEqualTo(UPDATED_PHOTO_35_URL);
        assertThat(testResProperties.getPhoto36Url()).isEqualTo(UPDATED_PHOTO_36_URL);
        assertThat(testResProperties.getPhoto37Url()).isEqualTo(UPDATED_PHOTO_37_URL);
        assertThat(testResProperties.getPhoto38Url()).isEqualTo(UPDATED_PHOTO_38_URL);
        assertThat(testResProperties.getPhoto39Url()).isEqualTo(UPDATED_PHOTO_39_URL);
        assertThat(testResProperties.getPhoto40Url()).isEqualTo(UPDATED_PHOTO_40_URL);
        assertThat(testResProperties.getCreated()).isEqualTo(UPDATED_CREATED);
        assertThat(testResProperties.getUpdated()).isEqualTo(UPDATED_UPDATED);
        assertThat(testResProperties.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
        assertThat(testResProperties.getImgDeleted()).isEqualTo(UPDATED_IMG_DELETED);
        assertThat(testResProperties.getRetsServer()).isEqualTo(UPDATED_RETS_SERVER);
        assertThat(testResProperties.getPermalink()).isEqualTo(UPDATED_PERMALINK);
        assertThat(testResProperties.getPropertyTag()).isEqualTo(UPDATED_PROPERTY_TAG);
        assertThat(testResProperties.getBuildentoryViews()).isEqualTo(UPDATED_BUILDENTORY_VIEWS);
        assertThat(testResProperties.getLocation()).isEqualTo(UPDATED_LOCATION);
    }

    @Test
    @Transactional
    void patchNonExistingResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, resProperties.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(resProperties))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(resProperties))
            )
            .andExpect(status().isBadRequest());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamResProperties() throws Exception {
        int databaseSizeBeforeUpdate = resPropertiesRepository.findAll().size();
        resProperties.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restResPropertiesMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(resProperties))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the ResProperties in the database
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteResProperties() throws Exception {
        // Initialize the database
        resPropertiesRepository.saveAndFlush(resProperties);

        int databaseSizeBeforeDelete = resPropertiesRepository.findAll().size();

        // Delete the resProperties
        restResPropertiesMockMvc
            .perform(delete(ENTITY_API_URL_ID, resProperties.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ResProperties> resPropertiesList = resPropertiesRepository.findAll();
        assertThat(resPropertiesList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
