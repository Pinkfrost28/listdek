package com.umanizales.demo.controller;

import com.umanizales.demo.exception.ListaDeException;
import com.umanizales.demo.model.Boy;
import com.umanizales.demo.model.Gender;
import com.umanizales.demo.service.ListDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "boys")
public class BoysControllerDe {
    @Autowired
    private ListDeService listDeService;

    @PostMapping(path = "de")
    public ResponseEntity<ResponseDTO> addBoyDe(@RequestBody @Valid Boy boy) throws ListaDeException
    {
        return listDeService.addBoy(boy);
    }

    @GetMapping(path = "de")
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaDeException
    {
        return listDeService.listBoys();
    }

    @GetMapping(path= "de/getcount")
    public ResponseEntity<ResponseDTO> getCount()
    {
        return listDeService.getCount();
    }

    @GetMapping(path= "de/count")
    public ResponseEntity<ResponseDTO> count()
    {
        return listDeService.count();
    }


    @PostMapping(path ="de/addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody Boy boy) throws ListaDeException
    {
        return listDeService.addBoyToStart(boy);
    }

    @GetMapping(path= "de/invert")
    public ResponseEntity<ResponseDTO> invertList() throws ListaDeException
    {
        return listDeService.invertList();
    }

    @GetMapping(path="de/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws ListaDeException
    {
        return listDeService.delete(id);
    }
    @GetMapping(path="de/deletekamikaze/{id}")
    public ResponseEntity<ResponseDTO> deleteKamikaze(@PathVariable String id) throws ListaDeException
    {
        return listDeService.deleteKamikaze(id);
    }

    @GetMapping(path="de/changextremes")
    public ResponseEntity<ResponseDTO> changextremes() throws ListaDeException
    {
        return listDeService.changeXtremes();
    }

    @PostMapping(path ="de/addbyposition/{position}")
    public ResponseEntity<ResponseDTO> addBoyByPosition(@RequestBody Boy boy, @PathVariable int position)  throws ListaDeException
    {
        return listDeService.addBoyByPosition(boy, position);
    }

    @GetMapping(path= "de/variant")
    public ResponseEntity<ResponseDTO> variantList() throws ListaDeException
    {
        return listDeService.variantList();
    }

    @GetMapping(path ="de/changepos/{pos1}/{pos2}")
    public ResponseEntity<ResponseDTO> changePos(@PathVariable int pos1,@PathVariable int pos2) throws ListaDeException
    {
        return listDeService.changePos(pos1,pos2);
    }

    @GetMapping(path= "de/boysbylocation")
    public ResponseEntity<ResponseDTO> boysByLocation()
    {
        return listDeService.getBoysByLocation();
    }

    @GetMapping(path="de/listagelocation/{age}/{description}")
    public ResponseEntity<ResponseDTO> listAgeLocation(@PathVariable int age, @PathVariable String description) throws ListaDeException
    {
        return listDeService.listAgeLocation(age,description);
    }

    @GetMapping(path="de/startagegender/{gender}/{age}")
    public ResponseEntity<ResponseDTO> startAgeGender(@PathVariable Gender gender , @PathVariable int age) throws ListaDeException
    {
        return listDeService.startAgeGender( gender,age);
    }

    @GetMapping(path="de/deleteolder/{age}")
    public ResponseEntity<ResponseDTO> deleteOlder( @PathVariable int age) throws ListaDeException
    {
        return listDeService.deleteOlder(age);
    }

    @GetMapping(path ="de/kidandgirlolder")
    public ResponseEntity<ResponseDTO> kidAndGirlOlder() throws ListaDeException
    {
        return listDeService.kidAndGirlOlder();
    }

    @GetMapping(path="de/orderboysbyage")
    public ResponseEntity<ResponseDTO> orderBoysByAge() throws ListaDeException
    {
        return listDeService.orderBoysByAge();
    }

    @GetMapping(path ="de/deletebyposition/{position}")
    public ResponseEntity<ResponseDTO> deleteBoyByPosition(@PathVariable int position) throws ListaDeException
    {
        return listDeService.deleteByPosition(position);
    }


    @GetMapping(path ="de/passposition/{id}/{position}")
    public ResponseEntity<ResponseDTO> passPosition(@PathVariable String id,@PathVariable int position) throws ListaDeException
    {
        return listDeService.passPosition(id,position);
    }

    @GetMapping(path ="de/loseposition/{id}/{position}")
    public ResponseEntity<ResponseDTO> losePosition(@PathVariable String id,@PathVariable int position) throws ListaDeException
    {
        return listDeService.losePosition(id,position);
    }

    @GetMapping(path= "de/boysbygrade")
    public ResponseEntity<ResponseDTO> boysByGrade()
    {
        return listDeService.getBoysByGrade();
    }

    @GetMapping(path ="de/deletegender/{gender}")
    public ResponseEntity<ResponseDTO> deleteGender(@PathVariable Gender gender) throws ListaDeException
    {
        return listDeService.deleteGender(gender);
    }

    @GetMapping(path= "de/boysbygender")
    public ResponseEntity<ResponseDTO> boysByGender()
    {
        return listDeService.getBoysByGender();
    }

    @GetMapping(path= "de/getorphansbygradebylocation")
    public ResponseEntity<ResponseDTO> getOrphansByGradeByLocation() throws ListaDeException
    {
        return listDeService.getOrphansByGradeByLocation();
    }

  /*  @GetMapping(path= "de/nose/{grade}/{code}")
    public ResponseEntity<ResponseDTO> nose(@PathVariable int grade, @PathVariable String code) throws ListaDeException
    {
        return listDeService.nose(grade,code);
    }

   */


}

