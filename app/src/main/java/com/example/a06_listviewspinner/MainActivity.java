package com.example.a06_listviewspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.a06_listviewspinner.model.Catalog;
import com.example.a06_listviewspinner.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spCatalog;
    private EditText edid,edname;
    private Button btAdd;
    private ListView listView;
    //cặp đối tượng dùng cho Spinner
    private ArrayList<Catalog> listCatalog=new ArrayList<Catalog>();
    private ArrayAdapter<Catalog> adapterCatalog=null;
    //Cặp đối tượng dùng cho ListView
    private ArrayList<Product> listProduct=new ArrayList<Product>();
    private ArrayAdapter<Product> adapterProduct=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fakeCatalogList();
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductForCatalog();
            }
        });
        spCatalog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view,
                                       int position,
                                       long id) {
                loadListProductByCatalog(listCatalog.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fakeCatalogList() {
         listCatalog.add(new Catalog("1","Samsung"));
         listCatalog.add(new Catalog("2","Iphone"));
         listCatalog.add(new Catalog("3","Nokia"));
         adapterCatalog.notifyDataSetChanged();
    }
    private void addProductForCatalog() {
        Product p=new Product();
        p.setId(edid.getText()+"");
        p.setName(edname.getText()+"");
        Catalog c= (Catalog) spCatalog.getSelectedItem();
        c.addProduct(p);
        //Mỗi lần thêm xong thì cập nhập lại ListView
        loadListProductByCatalog(c);
    }

    private void loadListProductByCatalog(Catalog c) {
        //xóa danh sách cũ
        listProduct.clear();
        //lấy danh sách mới từ Catalog chọn trong Spinner
        listProduct.addAll(c.getList());
        //cập nhật lại ListView
        adapterProduct.notifyDataSetChanged();
    }

    private void initView() {
        spCatalog=findViewById(R.id.spCatalog);
        edid=findViewById(R.id.editId);
        edname=findViewById(R.id.editName);
        btAdd=findViewById(R.id.btnInput);
        listView=findViewById(R.id.listView);
        adapterCatalog=new ArrayAdapter<Catalog>(this,
                android.R.layout.simple_spinner_item,listCatalog);
        adapterCatalog.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCatalog.setAdapter(adapterCatalog);
        adapterProduct=new ArrayAdapter<Product>(this,
                android.R.layout.simple_list_item_1,listProduct);
        listView.setAdapter(adapterProduct);
    }
}
