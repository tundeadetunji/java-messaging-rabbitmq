package custom;

import java.util.ArrayList;
import java.util.List;

class CustomList <T> {

    public CustomList() {
    }

    public List<Object> push(List<Object> list, Object data){
        list.clear();
        list.add(data);
        return list;
    }

    public void pop(List<T> list){
        List<T> temp = new ArrayList<>();
        for (int i = 1; i < list.size(); i++){
            temp.add(list.get(i));
        }
        list = temp;
    }



}
