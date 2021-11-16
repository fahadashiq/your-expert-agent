package com.hsrw.yea.web.rest;

import com.hsrw.yea.domain.ResProperties;
import com.hsrw.yea.repository.ResPropertiesRepository;
import com.hsrw.yea.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.hsrw.yea.domain.ResProperties}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ResPropertiesResource {

    private final Logger log = LoggerFactory.getLogger(ResPropertiesResource.class);

    private static final String ENTITY_NAME = "resProperties";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ResPropertiesRepository resPropertiesRepository;

    public ResPropertiesResource(ResPropertiesRepository resPropertiesRepository) {
        this.resPropertiesRepository = resPropertiesRepository;
    }

    /**
     * {@code POST  /res-properties} : Create a new resProperties.
     *
     * @param resProperties the resProperties to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new resProperties, or with status {@code 400 (Bad Request)} if the resProperties has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/res-properties")
    public ResponseEntity<ResProperties> createResProperties(@Valid @RequestBody ResProperties resProperties) throws URISyntaxException {
        log.debug("REST request to save ResProperties : {}", resProperties);
        if (resProperties.getId() != null) {
            throw new BadRequestAlertException("A new resProperties cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ResProperties result = resPropertiesRepository.save(resProperties);
        return ResponseEntity
            .created(new URI("/api/res-properties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /res-properties/:id} : Updates an existing resProperties.
     *
     * @param id the id of the resProperties to save.
     * @param resProperties the resProperties to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resProperties,
     * or with status {@code 400 (Bad Request)} if the resProperties is not valid,
     * or with status {@code 500 (Internal Server Error)} if the resProperties couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/res-properties/{id}")
    public ResponseEntity<ResProperties> updateResProperties(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ResProperties resProperties
    ) throws URISyntaxException {
        log.debug("REST request to update ResProperties : {}, {}", id, resProperties);
        if (resProperties.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resProperties.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resPropertiesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        ResProperties result = resPropertiesRepository.save(resProperties);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resProperties.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /res-properties/:id} : Partial updates given fields of an existing resProperties, field will ignore if it is null
     *
     * @param id the id of the resProperties to save.
     * @param resProperties the resProperties to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated resProperties,
     * or with status {@code 400 (Bad Request)} if the resProperties is not valid,
     * or with status {@code 404 (Not Found)} if the resProperties is not found,
     * or with status {@code 500 (Internal Server Error)} if the resProperties couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/res-properties/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<ResProperties> partialUpdateResProperties(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ResProperties resProperties
    ) throws URISyntaxException {
        log.debug("REST request to partial update ResProperties partially : {}, {}", id, resProperties);
        if (resProperties.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, resProperties.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!resPropertiesRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<ResProperties> result = resPropertiesRepository
            .findById(resProperties.getId())
            .map(existingResProperties -> {
                if (resProperties.getCommunityId() != null) {
                    existingResProperties.setCommunityId(resProperties.getCommunityId());
                }
                if (resProperties.getCommunityName() != null) {
                    existingResProperties.setCommunityName(resProperties.getCommunityName());
                }
                if (resProperties.getBuilderId() != null) {
                    existingResProperties.setBuilderId(resProperties.getBuilderId());
                }
                if (resProperties.getSpecialOffers() != null) {
                    existingResProperties.setSpecialOffers(resProperties.getSpecialOffers());
                }
                if (resProperties.getBrochure() != null) {
                    existingResProperties.setBrochure(resProperties.getBrochure());
                }
                if (resProperties.getFloorPlanId() != null) {
                    existingResProperties.setFloorPlanId(resProperties.getFloorPlanId());
                }
                if (resProperties.getLatitude() != null) {
                    existingResProperties.setLatitude(resProperties.getLatitude());
                }
                if (resProperties.getLongitude() != null) {
                    existingResProperties.setLongitude(resProperties.getLongitude());
                }
                if (resProperties.getCounty() != null) {
                    existingResProperties.setCounty(resProperties.getCounty());
                }
                if (resProperties.getHeatsystem() != null) {
                    existingResProperties.setHeatsystem(resProperties.getHeatsystem());
                }
                if (resProperties.getListstatus() != null) {
                    existingResProperties.setListstatus(resProperties.getListstatus());
                }
                if (resProperties.getListstatusflag() != null) {
                    existingResProperties.setListstatusflag(resProperties.getListstatusflag());
                }
                if (resProperties.getCarportcap() != null) {
                    existingResProperties.setCarportcap(resProperties.getCarportcap());
                }
                if (resProperties.getPossession() != null) {
                    existingResProperties.setPossession(resProperties.getPossession());
                }
                if (resProperties.getSchoolname1() != null) {
                    existingResProperties.setSchoolname1(resProperties.getSchoolname1());
                }
                if (resProperties.getSubdivide() != null) {
                    existingResProperties.setSubdivide(resProperties.getSubdivide());
                }
                if (resProperties.getVowavmyn() != null) {
                    existingResProperties.setVowavmyn(resProperties.getVowavmyn());
                }
                if (resProperties.getPresentuse() != null) {
                    existingResProperties.setPresentuse(resProperties.getPresentuse());
                }
                if (resProperties.getProposeduse() != null) {
                    existingResProperties.setProposeduse(resProperties.getProposeduse());
                }
                if (resProperties.getRanchname() != null) {
                    existingResProperties.setRanchname(resProperties.getRanchname());
                }
                if (resProperties.getRoombed2width() != null) {
                    existingResProperties.setRoombed2width(resProperties.getRoombed2width());
                }
                if (resProperties.getRoomdininglevel() != null) {
                    existingResProperties.setRoomdininglevel(resProperties.getRoomdininglevel());
                }
                if (resProperties.getRoomliving2width() != null) {
                    existingResProperties.setRoomliving2width(resProperties.getRoomliving2width());
                }
                if (resProperties.getRoomstudylevel() != null) {
                    existingResProperties.setRoomstudylevel(resProperties.getRoomstudylevel());
                }
                if (resProperties.getArea() != null) {
                    existingResProperties.setArea(resProperties.getArea());
                }
                if (resProperties.getAreatitle() != null) {
                    existingResProperties.setAreatitle(resProperties.getAreatitle());
                }
                if (resProperties.getAssocfee() != null) {
                    existingResProperties.setAssocfee(resProperties.getAssocfee());
                }
                if (resProperties.getFinanceproposed() != null) {
                    existingResProperties.setFinanceproposed(resProperties.getFinanceproposed());
                }
                if (resProperties.getListpriceorig() != null) {
                    existingResProperties.setListpriceorig(resProperties.getListpriceorig());
                }
                if (resProperties.getMapcoord() != null) {
                    existingResProperties.setMapcoord(resProperties.getMapcoord());
                }
                if (resProperties.getSchoolname2() != null) {
                    existingResProperties.setSchoolname2(resProperties.getSchoolname2());
                }
                if (resProperties.getRoomgaragewidth() != null) {
                    existingResProperties.setRoomgaragewidth(resProperties.getRoomgaragewidth());
                }
                if (resProperties.getRoomkitchendesc() != null) {
                    existingResProperties.setRoomkitchendesc(resProperties.getRoomkitchendesc());
                }
                if (resProperties.getRoomliving1width() != null) {
                    existingResProperties.setRoomliving1width(resProperties.getRoomliving1width());
                }
                if (resProperties.getRoomother2width() != null) {
                    existingResProperties.setRoomother2width(resProperties.getRoomother2width());
                }
                if (resProperties.getSqfttotal() != null) {
                    existingResProperties.setSqfttotal(resProperties.getSqfttotal());
                }
                if (resProperties.getOfficelistOfficenam1() != null) {
                    existingResProperties.setOfficelistOfficenam1(resProperties.getOfficelistOfficenam1());
                }
                if (resProperties.getSchoolname3() != null) {
                    existingResProperties.setSchoolname3(resProperties.getSchoolname3());
                }
                if (resProperties.getZipcode() != null) {
                    existingResProperties.setZipcode(resProperties.getZipcode());
                }
                if (resProperties.getBarn1length() != null) {
                    existingResProperties.setBarn1length(resProperties.getBarn1length());
                }
                if (resProperties.getBarn3width() != null) {
                    existingResProperties.setBarn3width(resProperties.getBarn3width());
                }
                if (resProperties.getRoombed2length() != null) {
                    existingResProperties.setRoombed2length(resProperties.getRoombed2length());
                }
                if (resProperties.getRoombed3length() != null) {
                    existingResProperties.setRoombed3length(resProperties.getRoombed3length());
                }
                if (resProperties.getRoomother1width() != null) {
                    existingResProperties.setRoomother1width(resProperties.getRoomother1width());
                }
                if (resProperties.getAgentlistFullname() != null) {
                    existingResProperties.setAgentlistFullname(resProperties.getAgentlistFullname());
                }
                if (resProperties.getProptype() != null) {
                    existingResProperties.setProptype(resProperties.getProptype());
                }
                if (resProperties.getMlsProptype() != null) {
                    existingResProperties.setMlsProptype(resProperties.getMlsProptype());
                }
                if (resProperties.getSchoolname4() != null) {
                    existingResProperties.setSchoolname4(resProperties.getSchoolname4());
                }
                if (resProperties.getAcrescultivated() != null) {
                    existingResProperties.setAcrescultivated(resProperties.getAcrescultivated());
                }
                if (resProperties.getBarn2length() != null) {
                    existingResProperties.setBarn2length(resProperties.getBarn2length());
                }
                if (resProperties.getBarn2width() != null) {
                    existingResProperties.setBarn2width(resProperties.getBarn2width());
                }
                if (resProperties.getComplexname() != null) {
                    existingResProperties.setComplexname(resProperties.getComplexname());
                }
                if (resProperties.getRoombed4length() != null) {
                    existingResProperties.setRoombed4length(resProperties.getRoombed4length());
                }
                if (resProperties.getRoombedbathdesc() != null) {
                    existingResProperties.setRoombedbathdesc(resProperties.getRoombedbathdesc());
                }
                if (resProperties.getRoombreakfastwidth() != null) {
                    existingResProperties.setRoombreakfastwidth(resProperties.getRoombreakfastwidth());
                }
                if (resProperties.getRoomother() != null) {
                    existingResProperties.setRoomother(resProperties.getRoomother());
                }
                if (resProperties.getRoomutilitylength() != null) {
                    existingResProperties.setRoomutilitylength(resProperties.getRoomutilitylength());
                }
                if (resProperties.getAcres() != null) {
                    existingResProperties.setAcres(resProperties.getAcres());
                }
                if (resProperties.getBlock() != null) {
                    existingResProperties.setBlock(resProperties.getBlock());
                }
                if (resProperties.getDirections() != null) {
                    existingResProperties.setDirections(resProperties.getDirections());
                }
                if (resProperties.getSubdivision() != null) {
                    existingResProperties.setSubdivision(resProperties.getSubdivision());
                }
                if (resProperties.getYearbuilt() != null) {
                    existingResProperties.setYearbuilt(resProperties.getYearbuilt());
                }
                if (resProperties.getYearbuiltdetails() != null) {
                    existingResProperties.setYearbuiltdetails(resProperties.getYearbuiltdetails());
                }
                if (resProperties.getAgexemption() != null) {
                    existingResProperties.setAgexemption(resProperties.getAgexemption());
                }
                if (resProperties.getBarn1width() != null) {
                    existingResProperties.setBarn1width(resProperties.getBarn1width());
                }
                if (resProperties.getBarn3length() != null) {
                    existingResProperties.setBarn3length(resProperties.getBarn3length());
                }
                if (resProperties.getRoomdiningwidth() != null) {
                    existingResProperties.setRoomdiningwidth(resProperties.getRoomdiningwidth());
                }
                if (resProperties.getRoomstudywidth() != null) {
                    existingResProperties.setRoomstudywidth(resProperties.getRoomstudywidth());
                }
                if (resProperties.getSoiltype() != null) {
                    existingResProperties.setSoiltype(resProperties.getSoiltype());
                }
                if (resProperties.getAppraisername() != null) {
                    existingResProperties.setAppraisername(resProperties.getAppraisername());
                }
                if (resProperties.getListpricelow() != null) {
                    existingResProperties.setListpricelow(resProperties.getListpricelow());
                }
                if (resProperties.getMappage() != null) {
                    existingResProperties.setMappage(resProperties.getMappage());
                }
                if (resProperties.getUnitnumber() != null) {
                    existingResProperties.setUnitnumber(resProperties.getUnitnumber());
                }
                if (resProperties.getStreetdir() != null) {
                    existingResProperties.setStreetdir(resProperties.getStreetdir());
                }
                if (resProperties.getStreettype() != null) {
                    existingResProperties.setStreettype(resProperties.getStreettype());
                }
                if (resProperties.getSubarea() != null) {
                    existingResProperties.setSubarea(resProperties.getSubarea());
                }
                if (resProperties.getSubareatitle() != null) {
                    existingResProperties.setSubareatitle(resProperties.getSubareatitle());
                }
                if (resProperties.getBathshalf() != null) {
                    existingResProperties.setBathshalf(resProperties.getBathshalf());
                }
                if (resProperties.getRoomgaragelength() != null) {
                    existingResProperties.setRoomgaragelength(resProperties.getRoomgaragelength());
                }
                if (resProperties.getPropsubtype() != null) {
                    existingResProperties.setPropsubtype(resProperties.getPropsubtype());
                }
                if (resProperties.getBeds() != null) {
                    existingResProperties.setBeds(resProperties.getBeds());
                }
                if (resProperties.getRoommasterbedwidth() != null) {
                    existingResProperties.setRoommasterbedwidth(resProperties.getRoommasterbedwidth());
                }
                if (resProperties.getRoomstudylength() != null) {
                    existingResProperties.setRoomstudylength(resProperties.getRoomstudylength());
                }
                if (resProperties.getAgentlist() != null) {
                    existingResProperties.setAgentlist(resProperties.getAgentlist());
                }
                if (resProperties.getStreetname() != null) {
                    existingResProperties.setStreetname(resProperties.getStreetname());
                }
                if (resProperties.getRoombreakfastlength() != null) {
                    existingResProperties.setRoombreakfastlength(resProperties.getRoombreakfastlength());
                }
                if (resProperties.getRoomkitchenwidth() != null) {
                    existingResProperties.setRoomkitchenwidth(resProperties.getRoomkitchenwidth());
                }
                if (resProperties.getFence() != null) {
                    existingResProperties.setFence(resProperties.getFence());
                }
                if (resProperties.getBathstotal() != null) {
                    existingResProperties.setBathstotal(resProperties.getBathstotal());
                }
                if (resProperties.getGaragecap() != null) {
                    existingResProperties.setGaragecap(resProperties.getGaragecap());
                }
                if (resProperties.getSqftprice() != null) {
                    existingResProperties.setSqftprice(resProperties.getSqftprice());
                }
                if (resProperties.getStyle() != null) {
                    existingResProperties.setStyle(resProperties.getStyle());
                }
                if (resProperties.getExterior() != null) {
                    existingResProperties.setExterior(resProperties.getExterior());
                }
                if (resProperties.getFoundation() != null) {
                    existingResProperties.setFoundation(resProperties.getFoundation());
                }
                if (resProperties.getInterior() != null) {
                    existingResProperties.setInterior(resProperties.getInterior());
                }
                if (resProperties.getPoolyn() != null) {
                    existingResProperties.setPoolyn(resProperties.getPoolyn());
                }
                if (resProperties.getPoolFeature() != null) {
                    existingResProperties.setPoolFeature(resProperties.getPoolFeature());
                }
                if (resProperties.getListprice() != null) {
                    existingResProperties.setListprice(resProperties.getListprice());
                }
                if (resProperties.getListpricerange() != null) {
                    existingResProperties.setListpricerange(resProperties.getListpricerange());
                }
                if (resProperties.getMlsnum() != null) {
                    existingResProperties.setMlsnum(resProperties.getMlsnum());
                }
                if (resProperties.getMatrixid() != null) {
                    existingResProperties.setMatrixid(resProperties.getMatrixid());
                }
                if (resProperties.getRemarks() != null) {
                    existingResProperties.setRemarks(resProperties.getRemarks());
                }
                if (resProperties.getState() != null) {
                    existingResProperties.setState(resProperties.getState());
                }
                if (resProperties.getRoof() != null) {
                    existingResProperties.setRoof(resProperties.getRoof());
                }
                if (resProperties.getSecurityfeatures() != null) {
                    existingResProperties.setSecurityfeatures(resProperties.getSecurityfeatures());
                }
                if (resProperties.getUtilitiesother() != null) {
                    existingResProperties.setUtilitiesother(resProperties.getUtilitiesother());
                }
                if (resProperties.getCommonfeatures() != null) {
                    existingResProperties.setCommonfeatures(resProperties.getCommonfeatures());
                }
                if (resProperties.getConstruction() != null) {
                    existingResProperties.setConstruction(resProperties.getConstruction());
                }
                if (resProperties.getModified() != null) {
                    existingResProperties.setModified(resProperties.getModified());
                }
                if (resProperties.getStories() != null) {
                    existingResProperties.setStories(resProperties.getStories());
                }
                if (resProperties.getRoomdininglength() != null) {
                    existingResProperties.setRoomdininglength(resProperties.getRoomdininglength());
                }
                if (resProperties.getRoomliving1length() != null) {
                    existingResProperties.setRoomliving1length(resProperties.getRoomliving1length());
                }
                if (resProperties.getOpenhousetime() != null) {
                    existingResProperties.setOpenhousetime(resProperties.getOpenhousetime());
                }
                if (resProperties.getOpenhouseendtime() != null) {
                    existingResProperties.setOpenhouseendtime(resProperties.getOpenhouseendtime());
                }
                if (resProperties.getRoomliving2length() != null) {
                    existingResProperties.setRoomliving2length(resProperties.getRoomliving2length());
                }
                if (resProperties.getLotdesc() != null) {
                    existingResProperties.setLotdesc(resProperties.getLotdesc());
                }
                if (resProperties.getOpenhousedate() != null) {
                    existingResProperties.setOpenhousedate(resProperties.getOpenhousedate());
                }
                if (resProperties.getRoommasterbedlength() != null) {
                    existingResProperties.setRoommasterbedlength(resProperties.getRoommasterbedlength());
                }
                if (resProperties.getRoomother1length() != null) {
                    existingResProperties.setRoomother1length(resProperties.getRoomother1length());
                }
                if (resProperties.getOfficesellOfficenam2() != null) {
                    existingResProperties.setOfficesellOfficenam2(resProperties.getOfficesellOfficenam2());
                }
                if (resProperties.getLotsize() != null) {
                    existingResProperties.setLotsize(resProperties.getLotsize());
                }
                if (resProperties.getStreetdirsuffix() != null) {
                    existingResProperties.setStreetdirsuffix(resProperties.getStreetdirsuffix());
                }
                if (resProperties.getPhotocount() != null) {
                    existingResProperties.setPhotocount(resProperties.getPhotocount());
                }
                if (resProperties.getSchooldistrict() != null) {
                    existingResProperties.setSchooldistrict(resProperties.getSchooldistrict());
                }
                if (resProperties.getStreetnum() != null) {
                    existingResProperties.setStreetnum(resProperties.getStreetnum());
                }
                if (resProperties.getUtilities() != null) {
                    existingResProperties.setUtilities(resProperties.getUtilities());
                }
                if (resProperties.getEquipment() != null) {
                    existingResProperties.setEquipment(resProperties.getEquipment());
                }
                if (resProperties.getRoombed4width() != null) {
                    existingResProperties.setRoombed4width(resProperties.getRoombed4width());
                }
                if (resProperties.getRoomkitchenlength() != null) {
                    existingResProperties.setRoomkitchenlength(resProperties.getRoomkitchenlength());
                }
                if (resProperties.getCity() != null) {
                    existingResProperties.setCity(resProperties.getCity());
                }
                if (resProperties.getGaragedesc() != null) {
                    existingResProperties.setGaragedesc(resProperties.getGaragedesc());
                }
                if (resProperties.getBathsfull() != null) {
                    existingResProperties.setBathsfull(resProperties.getBathsfull());
                }
                if (resProperties.getRoombed3width() != null) {
                    existingResProperties.setRoombed3width(resProperties.getRoombed3width());
                }
                if (resProperties.getRoomutildesc() != null) {
                    existingResProperties.setRoomutildesc(resProperties.getRoomutildesc());
                }
                if (resProperties.getRoomutilitywidth() != null) {
                    existingResProperties.setRoomutilitywidth(resProperties.getRoomutilitywidth());
                }
                if (resProperties.getRoomfullbathlength() != null) {
                    existingResProperties.setRoomfullbathlength(resProperties.getRoomfullbathlength());
                }
                if (resProperties.getRoomfullbathwidth() != null) {
                    existingResProperties.setRoomfullbathwidth(resProperties.getRoomfullbathwidth());
                }
                if (resProperties.getRoomhalfbathlength() != null) {
                    existingResProperties.setRoomhalfbathlength(resProperties.getRoomhalfbathlength());
                }
                if (resProperties.getRoomhalfbathwidth() != null) {
                    existingResProperties.setRoomhalfbathwidth(resProperties.getRoomhalfbathwidth());
                }
                if (resProperties.getRoomexerciselength() != null) {
                    existingResProperties.setRoomexerciselength(resProperties.getRoomexerciselength());
                }
                if (resProperties.getRoomexercisewidth() != null) {
                    existingResProperties.setRoomexercisewidth(resProperties.getRoomexercisewidth());
                }
                if (resProperties.getRoomstoragelength() != null) {
                    existingResProperties.setRoomstoragelength(resProperties.getRoomstoragelength());
                }
                if (resProperties.getRoomstoragewidth() != null) {
                    existingResProperties.setRoomstoragewidth(resProperties.getRoomstoragewidth());
                }
                if (resProperties.getRoomgamelength() != null) {
                    existingResProperties.setRoomgamelength(resProperties.getRoomgamelength());
                }
                if (resProperties.getRoomgamewidth() != null) {
                    existingResProperties.setRoomgamewidth(resProperties.getRoomgamewidth());
                }
                if (resProperties.getRoomguestlength() != null) {
                    existingResProperties.setRoomguestlength(resProperties.getRoomguestlength());
                }
                if (resProperties.getRoomguestwidth() != null) {
                    existingResProperties.setRoomguestwidth(resProperties.getRoomguestwidth());
                }
                if (resProperties.getRoomlibrarylength() != null) {
                    existingResProperties.setRoomlibrarylength(resProperties.getRoomlibrarylength());
                }
                if (resProperties.getRoomlibrarywidth() != null) {
                    existingResProperties.setRoomlibrarywidth(resProperties.getRoomlibrarywidth());
                }
                if (resProperties.getRoommedialength() != null) {
                    existingResProperties.setRoommedialength(resProperties.getRoommedialength());
                }
                if (resProperties.getRoommediawidth() != null) {
                    existingResProperties.setRoommediawidth(resProperties.getRoommediawidth());
                }
                if (resProperties.getRoommudlength() != null) {
                    existingResProperties.setRoommudlength(resProperties.getRoommudlength());
                }
                if (resProperties.getRoommudwidth() != null) {
                    existingResProperties.setRoommudwidth(resProperties.getRoommudwidth());
                }
                if (resProperties.getRoomofficelength() != null) {
                    existingResProperties.setRoomofficelength(resProperties.getRoomofficelength());
                }
                if (resProperties.getRoomofficewidth() != null) {
                    existingResProperties.setRoomofficewidth(resProperties.getRoomofficewidth());
                }
                if (resProperties.getRoomsaunalength() != null) {
                    existingResProperties.setRoomsaunalength(resProperties.getRoomsaunalength());
                }
                if (resProperties.getRoomsaunawidth() != null) {
                    existingResProperties.setRoomsaunawidth(resProperties.getRoomsaunawidth());
                }
                if (resProperties.getRoomsecondmasterlength() != null) {
                    existingResProperties.setRoomsecondmasterlength(resProperties.getRoomsecondmasterlength());
                }
                if (resProperties.getRoomsecondmasterwidth() != null) {
                    existingResProperties.setRoomsecondmasterwidth(resProperties.getRoomsecondmasterwidth());
                }
                if (resProperties.getRoomsunlength() != null) {
                    existingResProperties.setRoomsunlength(resProperties.getRoomsunlength());
                }
                if (resProperties.getRoomsunwidth() != null) {
                    existingResProperties.setRoomsunwidth(resProperties.getRoomsunwidth());
                }
                if (resProperties.getRoomspalength() != null) {
                    existingResProperties.setRoomspalength(resProperties.getRoomspalength());
                }
                if (resProperties.getRoomspawidth() != null) {
                    existingResProperties.setRoomspawidth(resProperties.getRoomspawidth());
                }
                if (resProperties.getRoomwinelength() != null) {
                    existingResProperties.setRoomwinelength(resProperties.getRoomwinelength());
                }
                if (resProperties.getRoomwinewidth() != null) {
                    existingResProperties.setRoomwinewidth(resProperties.getRoomwinewidth());
                }
                if (resProperties.getJuniorhighschoolname() != null) {
                    existingResProperties.setJuniorhighschoolname(resProperties.getJuniorhighschoolname());
                }
                if (resProperties.getPrimaryschoolname() != null) {
                    existingResProperties.setPrimaryschoolname(resProperties.getPrimaryschoolname());
                }
                if (resProperties.getSeniorhighschoolname() != null) {
                    existingResProperties.setSeniorhighschoolname(resProperties.getSeniorhighschoolname());
                }
                if (resProperties.getAssociationfee() != null) {
                    existingResProperties.setAssociationfee(resProperties.getAssociationfee());
                }
                if (resProperties.getAssociationfeefrequency() != null) {
                    existingResProperties.setAssociationfeefrequency(resProperties.getAssociationfeefrequency());
                }
                if (resProperties.getConstructionmaterials() != null) {
                    existingResProperties.setConstructionmaterials(resProperties.getConstructionmaterials());
                }
                if (resProperties.getHeating() != null) {
                    existingResProperties.setHeating(resProperties.getHeating());
                }
                if (resProperties.getAccessoryunittype() != null) {
                    existingResProperties.setAccessoryunittype(resProperties.getAccessoryunittype());
                }
                if (resProperties.getAccessoryunityn() != null) {
                    existingResProperties.setAccessoryunityn(resProperties.getAccessoryunityn());
                }
                if (resProperties.getFlooring() != null) {
                    existingResProperties.setFlooring(resProperties.getFlooring());
                }
                if (resProperties.getFireplacestotal() != null) {
                    existingResProperties.setFireplacestotal(resProperties.getFireplacestotal());
                }
                if (resProperties.getFireplacefeatures() != null) {
                    existingResProperties.setFireplacefeatures(resProperties.getFireplacefeatures());
                }
                if (resProperties.getSecuritysystemyn() != null) {
                    existingResProperties.setSecuritysystemyn(resProperties.getSecuritysystemyn());
                }
                if (resProperties.getGreenbuildingcertification() != null) {
                    existingResProperties.setGreenbuildingcertification(resProperties.getGreenbuildingcertification());
                }
                if (resProperties.getGreenenergyefficient() != null) {
                    existingResProperties.setGreenenergyefficient(resProperties.getGreenenergyefficient());
                }
                if (resProperties.getEnergysavingfeatures() != null) {
                    existingResProperties.setEnergysavingfeatures(resProperties.getEnergysavingfeatures());
                }
                if (resProperties.getLotnumber() != null) {
                    existingResProperties.setLotnumber(resProperties.getLotnumber());
                }
                if (resProperties.getLotsizearea() != null) {
                    existingResProperties.setLotsizearea(resProperties.getLotsizearea());
                }
                if (resProperties.getLotsizedimensions() != null) {
                    existingResProperties.setLotsizedimensions(resProperties.getLotsizedimensions());
                }
                if (resProperties.getEasements() != null) {
                    existingResProperties.setEasements(resProperties.getEasements());
                }
                if (resProperties.getRestrictions() != null) {
                    existingResProperties.setRestrictions(resProperties.getRestrictions());
                }
                if (resProperties.getWasherdryerconnections() != null) {
                    existingResProperties.setWasherdryerconnections(resProperties.getWasherdryerconnections());
                }
                if (resProperties.getMunicipalutilitydistrictyn() != null) {
                    existingResProperties.setMunicipalutilitydistrictyn(resProperties.getMunicipalutilitydistrictyn());
                }
                if (resProperties.getAssociationfeeincludes() != null) {
                    existingResProperties.setAssociationfeeincludes(resProperties.getAssociationfeeincludes());
                }
                if (resProperties.getAssociationtype() != null) {
                    existingResProperties.setAssociationtype(resProperties.getAssociationtype());
                }
                if (resProperties.getBarninformation() != null) {
                    existingResProperties.setBarninformation(resProperties.getBarninformation());
                }
                if (resProperties.getConstructionmaterialswalls() != null) {
                    existingResProperties.setConstructionmaterialswalls(resProperties.getConstructionmaterialswalls());
                }
                if (resProperties.getCountyorparish() != null) {
                    existingResProperties.setCountyorparish(resProperties.getCountyorparish());
                }
                if (resProperties.getExteriorbuildings() != null) {
                    existingResProperties.setExteriorbuildings(resProperties.getExteriorbuildings());
                }
                if (resProperties.getFarmranchfeatures() != null) {
                    existingResProperties.setFarmranchfeatures(resProperties.getFarmranchfeatures());
                }
                if (resProperties.getFencedyardyn() != null) {
                    existingResProperties.setFencedyardyn(resProperties.getFencedyardyn());
                }
                if (resProperties.getFinancingproposed() != null) {
                    existingResProperties.setFinancingproposed(resProperties.getFinancingproposed());
                }
                if (resProperties.getHandicapyn() != null) {
                    existingResProperties.setHandicapyn(resProperties.getHandicapyn());
                }
                if (resProperties.getNumberoftanksandponds() != null) {
                    existingResProperties.setNumberoftanksandponds(resProperties.getNumberoftanksandponds());
                }
                if (resProperties.getParcelnumber() != null) {
                    existingResProperties.setParcelnumber(resProperties.getParcelnumber());
                }
                if (resProperties.getVirtualtoururlunbranded() != null) {
                    existingResProperties.setVirtualtoururlunbranded(resProperties.getVirtualtoururlunbranded());
                }
                if (resProperties.getLivingRoomFeature() != null) {
                    existingResProperties.setLivingRoomFeature(resProperties.getLivingRoomFeature());
                }
                if (resProperties.getMasterBedRoomFeature() != null) {
                    existingResProperties.setMasterBedRoomFeature(resProperties.getMasterBedRoomFeature());
                }
                if (resProperties.getBedRoomFeature() != null) {
                    existingResProperties.setBedRoomFeature(resProperties.getBedRoomFeature());
                }
                if (resProperties.getDiningRoomFeature() != null) {
                    existingResProperties.setDiningRoomFeature(resProperties.getDiningRoomFeature());
                }
                if (resProperties.getKitchenRoomFeature() != null) {
                    existingResProperties.setKitchenRoomFeature(resProperties.getKitchenRoomFeature());
                }
                if (resProperties.getBreakfastRoomFeature() != null) {
                    existingResProperties.setBreakfastRoomFeature(resProperties.getBreakfastRoomFeature());
                }
                if (resProperties.getStudyRoomFeature() != null) {
                    existingResProperties.setStudyRoomFeature(resProperties.getStudyRoomFeature());
                }
                if (resProperties.getUtilityRoomFeature() != null) {
                    existingResProperties.setUtilityRoomFeature(resProperties.getUtilityRoomFeature());
                }
                if (resProperties.getFullBathRoomFeature() != null) {
                    existingResProperties.setFullBathRoomFeature(resProperties.getFullBathRoomFeature());
                }
                if (resProperties.getHalfBathRoomFeature() != null) {
                    existingResProperties.setHalfBathRoomFeature(resProperties.getHalfBathRoomFeature());
                }
                if (resProperties.getExerciseRoomFeature() != null) {
                    existingResProperties.setExerciseRoomFeature(resProperties.getExerciseRoomFeature());
                }
                if (resProperties.getExtraStorageRoomFeature() != null) {
                    existingResProperties.setExtraStorageRoomFeature(resProperties.getExtraStorageRoomFeature());
                }
                if (resProperties.getGameRoomFeature() != null) {
                    existingResProperties.setGameRoomFeature(resProperties.getGameRoomFeature());
                }
                if (resProperties.getGuestRoomFeature() != null) {
                    existingResProperties.setGuestRoomFeature(resProperties.getGuestRoomFeature());
                }
                if (resProperties.getLibraryRoomFeature() != null) {
                    existingResProperties.setLibraryRoomFeature(resProperties.getLibraryRoomFeature());
                }
                if (resProperties.getMediaRoomFeature() != null) {
                    existingResProperties.setMediaRoomFeature(resProperties.getMediaRoomFeature());
                }
                if (resProperties.getMudRoomFeature() != null) {
                    existingResProperties.setMudRoomFeature(resProperties.getMudRoomFeature());
                }
                if (resProperties.getOfficeRoomFeature() != null) {
                    existingResProperties.setOfficeRoomFeature(resProperties.getOfficeRoomFeature());
                }
                if (resProperties.getSaunaRoomFeature() != null) {
                    existingResProperties.setSaunaRoomFeature(resProperties.getSaunaRoomFeature());
                }
                if (resProperties.getSecondMasterRoomFeature() != null) {
                    existingResProperties.setSecondMasterRoomFeature(resProperties.getSecondMasterRoomFeature());
                }
                if (resProperties.getSunroomRoomFeature() != null) {
                    existingResProperties.setSunroomRoomFeature(resProperties.getSunroomRoomFeature());
                }
                if (resProperties.getSpaRoomFeature() != null) {
                    existingResProperties.setSpaRoomFeature(resProperties.getSpaRoomFeature());
                }
                if (resProperties.getWineRoomFeature() != null) {
                    existingResProperties.setWineRoomFeature(resProperties.getWineRoomFeature());
                }
                if (resProperties.getOtherRoomFeature() != null) {
                    existingResProperties.setOtherRoomFeature(resProperties.getOtherRoomFeature());
                }
                if (resProperties.getIsLuxury() != null) {
                    existingResProperties.setIsLuxury(resProperties.getIsLuxury());
                }
                if (resProperties.getIsMoveInReady() != null) {
                    existingResProperties.setIsMoveInReady(resProperties.getIsMoveInReady());
                }
                if (resProperties.getPhotoUrl() != null) {
                    existingResProperties.setPhotoUrl(resProperties.getPhotoUrl());
                }
                if (resProperties.getPhoto1Url() != null) {
                    existingResProperties.setPhoto1Url(resProperties.getPhoto1Url());
                }
                if (resProperties.getPhoto2Url() != null) {
                    existingResProperties.setPhoto2Url(resProperties.getPhoto2Url());
                }
                if (resProperties.getPhoto3Url() != null) {
                    existingResProperties.setPhoto3Url(resProperties.getPhoto3Url());
                }
                if (resProperties.getPhoto4Url() != null) {
                    existingResProperties.setPhoto4Url(resProperties.getPhoto4Url());
                }
                if (resProperties.getPhoto5Url() != null) {
                    existingResProperties.setPhoto5Url(resProperties.getPhoto5Url());
                }
                if (resProperties.getPhoto6Url() != null) {
                    existingResProperties.setPhoto6Url(resProperties.getPhoto6Url());
                }
                if (resProperties.getPhoto7Url() != null) {
                    existingResProperties.setPhoto7Url(resProperties.getPhoto7Url());
                }
                if (resProperties.getPhoto8Url() != null) {
                    existingResProperties.setPhoto8Url(resProperties.getPhoto8Url());
                }
                if (resProperties.getPhoto9Url() != null) {
                    existingResProperties.setPhoto9Url(resProperties.getPhoto9Url());
                }
                if (resProperties.getPhoto10Url() != null) {
                    existingResProperties.setPhoto10Url(resProperties.getPhoto10Url());
                }
                if (resProperties.getPhoto11Url() != null) {
                    existingResProperties.setPhoto11Url(resProperties.getPhoto11Url());
                }
                if (resProperties.getPhoto12Url() != null) {
                    existingResProperties.setPhoto12Url(resProperties.getPhoto12Url());
                }
                if (resProperties.getPhoto13Url() != null) {
                    existingResProperties.setPhoto13Url(resProperties.getPhoto13Url());
                }
                if (resProperties.getPhoto14Url() != null) {
                    existingResProperties.setPhoto14Url(resProperties.getPhoto14Url());
                }
                if (resProperties.getPhoto15Url() != null) {
                    existingResProperties.setPhoto15Url(resProperties.getPhoto15Url());
                }
                if (resProperties.getPhoto16Url() != null) {
                    existingResProperties.setPhoto16Url(resProperties.getPhoto16Url());
                }
                if (resProperties.getPhoto17Url() != null) {
                    existingResProperties.setPhoto17Url(resProperties.getPhoto17Url());
                }
                if (resProperties.getPhoto18Url() != null) {
                    existingResProperties.setPhoto18Url(resProperties.getPhoto18Url());
                }
                if (resProperties.getPhoto19Url() != null) {
                    existingResProperties.setPhoto19Url(resProperties.getPhoto19Url());
                }
                if (resProperties.getPhoto20Url() != null) {
                    existingResProperties.setPhoto20Url(resProperties.getPhoto20Url());
                }
                if (resProperties.getPhoto21Url() != null) {
                    existingResProperties.setPhoto21Url(resProperties.getPhoto21Url());
                }
                if (resProperties.getPhoto22Url() != null) {
                    existingResProperties.setPhoto22Url(resProperties.getPhoto22Url());
                }
                if (resProperties.getPhoto23Url() != null) {
                    existingResProperties.setPhoto23Url(resProperties.getPhoto23Url());
                }
                if (resProperties.getPhoto24Url() != null) {
                    existingResProperties.setPhoto24Url(resProperties.getPhoto24Url());
                }
                if (resProperties.getPhoto25Url() != null) {
                    existingResProperties.setPhoto25Url(resProperties.getPhoto25Url());
                }
                if (resProperties.getPhoto26Url() != null) {
                    existingResProperties.setPhoto26Url(resProperties.getPhoto26Url());
                }
                if (resProperties.getPhoto27Url() != null) {
                    existingResProperties.setPhoto27Url(resProperties.getPhoto27Url());
                }
                if (resProperties.getPhoto28Url() != null) {
                    existingResProperties.setPhoto28Url(resProperties.getPhoto28Url());
                }
                if (resProperties.getPhoto29Url() != null) {
                    existingResProperties.setPhoto29Url(resProperties.getPhoto29Url());
                }
                if (resProperties.getPhoto30Url() != null) {
                    existingResProperties.setPhoto30Url(resProperties.getPhoto30Url());
                }
                if (resProperties.getPhoto31Url() != null) {
                    existingResProperties.setPhoto31Url(resProperties.getPhoto31Url());
                }
                if (resProperties.getPhoto32Url() != null) {
                    existingResProperties.setPhoto32Url(resProperties.getPhoto32Url());
                }
                if (resProperties.getPhoto33Url() != null) {
                    existingResProperties.setPhoto33Url(resProperties.getPhoto33Url());
                }
                if (resProperties.getPhoto34Url() != null) {
                    existingResProperties.setPhoto34Url(resProperties.getPhoto34Url());
                }
                if (resProperties.getPhoto35Url() != null) {
                    existingResProperties.setPhoto35Url(resProperties.getPhoto35Url());
                }
                if (resProperties.getPhoto36Url() != null) {
                    existingResProperties.setPhoto36Url(resProperties.getPhoto36Url());
                }
                if (resProperties.getPhoto37Url() != null) {
                    existingResProperties.setPhoto37Url(resProperties.getPhoto37Url());
                }
                if (resProperties.getPhoto38Url() != null) {
                    existingResProperties.setPhoto38Url(resProperties.getPhoto38Url());
                }
                if (resProperties.getPhoto39Url() != null) {
                    existingResProperties.setPhoto39Url(resProperties.getPhoto39Url());
                }
                if (resProperties.getPhoto40Url() != null) {
                    existingResProperties.setPhoto40Url(resProperties.getPhoto40Url());
                }
                if (resProperties.getCreated() != null) {
                    existingResProperties.setCreated(resProperties.getCreated());
                }
                if (resProperties.getUpdated() != null) {
                    existingResProperties.setUpdated(resProperties.getUpdated());
                }
                if (resProperties.getModifiedDate() != null) {
                    existingResProperties.setModifiedDate(resProperties.getModifiedDate());
                }
                if (resProperties.getImgDeleted() != null) {
                    existingResProperties.setImgDeleted(resProperties.getImgDeleted());
                }
                if (resProperties.getRetsServer() != null) {
                    existingResProperties.setRetsServer(resProperties.getRetsServer());
                }
                if (resProperties.getPermalink() != null) {
                    existingResProperties.setPermalink(resProperties.getPermalink());
                }
                if (resProperties.getPropertyTag() != null) {
                    existingResProperties.setPropertyTag(resProperties.getPropertyTag());
                }
                if (resProperties.getBuildentoryViews() != null) {
                    existingResProperties.setBuildentoryViews(resProperties.getBuildentoryViews());
                }
                if (resProperties.getLocation() != null) {
                    existingResProperties.setLocation(resProperties.getLocation());
                }

                return existingResProperties;
            })
            .map(resPropertiesRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, resProperties.getId().toString())
        );
    }

    /**
     * {@code GET  /res-properties} : get all the resProperties.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of resProperties in body.
     */
    @GetMapping("/res-properties")
    public List<ResProperties> getAllResProperties() {
        log.debug("REST request to get all ResProperties");
        return resPropertiesRepository.findAll();
    }

    /**
     * {@code GET  /res-properties/:id} : get the "id" resProperties.
     *
     * @param id the id of the resProperties to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the resProperties, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/res-properties/{id}")
    public ResponseEntity<ResProperties> getResProperties(@PathVariable Long id) {
        log.debug("REST request to get ResProperties : {}", id);
        Optional<ResProperties> resProperties = resPropertiesRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(resProperties);
    }

    /**
     * {@code DELETE  /res-properties/:id} : delete the "id" resProperties.
     *
     * @param id the id of the resProperties to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/res-properties/{id}")
    public ResponseEntity<Void> deleteResProperties(@PathVariable Long id) {
        log.debug("REST request to delete ResProperties : {}", id);
        resPropertiesRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
