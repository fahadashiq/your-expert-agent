import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as dayjs from 'dayjs';

import { DATE_TIME_FORMAT } from 'app/config/input.constants';
import { IResProperties, ResProperties } from '../res-properties.model';

import { ResPropertiesService } from './res-properties.service';

describe('ResProperties Service', () => {
  let service: ResPropertiesService;
  let httpMock: HttpTestingController;
  let elemDefault: IResProperties;
  let expectedResult: IResProperties | IResProperties[] | boolean | null;
  let currentDate: dayjs.Dayjs;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(ResPropertiesService);
    httpMock = TestBed.inject(HttpTestingController);
    currentDate = dayjs();

    elemDefault = {
      id: 0,
      communityId: 0,
      communityName: 'AAAAAAA',
      builderId: 0,
      specialOffers: 'AAAAAAA',
      brochure: 'AAAAAAA',
      floorPlanId: 0,
      latitude: 'AAAAAAA',
      longitude: 'AAAAAAA',
      county: 'AAAAAAA',
      heatsystem: 'AAAAAAA',
      liststatus: 'AAAAAAA',
      liststatusflag: 'AAAAAAA',
      carportcap: 'AAAAAAA',
      possession: 'AAAAAAA',
      schoolname1: 'AAAAAAA',
      subdivide: 'AAAAAAA',
      vowavmyn: 'AAAAAAA',
      presentuse: 'AAAAAAA',
      proposeduse: 'AAAAAAA',
      ranchname: 'AAAAAAA',
      roombed2width: 0,
      roomdininglevel: 'AAAAAAA',
      roomliving2width: 0,
      roomstudylevel: 'AAAAAAA',
      area: 0,
      areatitle: 'AAAAAAA',
      assocfee: 0,
      financeproposed: 'AAAAAAA',
      listpriceorig: 0,
      mapcoord: 'AAAAAAA',
      schoolname2: 'AAAAAAA',
      roomgaragewidth: 0,
      roomkitchendesc: 'AAAAAAA',
      roomliving1width: 0,
      roomother2width: 0,
      sqfttotal: 0,
      officelistOfficenam1: 'AAAAAAA',
      schoolname3: 'AAAAAAA',
      zipcode: 'AAAAAAA',
      barn1length: 0,
      barn3width: 0,
      roombed2length: 0,
      roombed3length: 0,
      roomother1width: 0,
      agentlistFullname: 'AAAAAAA',
      proptype: 'AAAAAAA',
      mlsProptype: 'AAAAAAA',
      schoolname4: 'AAAAAAA',
      acrescultivated: 0,
      barn2length: 0,
      barn2width: 0,
      complexname: 'AAAAAAA',
      roombed4length: 0,
      roombedbathdesc: 'AAAAAAA',
      roombreakfastwidth: 0,
      roomother: 'AAAAAAA',
      roomutilitylength: 0,
      acres: 0,
      block: 'AAAAAAA',
      directions: 'AAAAAAA',
      subdivision: 'AAAAAAA',
      yearbuilt: 0,
      yearbuiltdetails: 'AAAAAAA',
      agexemption: 'AAAAAAA',
      barn1width: 0,
      barn3length: 0,
      roomdiningwidth: 0,
      roomstudywidth: 0,
      soiltype: 'AAAAAAA',
      appraisername: 'AAAAAAA',
      listpricelow: 0,
      mappage: 'AAAAAAA',
      unitnumber: 'AAAAAAA',
      streetdir: 'AAAAAAA',
      streettype: 'AAAAAAA',
      subarea: 'AAAAAAA',
      subareatitle: 'AAAAAAA',
      bathshalf: 0,
      roomgaragelength: 0,
      propsubtype: 'AAAAAAA',
      beds: 0,
      roommasterbedwidth: 0,
      roomstudylength: 0,
      agentlist: 'AAAAAAA',
      streetname: 'AAAAAAA',
      roombreakfastlength: 0,
      roomkitchenwidth: 0,
      fence: 'AAAAAAA',
      bathstotal: 0,
      garagecap: 0,
      sqftprice: 0,
      style: 'AAAAAAA',
      exterior: 'AAAAAAA',
      foundation: 'AAAAAAA',
      interior: 'AAAAAAA',
      poolyn: 'AAAAAAA',
      poolFeature: 'AAAAAAA',
      listprice: 0,
      listpricerange: 'AAAAAAA',
      mlsnum: 'AAAAAAA',
      matrixid: 0,
      remarks: 'AAAAAAA',
      state: 'AAAAAAA',
      roof: 'AAAAAAA',
      securityfeatures: 'AAAAAAA',
      utilitiesother: 'AAAAAAA',
      commonfeatures: 'AAAAAAA',
      construction: 'AAAAAAA',
      modified: currentDate,
      stories: 0,
      roomdininglength: 0,
      roomliving1length: 0,
      openhousetime: 'AAAAAAA',
      openhouseendtime: 'AAAAAAA',
      roomliving2length: 0,
      lotdesc: 'AAAAAAA',
      openhousedate: currentDate,
      roommasterbedlength: 0,
      roomother1length: 0,
      officesellOfficenam2: 'AAAAAAA',
      lotsize: 'AAAAAAA',
      streetdirsuffix: 'AAAAAAA',
      photocount: 0,
      schooldistrict: 'AAAAAAA',
      streetnum: 0,
      utilities: 'AAAAAAA',
      equipment: 'AAAAAAA',
      roombed4width: 0,
      roomkitchenlength: 0,
      city: 'AAAAAAA',
      garagedesc: 'AAAAAAA',
      bathsfull: 0,
      roombed3width: 0,
      roomutildesc: 'AAAAAAA',
      roomutilitywidth: 0,
      roomfullbathlength: 'AAAAAAA',
      roomfullbathwidth: 'AAAAAAA',
      roomhalfbathlength: 'AAAAAAA',
      roomhalfbathwidth: 'AAAAAAA',
      roomexerciselength: 'AAAAAAA',
      roomexercisewidth: 'AAAAAAA',
      roomstoragelength: 'AAAAAAA',
      roomstoragewidth: 'AAAAAAA',
      roomgamelength: 'AAAAAAA',
      roomgamewidth: 'AAAAAAA',
      roomguestlength: 'AAAAAAA',
      roomguestwidth: 'AAAAAAA',
      roomlibrarylength: 'AAAAAAA',
      roomlibrarywidth: 'AAAAAAA',
      roommedialength: 'AAAAAAA',
      roommediawidth: 'AAAAAAA',
      roommudlength: 'AAAAAAA',
      roommudwidth: 'AAAAAAA',
      roomofficelength: 'AAAAAAA',
      roomofficewidth: 'AAAAAAA',
      roomsaunalength: 'AAAAAAA',
      roomsaunawidth: 'AAAAAAA',
      roomsecondmasterlength: 'AAAAAAA',
      roomsecondmasterwidth: 'AAAAAAA',
      roomsunlength: 'AAAAAAA',
      roomsunwidth: 'AAAAAAA',
      roomspalength: 'AAAAAAA',
      roomspawidth: 'AAAAAAA',
      roomwinelength: 'AAAAAAA',
      roomwinewidth: 'AAAAAAA',
      juniorhighschoolname: 'AAAAAAA',
      primaryschoolname: 'AAAAAAA',
      seniorhighschoolname: 'AAAAAAA',
      associationfee: 'AAAAAAA',
      associationfeefrequency: 'AAAAAAA',
      constructionmaterials: 'AAAAAAA',
      heating: 'AAAAAAA',
      accessoryunittype: 'AAAAAAA',
      accessoryunityn: 'AAAAAAA',
      flooring: 'AAAAAAA',
      fireplacestotal: 'AAAAAAA',
      fireplacefeatures: 'AAAAAAA',
      securitysystemyn: 'AAAAAAA',
      greenbuildingcertification: 'AAAAAAA',
      greenenergyefficient: 'AAAAAAA',
      energysavingfeatures: 'AAAAAAA',
      lotnumber: 'AAAAAAA',
      lotsizearea: 'AAAAAAA',
      lotsizedimensions: 'AAAAAAA',
      easements: 'AAAAAAA',
      restrictions: 'AAAAAAA',
      washerdryerconnections: 'AAAAAAA',
      municipalutilitydistrictyn: 'AAAAAAA',
      associationfeeincludes: 'AAAAAAA',
      associationtype: 'AAAAAAA',
      barninformation: 'AAAAAAA',
      constructionmaterialswalls: 'AAAAAAA',
      countyorparish: 'AAAAAAA',
      exteriorbuildings: 'AAAAAAA',
      farmranchfeatures: 'AAAAAAA',
      fencedyardyn: 'AAAAAAA',
      financingproposed: 'AAAAAAA',
      handicapyn: 'AAAAAAA',
      numberoftanksandponds: 'AAAAAAA',
      parcelnumber: 'AAAAAAA',
      virtualtoururlunbranded: 'AAAAAAA',
      livingRoomFeature: 'AAAAAAA',
      masterBedRoomFeature: 'AAAAAAA',
      bedRoomFeature: 'AAAAAAA',
      diningRoomFeature: 'AAAAAAA',
      kitchenRoomFeature: 'AAAAAAA',
      breakfastRoomFeature: 'AAAAAAA',
      studyRoomFeature: 'AAAAAAA',
      utilityRoomFeature: 'AAAAAAA',
      fullBathRoomFeature: 'AAAAAAA',
      halfBathRoomFeature: 'AAAAAAA',
      exerciseRoomFeature: 'AAAAAAA',
      extraStorageRoomFeature: 'AAAAAAA',
      gameRoomFeature: 'AAAAAAA',
      guestRoomFeature: 'AAAAAAA',
      libraryRoomFeature: 'AAAAAAA',
      mediaRoomFeature: 'AAAAAAA',
      mudRoomFeature: 'AAAAAAA',
      officeRoomFeature: 'AAAAAAA',
      saunaRoomFeature: 'AAAAAAA',
      secondMasterRoomFeature: 'AAAAAAA',
      sunroomRoomFeature: 'AAAAAAA',
      spaRoomFeature: 'AAAAAAA',
      wineRoomFeature: 'AAAAAAA',
      otherRoomFeature: 'AAAAAAA',
      isLuxury: 'AAAAAAA',
      isMoveInReady: 'AAAAAAA',
      photoUrl: 'AAAAAAA',
      photo1Url: 'AAAAAAA',
      photo2Url: 'AAAAAAA',
      photo3Url: 'AAAAAAA',
      photo4Url: 'AAAAAAA',
      photo5Url: 'AAAAAAA',
      photo6Url: 'AAAAAAA',
      photo7Url: 'AAAAAAA',
      photo8Url: 'AAAAAAA',
      photo9Url: 'AAAAAAA',
      photo10Url: 'AAAAAAA',
      photo11Url: 'AAAAAAA',
      photo12Url: 'AAAAAAA',
      photo13Url: 'AAAAAAA',
      photo14Url: 'AAAAAAA',
      photo15Url: 'AAAAAAA',
      photo16Url: 'AAAAAAA',
      photo17Url: 'AAAAAAA',
      photo18Url: 'AAAAAAA',
      photo19Url: 'AAAAAAA',
      photo20Url: 'AAAAAAA',
      photo21Url: 'AAAAAAA',
      photo22Url: 'AAAAAAA',
      photo23Url: 'AAAAAAA',
      photo24Url: 'AAAAAAA',
      photo25Url: 'AAAAAAA',
      photo26Url: 'AAAAAAA',
      photo27Url: 'AAAAAAA',
      photo28Url: 'AAAAAAA',
      photo29Url: 'AAAAAAA',
      photo30Url: 'AAAAAAA',
      photo31Url: 'AAAAAAA',
      photo32Url: 'AAAAAAA',
      photo33Url: 'AAAAAAA',
      photo34Url: 'AAAAAAA',
      photo35Url: 'AAAAAAA',
      photo36Url: 'AAAAAAA',
      photo37Url: 'AAAAAAA',
      photo38Url: 'AAAAAAA',
      photo39Url: 'AAAAAAA',
      photo40Url: 'AAAAAAA',
      created: currentDate,
      updated: currentDate,
      modifiedDate: currentDate,
      imgDeleted: false,
      retsServer: 'AAAAAAA',
      permalink: 'AAAAAAA',
      propertyTag: 'AAAAAAA',
      buildentoryViews: 0,
      location: 'AAAAAAA',
    };
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = Object.assign(
        {
          modified: currentDate.format(DATE_TIME_FORMAT),
          openhousedate: currentDate.format(DATE_TIME_FORMAT),
          created: currentDate.format(DATE_TIME_FORMAT),
          updated: currentDate.format(DATE_TIME_FORMAT),
          modifiedDate: currentDate.format(DATE_TIME_FORMAT),
        },
        elemDefault
      );

      service.find(123).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(elemDefault);
    });

    it('should create a ResProperties', () => {
      const returnedFromService = Object.assign(
        {
          id: 0,
          modified: currentDate.format(DATE_TIME_FORMAT),
          openhousedate: currentDate.format(DATE_TIME_FORMAT),
          created: currentDate.format(DATE_TIME_FORMAT),
          updated: currentDate.format(DATE_TIME_FORMAT),
          modifiedDate: currentDate.format(DATE_TIME_FORMAT),
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          modified: currentDate,
          openhousedate: currentDate,
          created: currentDate,
          updated: currentDate,
          modifiedDate: currentDate,
        },
        returnedFromService
      );

      service.create(new ResProperties()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a ResProperties', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          communityId: 1,
          communityName: 'BBBBBB',
          builderId: 1,
          specialOffers: 'BBBBBB',
          brochure: 'BBBBBB',
          floorPlanId: 1,
          latitude: 'BBBBBB',
          longitude: 'BBBBBB',
          county: 'BBBBBB',
          heatsystem: 'BBBBBB',
          liststatus: 'BBBBBB',
          liststatusflag: 'BBBBBB',
          carportcap: 'BBBBBB',
          possession: 'BBBBBB',
          schoolname1: 'BBBBBB',
          subdivide: 'BBBBBB',
          vowavmyn: 'BBBBBB',
          presentuse: 'BBBBBB',
          proposeduse: 'BBBBBB',
          ranchname: 'BBBBBB',
          roombed2width: 1,
          roomdininglevel: 'BBBBBB',
          roomliving2width: 1,
          roomstudylevel: 'BBBBBB',
          area: 1,
          areatitle: 'BBBBBB',
          assocfee: 1,
          financeproposed: 'BBBBBB',
          listpriceorig: 1,
          mapcoord: 'BBBBBB',
          schoolname2: 'BBBBBB',
          roomgaragewidth: 1,
          roomkitchendesc: 'BBBBBB',
          roomliving1width: 1,
          roomother2width: 1,
          sqfttotal: 1,
          officelistOfficenam1: 'BBBBBB',
          schoolname3: 'BBBBBB',
          zipcode: 'BBBBBB',
          barn1length: 1,
          barn3width: 1,
          roombed2length: 1,
          roombed3length: 1,
          roomother1width: 1,
          agentlistFullname: 'BBBBBB',
          proptype: 'BBBBBB',
          mlsProptype: 'BBBBBB',
          schoolname4: 'BBBBBB',
          acrescultivated: 1,
          barn2length: 1,
          barn2width: 1,
          complexname: 'BBBBBB',
          roombed4length: 1,
          roombedbathdesc: 'BBBBBB',
          roombreakfastwidth: 1,
          roomother: 'BBBBBB',
          roomutilitylength: 1,
          acres: 1,
          block: 'BBBBBB',
          directions: 'BBBBBB',
          subdivision: 'BBBBBB',
          yearbuilt: 1,
          yearbuiltdetails: 'BBBBBB',
          agexemption: 'BBBBBB',
          barn1width: 1,
          barn3length: 1,
          roomdiningwidth: 1,
          roomstudywidth: 1,
          soiltype: 'BBBBBB',
          appraisername: 'BBBBBB',
          listpricelow: 1,
          mappage: 'BBBBBB',
          unitnumber: 'BBBBBB',
          streetdir: 'BBBBBB',
          streettype: 'BBBBBB',
          subarea: 'BBBBBB',
          subareatitle: 'BBBBBB',
          bathshalf: 1,
          roomgaragelength: 1,
          propsubtype: 'BBBBBB',
          beds: 1,
          roommasterbedwidth: 1,
          roomstudylength: 1,
          agentlist: 'BBBBBB',
          streetname: 'BBBBBB',
          roombreakfastlength: 1,
          roomkitchenwidth: 1,
          fence: 'BBBBBB',
          bathstotal: 1,
          garagecap: 1,
          sqftprice: 1,
          style: 'BBBBBB',
          exterior: 'BBBBBB',
          foundation: 'BBBBBB',
          interior: 'BBBBBB',
          poolyn: 'BBBBBB',
          poolFeature: 'BBBBBB',
          listprice: 1,
          listpricerange: 'BBBBBB',
          mlsnum: 'BBBBBB',
          matrixid: 1,
          remarks: 'BBBBBB',
          state: 'BBBBBB',
          roof: 'BBBBBB',
          securityfeatures: 'BBBBBB',
          utilitiesother: 'BBBBBB',
          commonfeatures: 'BBBBBB',
          construction: 'BBBBBB',
          modified: currentDate.format(DATE_TIME_FORMAT),
          stories: 1,
          roomdininglength: 1,
          roomliving1length: 1,
          openhousetime: 'BBBBBB',
          openhouseendtime: 'BBBBBB',
          roomliving2length: 1,
          lotdesc: 'BBBBBB',
          openhousedate: currentDate.format(DATE_TIME_FORMAT),
          roommasterbedlength: 1,
          roomother1length: 1,
          officesellOfficenam2: 'BBBBBB',
          lotsize: 'BBBBBB',
          streetdirsuffix: 'BBBBBB',
          photocount: 1,
          schooldistrict: 'BBBBBB',
          streetnum: 1,
          utilities: 'BBBBBB',
          equipment: 'BBBBBB',
          roombed4width: 1,
          roomkitchenlength: 1,
          city: 'BBBBBB',
          garagedesc: 'BBBBBB',
          bathsfull: 1,
          roombed3width: 1,
          roomutildesc: 'BBBBBB',
          roomutilitywidth: 1,
          roomfullbathlength: 'BBBBBB',
          roomfullbathwidth: 'BBBBBB',
          roomhalfbathlength: 'BBBBBB',
          roomhalfbathwidth: 'BBBBBB',
          roomexerciselength: 'BBBBBB',
          roomexercisewidth: 'BBBBBB',
          roomstoragelength: 'BBBBBB',
          roomstoragewidth: 'BBBBBB',
          roomgamelength: 'BBBBBB',
          roomgamewidth: 'BBBBBB',
          roomguestlength: 'BBBBBB',
          roomguestwidth: 'BBBBBB',
          roomlibrarylength: 'BBBBBB',
          roomlibrarywidth: 'BBBBBB',
          roommedialength: 'BBBBBB',
          roommediawidth: 'BBBBBB',
          roommudlength: 'BBBBBB',
          roommudwidth: 'BBBBBB',
          roomofficelength: 'BBBBBB',
          roomofficewidth: 'BBBBBB',
          roomsaunalength: 'BBBBBB',
          roomsaunawidth: 'BBBBBB',
          roomsecondmasterlength: 'BBBBBB',
          roomsecondmasterwidth: 'BBBBBB',
          roomsunlength: 'BBBBBB',
          roomsunwidth: 'BBBBBB',
          roomspalength: 'BBBBBB',
          roomspawidth: 'BBBBBB',
          roomwinelength: 'BBBBBB',
          roomwinewidth: 'BBBBBB',
          juniorhighschoolname: 'BBBBBB',
          primaryschoolname: 'BBBBBB',
          seniorhighschoolname: 'BBBBBB',
          associationfee: 'BBBBBB',
          associationfeefrequency: 'BBBBBB',
          constructionmaterials: 'BBBBBB',
          heating: 'BBBBBB',
          accessoryunittype: 'BBBBBB',
          accessoryunityn: 'BBBBBB',
          flooring: 'BBBBBB',
          fireplacestotal: 'BBBBBB',
          fireplacefeatures: 'BBBBBB',
          securitysystemyn: 'BBBBBB',
          greenbuildingcertification: 'BBBBBB',
          greenenergyefficient: 'BBBBBB',
          energysavingfeatures: 'BBBBBB',
          lotnumber: 'BBBBBB',
          lotsizearea: 'BBBBBB',
          lotsizedimensions: 'BBBBBB',
          easements: 'BBBBBB',
          restrictions: 'BBBBBB',
          washerdryerconnections: 'BBBBBB',
          municipalutilitydistrictyn: 'BBBBBB',
          associationfeeincludes: 'BBBBBB',
          associationtype: 'BBBBBB',
          barninformation: 'BBBBBB',
          constructionmaterialswalls: 'BBBBBB',
          countyorparish: 'BBBBBB',
          exteriorbuildings: 'BBBBBB',
          farmranchfeatures: 'BBBBBB',
          fencedyardyn: 'BBBBBB',
          financingproposed: 'BBBBBB',
          handicapyn: 'BBBBBB',
          numberoftanksandponds: 'BBBBBB',
          parcelnumber: 'BBBBBB',
          virtualtoururlunbranded: 'BBBBBB',
          livingRoomFeature: 'BBBBBB',
          masterBedRoomFeature: 'BBBBBB',
          bedRoomFeature: 'BBBBBB',
          diningRoomFeature: 'BBBBBB',
          kitchenRoomFeature: 'BBBBBB',
          breakfastRoomFeature: 'BBBBBB',
          studyRoomFeature: 'BBBBBB',
          utilityRoomFeature: 'BBBBBB',
          fullBathRoomFeature: 'BBBBBB',
          halfBathRoomFeature: 'BBBBBB',
          exerciseRoomFeature: 'BBBBBB',
          extraStorageRoomFeature: 'BBBBBB',
          gameRoomFeature: 'BBBBBB',
          guestRoomFeature: 'BBBBBB',
          libraryRoomFeature: 'BBBBBB',
          mediaRoomFeature: 'BBBBBB',
          mudRoomFeature: 'BBBBBB',
          officeRoomFeature: 'BBBBBB',
          saunaRoomFeature: 'BBBBBB',
          secondMasterRoomFeature: 'BBBBBB',
          sunroomRoomFeature: 'BBBBBB',
          spaRoomFeature: 'BBBBBB',
          wineRoomFeature: 'BBBBBB',
          otherRoomFeature: 'BBBBBB',
          isLuxury: 'BBBBBB',
          isMoveInReady: 'BBBBBB',
          photoUrl: 'BBBBBB',
          photo1Url: 'BBBBBB',
          photo2Url: 'BBBBBB',
          photo3Url: 'BBBBBB',
          photo4Url: 'BBBBBB',
          photo5Url: 'BBBBBB',
          photo6Url: 'BBBBBB',
          photo7Url: 'BBBBBB',
          photo8Url: 'BBBBBB',
          photo9Url: 'BBBBBB',
          photo10Url: 'BBBBBB',
          photo11Url: 'BBBBBB',
          photo12Url: 'BBBBBB',
          photo13Url: 'BBBBBB',
          photo14Url: 'BBBBBB',
          photo15Url: 'BBBBBB',
          photo16Url: 'BBBBBB',
          photo17Url: 'BBBBBB',
          photo18Url: 'BBBBBB',
          photo19Url: 'BBBBBB',
          photo20Url: 'BBBBBB',
          photo21Url: 'BBBBBB',
          photo22Url: 'BBBBBB',
          photo23Url: 'BBBBBB',
          photo24Url: 'BBBBBB',
          photo25Url: 'BBBBBB',
          photo26Url: 'BBBBBB',
          photo27Url: 'BBBBBB',
          photo28Url: 'BBBBBB',
          photo29Url: 'BBBBBB',
          photo30Url: 'BBBBBB',
          photo31Url: 'BBBBBB',
          photo32Url: 'BBBBBB',
          photo33Url: 'BBBBBB',
          photo34Url: 'BBBBBB',
          photo35Url: 'BBBBBB',
          photo36Url: 'BBBBBB',
          photo37Url: 'BBBBBB',
          photo38Url: 'BBBBBB',
          photo39Url: 'BBBBBB',
          photo40Url: 'BBBBBB',
          created: currentDate.format(DATE_TIME_FORMAT),
          updated: currentDate.format(DATE_TIME_FORMAT),
          modifiedDate: currentDate.format(DATE_TIME_FORMAT),
          imgDeleted: true,
          retsServer: 'BBBBBB',
          permalink: 'BBBBBB',
          propertyTag: 'BBBBBB',
          buildentoryViews: 1,
          location: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          modified: currentDate,
          openhousedate: currentDate,
          created: currentDate,
          updated: currentDate,
          modifiedDate: currentDate,
        },
        returnedFromService
      );

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a ResProperties', () => {
      const patchObject = Object.assign(
        {
          communityId: 1,
          builderId: 1,
          specialOffers: 'BBBBBB',
          latitude: 'BBBBBB',
          longitude: 'BBBBBB',
          heatsystem: 'BBBBBB',
          liststatus: 'BBBBBB',
          subdivide: 'BBBBBB',
          vowavmyn: 'BBBBBB',
          presentuse: 'BBBBBB',
          ranchname: 'BBBBBB',
          roombed2width: 1,
          roomdininglevel: 'BBBBBB',
          roomliving2width: 1,
          area: 1,
          assocfee: 1,
          financeproposed: 'BBBBBB',
          listpriceorig: 1,
          mapcoord: 'BBBBBB',
          officelistOfficenam1: 'BBBBBB',
          zipcode: 'BBBBBB',
          barn1length: 1,
          roombed3length: 1,
          roomother1width: 1,
          proptype: 'BBBBBB',
          mlsProptype: 'BBBBBB',
          acrescultivated: 1,
          barn2length: 1,
          complexname: 'BBBBBB',
          roombed4length: 1,
          roombreakfastwidth: 1,
          roomutilitylength: 1,
          acres: 1,
          yearbuiltdetails: 'BBBBBB',
          barn3length: 1,
          roomstudywidth: 1,
          listpricelow: 1,
          streetdir: 'BBBBBB',
          roommasterbedwidth: 1,
          roomstudylength: 1,
          roombreakfastlength: 1,
          sqftprice: 1,
          style: 'BBBBBB',
          exterior: 'BBBBBB',
          poolyn: 'BBBBBB',
          poolFeature: 'BBBBBB',
          listprice: 1,
          matrixid: 1,
          state: 'BBBBBB',
          securityfeatures: 'BBBBBB',
          utilitiesother: 'BBBBBB',
          commonfeatures: 'BBBBBB',
          openhouseendtime: 'BBBBBB',
          roomliving2length: 1,
          lotdesc: 'BBBBBB',
          openhousedate: currentDate.format(DATE_TIME_FORMAT),
          roommasterbedlength: 1,
          roomother1length: 1,
          officesellOfficenam2: 'BBBBBB',
          photocount: 1,
          streetnum: 1,
          roombed4width: 1,
          roomkitchenlength: 1,
          garagedesc: 'BBBBBB',
          roombed3width: 1,
          roomutildesc: 'BBBBBB',
          roomfullbathlength: 'BBBBBB',
          roomfullbathwidth: 'BBBBBB',
          roomhalfbathlength: 'BBBBBB',
          roomexerciselength: 'BBBBBB',
          roomstoragewidth: 'BBBBBB',
          roomgamelength: 'BBBBBB',
          roomguestlength: 'BBBBBB',
          roomlibrarywidth: 'BBBBBB',
          roommediawidth: 'BBBBBB',
          roommudwidth: 'BBBBBB',
          roomofficewidth: 'BBBBBB',
          roomsaunalength: 'BBBBBB',
          roomsunwidth: 'BBBBBB',
          roomspawidth: 'BBBBBB',
          roomwinelength: 'BBBBBB',
          roomwinewidth: 'BBBBBB',
          juniorhighschoolname: 'BBBBBB',
          primaryschoolname: 'BBBBBB',
          seniorhighschoolname: 'BBBBBB',
          associationfee: 'BBBBBB',
          associationfeefrequency: 'BBBBBB',
          constructionmaterials: 'BBBBBB',
          heating: 'BBBBBB',
          accessoryunittype: 'BBBBBB',
          securitysystemyn: 'BBBBBB',
          greenenergyefficient: 'BBBBBB',
          lotnumber: 'BBBBBB',
          lotsizearea: 'BBBBBB',
          easements: 'BBBBBB',
          restrictions: 'BBBBBB',
          washerdryerconnections: 'BBBBBB',
          municipalutilitydistrictyn: 'BBBBBB',
          associationtype: 'BBBBBB',
          constructionmaterialswalls: 'BBBBBB',
          financingproposed: 'BBBBBB',
          handicapyn: 'BBBBBB',
          parcelnumber: 'BBBBBB',
          virtualtoururlunbranded: 'BBBBBB',
          masterBedRoomFeature: 'BBBBBB',
          diningRoomFeature: 'BBBBBB',
          breakfastRoomFeature: 'BBBBBB',
          studyRoomFeature: 'BBBBBB',
          utilityRoomFeature: 'BBBBBB',
          fullBathRoomFeature: 'BBBBBB',
          halfBathRoomFeature: 'BBBBBB',
          libraryRoomFeature: 'BBBBBB',
          officeRoomFeature: 'BBBBBB',
          secondMasterRoomFeature: 'BBBBBB',
          spaRoomFeature: 'BBBBBB',
          otherRoomFeature: 'BBBBBB',
          photoUrl: 'BBBBBB',
          photo1Url: 'BBBBBB',
          photo2Url: 'BBBBBB',
          photo3Url: 'BBBBBB',
          photo7Url: 'BBBBBB',
          photo8Url: 'BBBBBB',
          photo9Url: 'BBBBBB',
          photo14Url: 'BBBBBB',
          photo18Url: 'BBBBBB',
          photo20Url: 'BBBBBB',
          photo28Url: 'BBBBBB',
          photo29Url: 'BBBBBB',
          photo30Url: 'BBBBBB',
          photo31Url: 'BBBBBB',
          photo33Url: 'BBBBBB',
          photo35Url: 'BBBBBB',
          photo36Url: 'BBBBBB',
          photo38Url: 'BBBBBB',
          photo39Url: 'BBBBBB',
          created: currentDate.format(DATE_TIME_FORMAT),
          updated: currentDate.format(DATE_TIME_FORMAT),
          modifiedDate: currentDate.format(DATE_TIME_FORMAT),
          imgDeleted: true,
          permalink: 'BBBBBB',
          propertyTag: 'BBBBBB',
          buildentoryViews: 1,
          location: 'BBBBBB',
        },
        new ResProperties()
      );

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign(
        {
          modified: currentDate,
          openhousedate: currentDate,
          created: currentDate,
          updated: currentDate,
          modifiedDate: currentDate,
        },
        returnedFromService
      );

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of ResProperties', () => {
      const returnedFromService = Object.assign(
        {
          id: 1,
          communityId: 1,
          communityName: 'BBBBBB',
          builderId: 1,
          specialOffers: 'BBBBBB',
          brochure: 'BBBBBB',
          floorPlanId: 1,
          latitude: 'BBBBBB',
          longitude: 'BBBBBB',
          county: 'BBBBBB',
          heatsystem: 'BBBBBB',
          liststatus: 'BBBBBB',
          liststatusflag: 'BBBBBB',
          carportcap: 'BBBBBB',
          possession: 'BBBBBB',
          schoolname1: 'BBBBBB',
          subdivide: 'BBBBBB',
          vowavmyn: 'BBBBBB',
          presentuse: 'BBBBBB',
          proposeduse: 'BBBBBB',
          ranchname: 'BBBBBB',
          roombed2width: 1,
          roomdininglevel: 'BBBBBB',
          roomliving2width: 1,
          roomstudylevel: 'BBBBBB',
          area: 1,
          areatitle: 'BBBBBB',
          assocfee: 1,
          financeproposed: 'BBBBBB',
          listpriceorig: 1,
          mapcoord: 'BBBBBB',
          schoolname2: 'BBBBBB',
          roomgaragewidth: 1,
          roomkitchendesc: 'BBBBBB',
          roomliving1width: 1,
          roomother2width: 1,
          sqfttotal: 1,
          officelistOfficenam1: 'BBBBBB',
          schoolname3: 'BBBBBB',
          zipcode: 'BBBBBB',
          barn1length: 1,
          barn3width: 1,
          roombed2length: 1,
          roombed3length: 1,
          roomother1width: 1,
          agentlistFullname: 'BBBBBB',
          proptype: 'BBBBBB',
          mlsProptype: 'BBBBBB',
          schoolname4: 'BBBBBB',
          acrescultivated: 1,
          barn2length: 1,
          barn2width: 1,
          complexname: 'BBBBBB',
          roombed4length: 1,
          roombedbathdesc: 'BBBBBB',
          roombreakfastwidth: 1,
          roomother: 'BBBBBB',
          roomutilitylength: 1,
          acres: 1,
          block: 'BBBBBB',
          directions: 'BBBBBB',
          subdivision: 'BBBBBB',
          yearbuilt: 1,
          yearbuiltdetails: 'BBBBBB',
          agexemption: 'BBBBBB',
          barn1width: 1,
          barn3length: 1,
          roomdiningwidth: 1,
          roomstudywidth: 1,
          soiltype: 'BBBBBB',
          appraisername: 'BBBBBB',
          listpricelow: 1,
          mappage: 'BBBBBB',
          unitnumber: 'BBBBBB',
          streetdir: 'BBBBBB',
          streettype: 'BBBBBB',
          subarea: 'BBBBBB',
          subareatitle: 'BBBBBB',
          bathshalf: 1,
          roomgaragelength: 1,
          propsubtype: 'BBBBBB',
          beds: 1,
          roommasterbedwidth: 1,
          roomstudylength: 1,
          agentlist: 'BBBBBB',
          streetname: 'BBBBBB',
          roombreakfastlength: 1,
          roomkitchenwidth: 1,
          fence: 'BBBBBB',
          bathstotal: 1,
          garagecap: 1,
          sqftprice: 1,
          style: 'BBBBBB',
          exterior: 'BBBBBB',
          foundation: 'BBBBBB',
          interior: 'BBBBBB',
          poolyn: 'BBBBBB',
          poolFeature: 'BBBBBB',
          listprice: 1,
          listpricerange: 'BBBBBB',
          mlsnum: 'BBBBBB',
          matrixid: 1,
          remarks: 'BBBBBB',
          state: 'BBBBBB',
          roof: 'BBBBBB',
          securityfeatures: 'BBBBBB',
          utilitiesother: 'BBBBBB',
          commonfeatures: 'BBBBBB',
          construction: 'BBBBBB',
          modified: currentDate.format(DATE_TIME_FORMAT),
          stories: 1,
          roomdininglength: 1,
          roomliving1length: 1,
          openhousetime: 'BBBBBB',
          openhouseendtime: 'BBBBBB',
          roomliving2length: 1,
          lotdesc: 'BBBBBB',
          openhousedate: currentDate.format(DATE_TIME_FORMAT),
          roommasterbedlength: 1,
          roomother1length: 1,
          officesellOfficenam2: 'BBBBBB',
          lotsize: 'BBBBBB',
          streetdirsuffix: 'BBBBBB',
          photocount: 1,
          schooldistrict: 'BBBBBB',
          streetnum: 1,
          utilities: 'BBBBBB',
          equipment: 'BBBBBB',
          roombed4width: 1,
          roomkitchenlength: 1,
          city: 'BBBBBB',
          garagedesc: 'BBBBBB',
          bathsfull: 1,
          roombed3width: 1,
          roomutildesc: 'BBBBBB',
          roomutilitywidth: 1,
          roomfullbathlength: 'BBBBBB',
          roomfullbathwidth: 'BBBBBB',
          roomhalfbathlength: 'BBBBBB',
          roomhalfbathwidth: 'BBBBBB',
          roomexerciselength: 'BBBBBB',
          roomexercisewidth: 'BBBBBB',
          roomstoragelength: 'BBBBBB',
          roomstoragewidth: 'BBBBBB',
          roomgamelength: 'BBBBBB',
          roomgamewidth: 'BBBBBB',
          roomguestlength: 'BBBBBB',
          roomguestwidth: 'BBBBBB',
          roomlibrarylength: 'BBBBBB',
          roomlibrarywidth: 'BBBBBB',
          roommedialength: 'BBBBBB',
          roommediawidth: 'BBBBBB',
          roommudlength: 'BBBBBB',
          roommudwidth: 'BBBBBB',
          roomofficelength: 'BBBBBB',
          roomofficewidth: 'BBBBBB',
          roomsaunalength: 'BBBBBB',
          roomsaunawidth: 'BBBBBB',
          roomsecondmasterlength: 'BBBBBB',
          roomsecondmasterwidth: 'BBBBBB',
          roomsunlength: 'BBBBBB',
          roomsunwidth: 'BBBBBB',
          roomspalength: 'BBBBBB',
          roomspawidth: 'BBBBBB',
          roomwinelength: 'BBBBBB',
          roomwinewidth: 'BBBBBB',
          juniorhighschoolname: 'BBBBBB',
          primaryschoolname: 'BBBBBB',
          seniorhighschoolname: 'BBBBBB',
          associationfee: 'BBBBBB',
          associationfeefrequency: 'BBBBBB',
          constructionmaterials: 'BBBBBB',
          heating: 'BBBBBB',
          accessoryunittype: 'BBBBBB',
          accessoryunityn: 'BBBBBB',
          flooring: 'BBBBBB',
          fireplacestotal: 'BBBBBB',
          fireplacefeatures: 'BBBBBB',
          securitysystemyn: 'BBBBBB',
          greenbuildingcertification: 'BBBBBB',
          greenenergyefficient: 'BBBBBB',
          energysavingfeatures: 'BBBBBB',
          lotnumber: 'BBBBBB',
          lotsizearea: 'BBBBBB',
          lotsizedimensions: 'BBBBBB',
          easements: 'BBBBBB',
          restrictions: 'BBBBBB',
          washerdryerconnections: 'BBBBBB',
          municipalutilitydistrictyn: 'BBBBBB',
          associationfeeincludes: 'BBBBBB',
          associationtype: 'BBBBBB',
          barninformation: 'BBBBBB',
          constructionmaterialswalls: 'BBBBBB',
          countyorparish: 'BBBBBB',
          exteriorbuildings: 'BBBBBB',
          farmranchfeatures: 'BBBBBB',
          fencedyardyn: 'BBBBBB',
          financingproposed: 'BBBBBB',
          handicapyn: 'BBBBBB',
          numberoftanksandponds: 'BBBBBB',
          parcelnumber: 'BBBBBB',
          virtualtoururlunbranded: 'BBBBBB',
          livingRoomFeature: 'BBBBBB',
          masterBedRoomFeature: 'BBBBBB',
          bedRoomFeature: 'BBBBBB',
          diningRoomFeature: 'BBBBBB',
          kitchenRoomFeature: 'BBBBBB',
          breakfastRoomFeature: 'BBBBBB',
          studyRoomFeature: 'BBBBBB',
          utilityRoomFeature: 'BBBBBB',
          fullBathRoomFeature: 'BBBBBB',
          halfBathRoomFeature: 'BBBBBB',
          exerciseRoomFeature: 'BBBBBB',
          extraStorageRoomFeature: 'BBBBBB',
          gameRoomFeature: 'BBBBBB',
          guestRoomFeature: 'BBBBBB',
          libraryRoomFeature: 'BBBBBB',
          mediaRoomFeature: 'BBBBBB',
          mudRoomFeature: 'BBBBBB',
          officeRoomFeature: 'BBBBBB',
          saunaRoomFeature: 'BBBBBB',
          secondMasterRoomFeature: 'BBBBBB',
          sunroomRoomFeature: 'BBBBBB',
          spaRoomFeature: 'BBBBBB',
          wineRoomFeature: 'BBBBBB',
          otherRoomFeature: 'BBBBBB',
          isLuxury: 'BBBBBB',
          isMoveInReady: 'BBBBBB',
          photoUrl: 'BBBBBB',
          photo1Url: 'BBBBBB',
          photo2Url: 'BBBBBB',
          photo3Url: 'BBBBBB',
          photo4Url: 'BBBBBB',
          photo5Url: 'BBBBBB',
          photo6Url: 'BBBBBB',
          photo7Url: 'BBBBBB',
          photo8Url: 'BBBBBB',
          photo9Url: 'BBBBBB',
          photo10Url: 'BBBBBB',
          photo11Url: 'BBBBBB',
          photo12Url: 'BBBBBB',
          photo13Url: 'BBBBBB',
          photo14Url: 'BBBBBB',
          photo15Url: 'BBBBBB',
          photo16Url: 'BBBBBB',
          photo17Url: 'BBBBBB',
          photo18Url: 'BBBBBB',
          photo19Url: 'BBBBBB',
          photo20Url: 'BBBBBB',
          photo21Url: 'BBBBBB',
          photo22Url: 'BBBBBB',
          photo23Url: 'BBBBBB',
          photo24Url: 'BBBBBB',
          photo25Url: 'BBBBBB',
          photo26Url: 'BBBBBB',
          photo27Url: 'BBBBBB',
          photo28Url: 'BBBBBB',
          photo29Url: 'BBBBBB',
          photo30Url: 'BBBBBB',
          photo31Url: 'BBBBBB',
          photo32Url: 'BBBBBB',
          photo33Url: 'BBBBBB',
          photo34Url: 'BBBBBB',
          photo35Url: 'BBBBBB',
          photo36Url: 'BBBBBB',
          photo37Url: 'BBBBBB',
          photo38Url: 'BBBBBB',
          photo39Url: 'BBBBBB',
          photo40Url: 'BBBBBB',
          created: currentDate.format(DATE_TIME_FORMAT),
          updated: currentDate.format(DATE_TIME_FORMAT),
          modifiedDate: currentDate.format(DATE_TIME_FORMAT),
          imgDeleted: true,
          retsServer: 'BBBBBB',
          permalink: 'BBBBBB',
          propertyTag: 'BBBBBB',
          buildentoryViews: 1,
          location: 'BBBBBB',
        },
        elemDefault
      );

      const expected = Object.assign(
        {
          modified: currentDate,
          openhousedate: currentDate,
          created: currentDate,
          updated: currentDate,
          modifiedDate: currentDate,
        },
        returnedFromService
      );

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toContainEqual(expected);
    });

    it('should delete a ResProperties', () => {
      service.delete(123).subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addResPropertiesToCollectionIfMissing', () => {
      it('should add a ResProperties to an empty array', () => {
        const resProperties: IResProperties = { id: 123 };
        expectedResult = service.addResPropertiesToCollectionIfMissing([], resProperties);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(resProperties);
      });

      it('should not add a ResProperties to an array that contains it', () => {
        const resProperties: IResProperties = { id: 123 };
        const resPropertiesCollection: IResProperties[] = [
          {
            ...resProperties,
          },
          { id: 456 },
        ];
        expectedResult = service.addResPropertiesToCollectionIfMissing(resPropertiesCollection, resProperties);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a ResProperties to an array that doesn't contain it", () => {
        const resProperties: IResProperties = { id: 123 };
        const resPropertiesCollection: IResProperties[] = [{ id: 456 }];
        expectedResult = service.addResPropertiesToCollectionIfMissing(resPropertiesCollection, resProperties);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(resProperties);
      });

      it('should add only unique ResProperties to an array', () => {
        const resPropertiesArray: IResProperties[] = [{ id: 123 }, { id: 456 }, { id: 29362 }];
        const resPropertiesCollection: IResProperties[] = [{ id: 123 }];
        expectedResult = service.addResPropertiesToCollectionIfMissing(resPropertiesCollection, ...resPropertiesArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const resProperties: IResProperties = { id: 123 };
        const resProperties2: IResProperties = { id: 456 };
        expectedResult = service.addResPropertiesToCollectionIfMissing([], resProperties, resProperties2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(resProperties);
        expect(expectedResult).toContain(resProperties2);
      });

      it('should accept null and undefined values', () => {
        const resProperties: IResProperties = { id: 123 };
        expectedResult = service.addResPropertiesToCollectionIfMissing([], null, resProperties, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(resProperties);
      });

      it('should return initial array if no ResProperties is added', () => {
        const resPropertiesCollection: IResProperties[] = [{ id: 123 }];
        expectedResult = service.addResPropertiesToCollectionIfMissing(resPropertiesCollection, undefined, null);
        expect(expectedResult).toEqual(resPropertiesCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
