package com.umanizales.demo.model;


import com.umanizales.demo.controller.CountByGenderDTO;
import com.umanizales.demo.controller.GenderByGradeDTO;
import com.umanizales.demo.controller.GradeByLocationDTO;
import com.umanizales.demo.exception.ListaDeException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDE {
    private Node head;
    private int count;

   public Boy findIdentification(String id) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().getIdentification().equals(id)) {
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void validateListEmpty() throws ListaDeException {
        if (this.head == null) {
            throw new ListaDeException("No hay datos en la lista");
        }
    }

    public List<Boy> list() throws ListaDeException {
        if (this.head != null) {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;

        }
        throw new ListaDeException("No hay datos en la lista");
    }

    public int count()
    {
        int cont = 0;
        if(this.head !=null) {
            ListDE listTemp = new ListDE();
            //Recorrer la lista principal de principio a fin
            Node temp = this.head;
            int count=0;
            while(temp != null)
            {
                cont++;
                temp = temp.getNext();

            }
        }
        return cont;
    }

    public void add(Boy boy) throws ListaDeException {
        Boy boyExist = findIdentification(boy.getIdentification());
        if (boyExist != null) {
            throw new ListaDeException("La identificación ingresada ya existe");
        }
        if (head == null) {
            head = new Node(boy);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            //está en el ultimo
            temp.setNext(new Node(boy));
            temp.getNext().setPrevious(temp);
        }
        count++;
    }

    public void addToStart(Boy boy) throws ListaDeException {
        Boy boyExist = findIdentification(boy.getIdentification());
        if (boyExist != null) {
            throw new ListaDeException("La identificación ingresada ya existe");
        }
        if (this.head == null) {
            this.head = new Node(boy);
        } else {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            this.head = temp;
            head.getNext().setPrevious(head);
        }
        count++;
    }

    public void invert() throws ListaDeException {
        validateListEmpty();
        if (this.head != null) {
            ListDE listTemp = new ListDE();
            //Recorrer la lista principal de principio a fin
            Node temp = this.head;
            while (temp != null) {
                listTemp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }
    }

    public void delete(String id) throws ListaDeException {

        if (this.head != null) {
            if (this.head.getData().getIdentification().equals(id)) {
                this.head = this.head.getNext();

                if (this.head != null) {
                    this.head.setPrevious(null);
                }
                count--;
            } else {
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() != null && temp.getNext().getData().getIdentification().equals(id)) {
                        temp.setNext(temp.getNext().getNext());
                        if (temp.getNext() != null) {
                            temp.getNext().setPrevious(temp);
                        }
                        count--;
                        break;
                    }
                    temp = temp.getNext();
                }
                if (temp == null) {
                    throw new ListaDeException("La identificación " + id + " no existe en la lista");
                }
            }
        } else {
            throw new ListaDeException("No hay datos en la lista");
        }
    }

    public void deleteKamikaze(String id) throws  ListaDeException
    {
        if (this.head != null) {
            if (this.head.getData().getIdentification().equals(id)) {
                this.head = this.head.getNext();
                if (this.head != null) {
                    this.head.setPrevious(null);
                }
                count--;
            } else {
                Node temp = this.head;
                while (temp != null) {
                    if (temp!= null && temp.getData().getIdentification().equals(id)) {
                        temp.getPrevious().setNext(temp.getNext());
                        if (temp.getNext() != null) {
                            temp.getNext().setPrevious(temp.getPrevious());
                        }
                        count--;
                        break;
                    }
                    temp = temp.getNext();
                }
                if (temp == null) {
                    throw new ListaDeException("La identificación " + id + " no existe en la lista");
                }
            }
        } else {
            throw new ListaDeException("No hay datos en la lista");
        }
    }


    public void changeXtremes() throws ListaDeException {
        if (this.head != null && this.head.getNext() != null) {
            //Sacar el niño de la cabeza
            Boy start = this.head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            //temp está ubicado en el ultimo niño

            this.head.setData(temp.getData());
            temp.setData((start));

        } else {
            throw new ListaDeException("No es posible ejecutar el cambio de extremos");
        }
    }

    //Un metodo que reciba como parametro el genero del niño y me liste los niños de dicho genero
    public ListDE getListDeBoysBygender(Gender gender) throws ListaDeException {
        validateListEmpty();
        Node temp = this.head;
        ListDE listTemp = new ListDE();
        while (temp != null) {
            if (temp.getData().getGender().equals(gender)) {
                listTemp.add(temp.getData());
            }
            temp = temp.getNext();

        }
        return listTemp;

    }

    //Método que me permita insertar un niño en una posición dada

    public void  addByPosition(Boy boy, int position) throws ListaDeException
        { Boy boyExist = findIdentification(boy.getIdentification());
            if (boyExist != null) {
                throw new ListaDeException("La identificación ingresada ya existe");
            }
            if (position > count)
            {
                this.add(boy);
                return;
            }
            if (position == 1)
            {
                addToStart(boy);
            }
            else
            {
                int cont = 1;
                Node temp = this.head;
                while ( temp!= null)
                {
                    if (cont == position -1)
                    {
                        break;
                    }
                    temp = temp.getNext();
                    cont++;
                }
                Node nodeNew = new Node(boy);
                nodeNew.setNext(temp.getNext());
                temp.setNext(nodeNew);
                nodeNew.getNext().setPrevious(nodeNew);
                nodeNew.setPrevious(temp);
                count++;
            }
        }

    public void variantBoys() throws ListaDeException
    {
        validateListEmpty();
        ListDE kids = this.getListDeBoysBygender(Gender.MASCULINO);
        ListDE girls = this.getListDeBoysBygender(Gender.FEMENINO);
        ListDE minList = null;
        ListDE maxList = null;
        if (kids.getCount()>girls.getCount())
        {
            minList = girls;
            maxList = kids;
        }
        else
        {
            minList = kids;
            maxList =  girls;
        }

        Node temp = minList.getHead();
        int pos =2;
        while(temp != null)
        {
            maxList.addByPosition(temp.getData(), pos);
            pos = pos +2;
            temp = temp.getNext();

        }
        this.head =  maxList.getHead();
    }

   public void changePos(int pos1, int pos2) throws ListaDeException
    {
        validateListEmpty();
        if ((this.head != null && this.head.getNext() != null) && (pos1 <= count && pos2 <= count)) {
            Node temp = head;
            int cont = 1;


            while (temp != null) {
                if (cont == pos1) {
                    break;
                }
                temp = temp.getNext();
                cont++;
            }
            Boy boy1 = temp.getData();
            delete(temp.getData().getIdentification());
            temp = this.head;
            cont = 1;
            while (temp != null) {
                if (cont == pos2-1) {
                    break;
                }
                temp = temp.getNext();
                cont++;
            }
            Boy boy2 = temp.getData();
            delete(temp.getData().getIdentification());

            addByPosition(boy2, pos1);
            addByPosition(boy1, pos2);

        }
        else {
            throw new ListaDeException("No se puede realizar el cambio");
        }
    }


    //metodo que recibe el codigo de una ciudad y retorna la cantidad de niños
    public int getCountBoysByLocation(String code)
    {
        Node temp = this.head;
        int count = 0;
        while (temp!= null)
        {
            if (temp.getData().getLocation().getCode().equals(code))
            {
                count++;
            }
            temp= temp.getNext();
        }
        return count;
    }

    //Método que dada una edad y un municipio me permita obtener el listado de los niños pertenecientes a ese municipio y de edad menor o igual a la dada
    public void listAgeLocation (int age, String description) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;
        while (temp!=null)
        {
            if (temp.getData().getAge() > age || !temp.getData().getLocation().getDescription().equals(description))
            {
                delete(temp.getData().getIdentification());
            }
            temp = temp.getNext();
        }
    }

    //Método que dado un género y una edad, me deje al inicio de la lista los niños del género dado y con la edad menor o igual a la entregada

    public void startAgeGender (Gender genero, int age) throws ListaDeException
     {
        validateListEmpty();
        Node temp = this.head;
        while (temp!=null)
        {
            if (temp.getData().getGender().equals(genero) && temp.getData().getAge() <= age)
            {
                Boy boy = temp.getData();
                delete(temp.getData().getIdentification());
                addToStart(boy);
            }
            temp= temp.getNext();
        }
    }

    //Método que me permita eliminar los niños con una edad mayor a la suministrada
    public void deleteOlder (int age) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;
        while (temp!=null)
        {
            if (temp.getData().getAge() > age)
            {
                delete(temp.getData().getIdentification());
            }
            temp= temp.getNext();
        }
    }

    //Método que me retorne los datos del niño y la niña mayores
    public List kidAndGirlOlder() throws ListaDeException
    {
        validateListEmpty();
        ListDE kids  = this.getListDeBoysBygender(Gender.MASCULINO);
        ListDE girls = this.getListDeBoysBygender(Gender.FEMENINO);

        Boy kidmax = kids.head.getData();
        Boy girlmax = girls.head.getData();
        Node temp = kids.getHead();
        Node temp1 = girls.getHead();

        List<Boy> listOlder= new ArrayList<Boy>();

        while (temp.getNext()!=null)
        {
            if (temp.getNext().getData().getAge() > kidmax.getAge())
            {
                kidmax = temp.getNext().getData();
                listOlder.clear();
            }
            else
            {
                if (temp.getNext().getData().getAge() == kidmax.getAge())
                {
                    listOlder.add(temp.getNext().getData());
                }
            }
            temp = temp.getNext();
        }

        while (temp1.getNext()!=null)
        {
            if(temp1.getNext().getData().getAge() > girlmax.getAge())
            {
                girlmax = temp1.getNext().getData();
            }
            temp1 = temp1.getNext();
        }
        temp1 = girls.getHead();
        while (temp1.getNext()!=null)
        {
            if (temp1.getNext().getData().getAge() == girlmax.getAge() && !temp1.getNext().getData().getIdentification().equals(girlmax.getIdentification()))
            {
                listOlder.add(temp1.getNext().getData());
            }
            temp1= temp1.getNext();
        }

        listOlder.add(kidmax);
        listOlder.add(girlmax);

        return listOlder;
    }

    //Método que me ordene los niños por edad
    public void orderBoysByAge () throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;

        while (temp.getNext()!= null)
        {
            if (temp.getData().getAge() > temp.getNext().getData().getAge())
            {
                Boy boy = temp.getData();
                delete(temp.getData().getIdentification());
                add(boy);
                temp =this.head;
            }
            else
            {
                temp = temp.getNext();
            }
        }

    }


    public void  deleteByPosition(int position) throws ListaDeException
    {
        validateListEmpty();
        /// Validación de la posición
        if (position > count)
        {
            throw new ListaDeException("No hay niños en la posición ingresada");
        }
        if (position == 1)
        {
           delete(head.getData().getIdentification());
        }
        else
        {
            int cont = 1;
            Node temp = this.head;
            while ( temp!= null)
            {
                if (cont == position -1)
                {
                    break;
                }
                temp = temp.getNext();
                cont++;
            }
            delete(temp.getNext().getData().getIdentification());
        }
    }

    public void passPosition(String id, int position) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;
        int cont = 1;
        while (temp!= null)
        {
            if (temp.getData().getIdentification().equals(id))
            {
                if (position >= cont)
                {
                    Boy boy = temp.getData();
                    delete(temp.getData().getIdentification());
                    addToStart(boy);
                }
                else
                {
                    Boy boy = temp.getData();
                    delete(temp.getData().getIdentification());
                    addByPosition(boy,cont - position);
                }
            }
            temp = temp.getNext();
            cont++;
        }
    }

    public void losePosition(String id, int position) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;
        int cont = 1;
        while (temp!= null)
        {
            if (temp.getData().getIdentification().equals(id))
            {
                if (position > count )
                {
                    Boy boy = temp.getData();
                    delete(temp.getData().getIdentification());
                    add(boy);
                }
                else
                {
                    Boy boy = temp.getData();
                    delete(temp.getData().getIdentification());
                    addByPosition(boy,cont+position);
                }
                break;
            }
            temp = temp.getNext();
            cont++;
        }
    }

    //Metodo que me permita obtener los niños de un grado de escuela dado (1,2,3,4,5)
    public int getCountBoysByGrade(int grade)
    {
        Node temp = this.head;
        int count = 0;
        while (temp!= null)
        {
            if (temp.getData().getGrade() == grade)
            {
                count++;
            }
            temp= temp.getNext();
        }
        return count;
    }

    public void deleteGender(Gender gender) throws ListaDeException
    {
        validateListEmpty();
        Node temp = this.head;
        while (temp!=null)
        {
            if(temp.getData().getGender().equals(gender))
            {
                delete(temp.getData().getIdentification());
            }
            temp = temp.getNext();
        }
    }

    //Método que me retorne un listado con el conteo de niños por Genero
    public int getCountBoysByGender(Gender gender)
    {
        Node temp = this.head;
        int count = 0;
        while (temp!= null)
        {
            if (temp.getData().getGender().equals(gender))
            {
                count++;
            }
            temp= temp.getNext();
        }
        return count;
    }
    public int getCountBoysOrphanByGender(Gender gender)
    {
        Node temp = this.head;
        int count = 0;
        while (temp!= null)
        {
            if (temp.getData().getGender().equals(gender) && temp.getData().isOrphan())
            {
                count++;
            }
            temp= temp.getNext();
        }
        return count;
    }



  public GenderByGradeDTO gendersByGradeByLocation (int grade, Location location) throws ListaDeException
  {
        validateListEmpty();
        Node temp = this.head;
        int count = 0;
        int countF = 0;
        int countM = 0;
        while (temp!= null)
        {
            if(temp.getData().getLocation().equals(location) && temp.getData().getGrade() == grade)
            {
                count++;
                if (temp.getData().isOrphan())
                {
                    if (temp.getData().getGender().equals(Gender.MASCULINO))
                    {
                        countM++;
                    }
                    else
                    {
                        countF++;
                    }
                }
            }
            temp = temp.getNext();
        }
      List<CountByGenderDTO> countByGender = new ArrayList<>();
      countByGender.add(new CountByGenderDTO(Gender.MASCULINO,countM));
      countByGender.add(new CountByGenderDTO(Gender.FEMENINO,countF));
      GenderByGradeDTO genderByGradeDTO = new GenderByGradeDTO(grade,countByGender,count);
      return genderByGradeDTO;
  }

  public GradeByLocationDTO getGradesByLocation(Location location) throws ListaDeException
  {
      List<GenderByGradeDTO> genderByGradeDTOS = new ArrayList<>();
      for (byte i=1; i<=5;i++)
      {
          genderByGradeDTOS.add(gendersByGradeByLocation(i,location));
      }
      GradeByLocationDTO gradeByLocationDTO = new GradeByLocationDTO(location, genderByGradeDTOS);
      return gradeByLocationDTO;
  }
}


