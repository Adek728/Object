public class Wyswietlanie<E> {
    Object element;

    Wyswietlanie(E element){
        this.element = element;
    }

    String info(){
        return element.toString();
    }
}
