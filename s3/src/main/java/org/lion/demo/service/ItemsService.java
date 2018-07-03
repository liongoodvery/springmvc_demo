package org.lion.demo.service;

import org.lion.demo.mapper.ItemsMapper;
import org.lion.demo.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> getItemList() {
        return itemsMapper.selectByExampleWithBLOBs(null);
    }

    public Items getItem(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    public int update(Items items) {
        return itemsMapper.updateByPrimaryKeySelective(items);
    }
}
