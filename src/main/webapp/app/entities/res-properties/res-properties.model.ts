import * as dayjs from 'dayjs';
import { IUserPropertyLink } from 'app/entities/user-property-link/user-property-link.model';

export interface IResProperties {
  id?: number;
  communityId?: number;
  communityName?: string;
  builderId?: number;
  specialOffers?: string;
  brochure?: string;
  floorPlanId?: number;
  latitude?: string | null;
  longitude?: string | null;
  county?: string | null;
  heatsystem?: string | null;
  liststatus?: string | null;
  liststatusflag?: string | null;
  carportcap?: string | null;
  possession?: string | null;
  schoolname1?: string | null;
  subdivide?: string | null;
  vowavmyn?: string | null;
  presentuse?: string | null;
  proposeduse?: string | null;
  ranchname?: string | null;
  roombed2width?: number | null;
  roomdininglevel?: string | null;
  roomliving2width?: number | null;
  roomstudylevel?: string | null;
  area?: number | null;
  areatitle?: string | null;
  assocfee?: number | null;
  financeproposed?: string | null;
  listpriceorig?: number | null;
  mapcoord?: string | null;
  schoolname2?: string | null;
  roomgaragewidth?: number | null;
  roomkitchendesc?: string | null;
  roomliving1width?: number | null;
  roomother2width?: number | null;
  sqfttotal?: number | null;
  officelistOfficenam1?: string | null;
  schoolname3?: string | null;
  zipcode?: string | null;
  barn1length?: number | null;
  barn3width?: number | null;
  roombed2length?: number | null;
  roombed3length?: number | null;
  roomother1width?: number | null;
  agentlistFullname?: string | null;
  proptype?: string | null;
  mlsProptype?: string;
  schoolname4?: string | null;
  acrescultivated?: number | null;
  barn2length?: number | null;
  barn2width?: number | null;
  complexname?: string | null;
  roombed4length?: number | null;
  roombedbathdesc?: string | null;
  roombreakfastwidth?: number | null;
  roomother?: string | null;
  roomutilitylength?: number | null;
  acres?: number | null;
  block?: string | null;
  directions?: string | null;
  subdivision?: string | null;
  yearbuilt?: number | null;
  yearbuiltdetails?: string;
  agexemption?: string | null;
  barn1width?: number | null;
  barn3length?: number | null;
  roomdiningwidth?: number | null;
  roomstudywidth?: number | null;
  soiltype?: string | null;
  appraisername?: string | null;
  listpricelow?: number | null;
  mappage?: string | null;
  unitnumber?: string;
  streetdir?: string | null;
  streettype?: string | null;
  subarea?: string | null;
  subareatitle?: string | null;
  bathshalf?: number | null;
  roomgaragelength?: number | null;
  propsubtype?: string | null;
  beds?: number | null;
  roommasterbedwidth?: number | null;
  roomstudylength?: number | null;
  agentlist?: string | null;
  streetname?: string | null;
  roombreakfastlength?: number | null;
  roomkitchenwidth?: number | null;
  fence?: string | null;
  bathstotal?: number | null;
  garagecap?: number | null;
  sqftprice?: number | null;
  style?: string | null;
  exterior?: string | null;
  foundation?: string | null;
  interior?: string | null;
  poolyn?: string | null;
  poolFeature?: string;
  listprice?: number | null;
  listpricerange?: string | null;
  mlsnum?: string;
  matrixid?: number;
  remarks?: string | null;
  state?: string | null;
  roof?: string | null;
  securityfeatures?: string;
  utilitiesother?: string;
  commonfeatures?: string | null;
  construction?: string | null;
  modified?: dayjs.Dayjs;
  stories?: number | null;
  roomdininglength?: number | null;
  roomliving1length?: number | null;
  openhousetime?: string | null;
  openhouseendtime?: string;
  roomliving2length?: number | null;
  lotdesc?: string | null;
  openhousedate?: dayjs.Dayjs | null;
  roommasterbedlength?: number | null;
  roomother1length?: number | null;
  officesellOfficenam2?: string | null;
  lotsize?: string | null;
  streetdirsuffix?: string | null;
  photocount?: number | null;
  schooldistrict?: string | null;
  streetnum?: number | null;
  utilities?: string | null;
  equipment?: string | null;
  roombed4width?: number | null;
  roomkitchenlength?: number | null;
  city?: string | null;
  garagedesc?: string | null;
  bathsfull?: number | null;
  roombed3width?: number | null;
  roomutildesc?: string | null;
  roomutilitywidth?: number | null;
  roomfullbathlength?: string;
  roomfullbathwidth?: string;
  roomhalfbathlength?: string;
  roomhalfbathwidth?: string;
  roomexerciselength?: string;
  roomexercisewidth?: string;
  roomstoragelength?: string;
  roomstoragewidth?: string;
  roomgamelength?: string;
  roomgamewidth?: string;
  roomguestlength?: string;
  roomguestwidth?: string;
  roomlibrarylength?: string;
  roomlibrarywidth?: string;
  roommedialength?: string;
  roommediawidth?: string;
  roommudlength?: string;
  roommudwidth?: string;
  roomofficelength?: string;
  roomofficewidth?: string;
  roomsaunalength?: string;
  roomsaunawidth?: string;
  roomsecondmasterlength?: string;
  roomsecondmasterwidth?: string;
  roomsunlength?: string;
  roomsunwidth?: string;
  roomspalength?: string;
  roomspawidth?: string;
  roomwinelength?: string;
  roomwinewidth?: string;
  juniorhighschoolname?: string;
  primaryschoolname?: string;
  seniorhighschoolname?: string;
  associationfee?: string;
  associationfeefrequency?: string;
  constructionmaterials?: string;
  heating?: string;
  accessoryunittype?: string;
  accessoryunityn?: string;
  flooring?: string;
  fireplacestotal?: string;
  fireplacefeatures?: string;
  securitysystemyn?: string;
  greenbuildingcertification?: string;
  greenenergyefficient?: string;
  energysavingfeatures?: string;
  lotnumber?: string;
  lotsizearea?: string;
  lotsizedimensions?: string;
  easements?: string;
  restrictions?: string;
  washerdryerconnections?: string;
  municipalutilitydistrictyn?: string;
  associationfeeincludes?: string;
  associationtype?: string;
  barninformation?: string;
  constructionmaterialswalls?: string;
  countyorparish?: string;
  exteriorbuildings?: string;
  farmranchfeatures?: string;
  fencedyardyn?: string;
  financingproposed?: string;
  handicapyn?: string;
  numberoftanksandponds?: string;
  parcelnumber?: string;
  virtualtoururlunbranded?: string;
  livingRoomFeature?: string;
  masterBedRoomFeature?: string;
  bedRoomFeature?: string;
  diningRoomFeature?: string;
  kitchenRoomFeature?: string;
  breakfastRoomFeature?: string;
  studyRoomFeature?: string;
  utilityRoomFeature?: string;
  fullBathRoomFeature?: string;
  halfBathRoomFeature?: string;
  exerciseRoomFeature?: string;
  extraStorageRoomFeature?: string;
  gameRoomFeature?: string;
  guestRoomFeature?: string;
  libraryRoomFeature?: string;
  mediaRoomFeature?: string;
  mudRoomFeature?: string;
  officeRoomFeature?: string;
  saunaRoomFeature?: string;
  secondMasterRoomFeature?: string;
  sunroomRoomFeature?: string;
  spaRoomFeature?: string;
  wineRoomFeature?: string;
  otherRoomFeature?: string;
  isLuxury?: string;
  isMoveInReady?: string;
  photoUrl?: string | null;
  photo1Url?: string;
  photo2Url?: string;
  photo3Url?: string;
  photo4Url?: string;
  photo5Url?: string;
  photo6Url?: string;
  photo7Url?: string;
  photo8Url?: string;
  photo9Url?: string;
  photo10Url?: string;
  photo11Url?: string;
  photo12Url?: string;
  photo13Url?: string;
  photo14Url?: string;
  photo15Url?: string;
  photo16Url?: string;
  photo17Url?: string;
  photo18Url?: string;
  photo19Url?: string;
  photo20Url?: string;
  photo21Url?: string;
  photo22Url?: string;
  photo23Url?: string;
  photo24Url?: string;
  photo25Url?: string;
  photo26Url?: string;
  photo27Url?: string;
  photo28Url?: string;
  photo29Url?: string;
  photo30Url?: string;
  photo31Url?: string;
  photo32Url?: string;
  photo33Url?: string;
  photo34Url?: string;
  photo35Url?: string;
  photo36Url?: string;
  photo37Url?: string;
  photo38Url?: string;
  photo39Url?: string;
  photo40Url?: string;
  created?: dayjs.Dayjs | null;
  updated?: dayjs.Dayjs;
  modifiedDate?: dayjs.Dayjs;
  imgDeleted?: boolean;
  retsServer?: string | null;
  permalink?: string;
  propertyTag?: string;
  buildentoryViews?: number;
  location?: string;
  userPropertyLinks?: IUserPropertyLink[] | null;
}

export class ResProperties implements IResProperties {
  constructor(
    public id?: number,
    public communityId?: number,
    public communityName?: string,
    public builderId?: number,
    public specialOffers?: string,
    public brochure?: string,
    public floorPlanId?: number,
    public latitude?: string | null,
    public longitude?: string | null,
    public county?: string | null,
    public heatsystem?: string | null,
    public liststatus?: string | null,
    public liststatusflag?: string | null,
    public carportcap?: string | null,
    public possession?: string | null,
    public schoolname1?: string | null,
    public subdivide?: string | null,
    public vowavmyn?: string | null,
    public presentuse?: string | null,
    public proposeduse?: string | null,
    public ranchname?: string | null,
    public roombed2width?: number | null,
    public roomdininglevel?: string | null,
    public roomliving2width?: number | null,
    public roomstudylevel?: string | null,
    public area?: number | null,
    public areatitle?: string | null,
    public assocfee?: number | null,
    public financeproposed?: string | null,
    public listpriceorig?: number | null,
    public mapcoord?: string | null,
    public schoolname2?: string | null,
    public roomgaragewidth?: number | null,
    public roomkitchendesc?: string | null,
    public roomliving1width?: number | null,
    public roomother2width?: number | null,
    public sqfttotal?: number | null,
    public officelistOfficenam1?: string | null,
    public schoolname3?: string | null,
    public zipcode?: string | null,
    public barn1length?: number | null,
    public barn3width?: number | null,
    public roombed2length?: number | null,
    public roombed3length?: number | null,
    public roomother1width?: number | null,
    public agentlistFullname?: string | null,
    public proptype?: string | null,
    public mlsProptype?: string,
    public schoolname4?: string | null,
    public acrescultivated?: number | null,
    public barn2length?: number | null,
    public barn2width?: number | null,
    public complexname?: string | null,
    public roombed4length?: number | null,
    public roombedbathdesc?: string | null,
    public roombreakfastwidth?: number | null,
    public roomother?: string | null,
    public roomutilitylength?: number | null,
    public acres?: number | null,
    public block?: string | null,
    public directions?: string | null,
    public subdivision?: string | null,
    public yearbuilt?: number | null,
    public yearbuiltdetails?: string,
    public agexemption?: string | null,
    public barn1width?: number | null,
    public barn3length?: number | null,
    public roomdiningwidth?: number | null,
    public roomstudywidth?: number | null,
    public soiltype?: string | null,
    public appraisername?: string | null,
    public listpricelow?: number | null,
    public mappage?: string | null,
    public unitnumber?: string,
    public streetdir?: string | null,
    public streettype?: string | null,
    public subarea?: string | null,
    public subareatitle?: string | null,
    public bathshalf?: number | null,
    public roomgaragelength?: number | null,
    public propsubtype?: string | null,
    public beds?: number | null,
    public roommasterbedwidth?: number | null,
    public roomstudylength?: number | null,
    public agentlist?: string | null,
    public streetname?: string | null,
    public roombreakfastlength?: number | null,
    public roomkitchenwidth?: number | null,
    public fence?: string | null,
    public bathstotal?: number | null,
    public garagecap?: number | null,
    public sqftprice?: number | null,
    public style?: string | null,
    public exterior?: string | null,
    public foundation?: string | null,
    public interior?: string | null,
    public poolyn?: string | null,
    public poolFeature?: string,
    public listprice?: number | null,
    public listpricerange?: string | null,
    public mlsnum?: string,
    public matrixid?: number,
    public remarks?: string | null,
    public state?: string | null,
    public roof?: string | null,
    public securityfeatures?: string,
    public utilitiesother?: string,
    public commonfeatures?: string | null,
    public construction?: string | null,
    public modified?: dayjs.Dayjs,
    public stories?: number | null,
    public roomdininglength?: number | null,
    public roomliving1length?: number | null,
    public openhousetime?: string | null,
    public openhouseendtime?: string,
    public roomliving2length?: number | null,
    public lotdesc?: string | null,
    public openhousedate?: dayjs.Dayjs | null,
    public roommasterbedlength?: number | null,
    public roomother1length?: number | null,
    public officesellOfficenam2?: string | null,
    public lotsize?: string | null,
    public streetdirsuffix?: string | null,
    public photocount?: number | null,
    public schooldistrict?: string | null,
    public streetnum?: number | null,
    public utilities?: string | null,
    public equipment?: string | null,
    public roombed4width?: number | null,
    public roomkitchenlength?: number | null,
    public city?: string | null,
    public garagedesc?: string | null,
    public bathsfull?: number | null,
    public roombed3width?: number | null,
    public roomutildesc?: string | null,
    public roomutilitywidth?: number | null,
    public roomfullbathlength?: string,
    public roomfullbathwidth?: string,
    public roomhalfbathlength?: string,
    public roomhalfbathwidth?: string,
    public roomexerciselength?: string,
    public roomexercisewidth?: string,
    public roomstoragelength?: string,
    public roomstoragewidth?: string,
    public roomgamelength?: string,
    public roomgamewidth?: string,
    public roomguestlength?: string,
    public roomguestwidth?: string,
    public roomlibrarylength?: string,
    public roomlibrarywidth?: string,
    public roommedialength?: string,
    public roommediawidth?: string,
    public roommudlength?: string,
    public roommudwidth?: string,
    public roomofficelength?: string,
    public roomofficewidth?: string,
    public roomsaunalength?: string,
    public roomsaunawidth?: string,
    public roomsecondmasterlength?: string,
    public roomsecondmasterwidth?: string,
    public roomsunlength?: string,
    public roomsunwidth?: string,
    public roomspalength?: string,
    public roomspawidth?: string,
    public roomwinelength?: string,
    public roomwinewidth?: string,
    public juniorhighschoolname?: string,
    public primaryschoolname?: string,
    public seniorhighschoolname?: string,
    public associationfee?: string,
    public associationfeefrequency?: string,
    public constructionmaterials?: string,
    public heating?: string,
    public accessoryunittype?: string,
    public accessoryunityn?: string,
    public flooring?: string,
    public fireplacestotal?: string,
    public fireplacefeatures?: string,
    public securitysystemyn?: string,
    public greenbuildingcertification?: string,
    public greenenergyefficient?: string,
    public energysavingfeatures?: string,
    public lotnumber?: string,
    public lotsizearea?: string,
    public lotsizedimensions?: string,
    public easements?: string,
    public restrictions?: string,
    public washerdryerconnections?: string,
    public municipalutilitydistrictyn?: string,
    public associationfeeincludes?: string,
    public associationtype?: string,
    public barninformation?: string,
    public constructionmaterialswalls?: string,
    public countyorparish?: string,
    public exteriorbuildings?: string,
    public farmranchfeatures?: string,
    public fencedyardyn?: string,
    public financingproposed?: string,
    public handicapyn?: string,
    public numberoftanksandponds?: string,
    public parcelnumber?: string,
    public virtualtoururlunbranded?: string,
    public livingRoomFeature?: string,
    public masterBedRoomFeature?: string,
    public bedRoomFeature?: string,
    public diningRoomFeature?: string,
    public kitchenRoomFeature?: string,
    public breakfastRoomFeature?: string,
    public studyRoomFeature?: string,
    public utilityRoomFeature?: string,
    public fullBathRoomFeature?: string,
    public halfBathRoomFeature?: string,
    public exerciseRoomFeature?: string,
    public extraStorageRoomFeature?: string,
    public gameRoomFeature?: string,
    public guestRoomFeature?: string,
    public libraryRoomFeature?: string,
    public mediaRoomFeature?: string,
    public mudRoomFeature?: string,
    public officeRoomFeature?: string,
    public saunaRoomFeature?: string,
    public secondMasterRoomFeature?: string,
    public sunroomRoomFeature?: string,
    public spaRoomFeature?: string,
    public wineRoomFeature?: string,
    public otherRoomFeature?: string,
    public isLuxury?: string,
    public isMoveInReady?: string,
    public photoUrl?: string | null,
    public photo1Url?: string,
    public photo2Url?: string,
    public photo3Url?: string,
    public photo4Url?: string,
    public photo5Url?: string,
    public photo6Url?: string,
    public photo7Url?: string,
    public photo8Url?: string,
    public photo9Url?: string,
    public photo10Url?: string,
    public photo11Url?: string,
    public photo12Url?: string,
    public photo13Url?: string,
    public photo14Url?: string,
    public photo15Url?: string,
    public photo16Url?: string,
    public photo17Url?: string,
    public photo18Url?: string,
    public photo19Url?: string,
    public photo20Url?: string,
    public photo21Url?: string,
    public photo22Url?: string,
    public photo23Url?: string,
    public photo24Url?: string,
    public photo25Url?: string,
    public photo26Url?: string,
    public photo27Url?: string,
    public photo28Url?: string,
    public photo29Url?: string,
    public photo30Url?: string,
    public photo31Url?: string,
    public photo32Url?: string,
    public photo33Url?: string,
    public photo34Url?: string,
    public photo35Url?: string,
    public photo36Url?: string,
    public photo37Url?: string,
    public photo38Url?: string,
    public photo39Url?: string,
    public photo40Url?: string,
    public created?: dayjs.Dayjs | null,
    public updated?: dayjs.Dayjs,
    public modifiedDate?: dayjs.Dayjs,
    public imgDeleted?: boolean,
    public retsServer?: string | null,
    public permalink?: string,
    public propertyTag?: string,
    public buildentoryViews?: number,
    public location?: string,
    public userPropertyLinks?: IUserPropertyLink[] | null
  ) {
    this.imgDeleted = this.imgDeleted ?? false;
  }
}

export function getResPropertiesIdentifier(resProperties: IResProperties): number | undefined {
  return resProperties.id;
}
