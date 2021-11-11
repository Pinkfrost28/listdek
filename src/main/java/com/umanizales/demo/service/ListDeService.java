package com.umanizales.demo.service;

import com.umanizales.demo.controller.GenderByGradeDTO;
import com.umanizales.demo.controller.GradeByLocationDTO;
import com.umanizales.demo.controller.ResponseDTO;
import com.umanizales.demo.exception.ListaDeException;
import com.umanizales.demo.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  ListDeService {
    private ListDE listBoys;
    private List<Location> locations;

    public ListDeService() {
        listBoys = new ListDE();
        initializeLocations();
    }

    private void initializeLocations() {
        locations = new ArrayList<>();
        locations.add(new Location("16917001", "Manizales"));
        locations.add(new Location("16917003", "Chinchiná"));
        locations.add(new Location("169176001", "Villamaria"));
    }

    public boolean validateLocation(Location location) {
        for (Location loc : locations) {
            if (loc.getCode().equals(location.getCode()) && loc.getDescription().equals(location.getDescription())) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaDeException {
        if (!validateLocation(boy.getLocation())) {
            throw new ListaDeException("La ubicacion ingresada no es valida");
        }

        listBoys.add(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoys() throws ListaDeException {
        if (listBoys.getHead() == null) {
            throw new ListaDeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getCount() {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> count() {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.count(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyToStart(Boy boy) throws ListaDeException {
        if (!validateLocation(boy.getLocation())) {
            throw new ListaDeException("La ubicacion ingresada no es valida");
        }
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertList() throws ListaDeException {
        listBoys.invert();
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> delete(String id) throws ListaDeException {
        listBoys.delete(id);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteKamikaze(String id) throws ListaDeException {
        listBoys.deleteKamikaze(id);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeXtremes() throws ListaDeException {
        listBoys.changeXtremes();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addBoyByPosition(Boy boy, int position) throws ListaDeException {
        listBoys.addByPosition(boy, position);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> variantList() throws ListaDeException {
        listBoys.variantBoys();
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changePos(int pos1, int pos2) throws ListaDeException {
        listBoys.changePos(pos1, pos2);
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", null, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByLocation() {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        for (Location loc : locations) {
            int count = listBoys.getCountBoysByLocation(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc, count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", boysByLocations, null), HttpStatus.OK);

    }

    public ResponseEntity<ResponseDTO> listAgeLocation(int age, String description) throws ListaDeException {
        listBoys.listAgeLocation(age, description);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> startAgeGender(Gender gender, int age) throws ListaDeException {
        listBoys.startAgeGender(gender, age);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteOlder(int age) throws ListaDeException {
        listBoys.deleteOlder(age);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> kidAndGirlOlder() throws ListaDeException {
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", listBoys.kidAndGirlOlder(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> orderBoysByAge() throws ListaDeException {
        listBoys.orderBoysByAge();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteByPosition(int pos) throws ListaDeException {
        listBoys.deleteByPosition(pos);
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> passPosition(String id, int position) throws ListaDeException {
        listBoys.passPosition(id, position);
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> losePosition(String id, int position) throws ListaDeException {
        listBoys.losePosition(id, position);
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByGrade() {
        List<BoysByGrade> boysByGrade = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            int count = listBoys.getCountBoysByGrade(i);
            boysByGrade.add(new BoysByGrade(i, count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", boysByGrade, null), HttpStatus.OK);

    }

    public ResponseEntity<ResponseDTO> deleteGender(Gender gender) throws ListaDeException {
        listBoys.deleteGender(gender);
        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getBoysByGender() {
        List<BoysByGender> boysByGender = new ArrayList<>();

        int count = listBoys.getCountBoysByGender(Gender.FEMENINO);
        boysByGender.add(new BoysByGender(Gender.FEMENINO, count));

        int count2 = listBoys.getCountBoysByGender(Gender.MASCULINO);
        boysByGender.add(new BoysByGender(Gender.MASCULINO, count2));

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", boysByGender, null), HttpStatus.OK);

    }

  /*  public ResponseEntity<ResponseDTO> getBoysOrphanByGender() {
        List<BoysByGender> boysByGender = new ArrayList<>();

        int count = listBoys.getCountBoysOrphanByGender(Gender.FEMENINO);
        boysByGender.add(new BoysByGender(Gender.FEMENINO, count));

        int count2 = listBoys.getCountBoysOrphanByGender(Gender.MASCULINO);
        boysByGender.add(new BoysByGender(Gender.MASCULINO, count2));

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", boysByGender, null), HttpStatus.OK);

    }*/

    public ResponseEntity<ResponseDTO>  getOrphansByGradeByLocation() throws ListaDeException
    {
        List<GradeByLocationDTO> gradeByLocationDTOS = new ArrayList<>();
        for (Location loc: locations)
        {
            gradeByLocationDTOS.add(listBoys.getGradesByLocation(loc));
        }

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", gradeByLocationDTOS, null), HttpStatus.OK);
    }
}


/*
    public ResponseEntity<ResponseDTO> nose(int grade, String code) throws ListaDeException
    {


        return new ResponseEntity<>(
                new ResponseDTO("Satisfactorio",listBoys.nose(grade, code),null), HttpStatus.OK);
    }
}*/
