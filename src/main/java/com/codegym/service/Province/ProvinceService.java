package com.codegym.service.Province;

import com.codegym.model.Provinces;
import com.codegym.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public Iterable<Provinces> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Page<Provinces> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Provinces save(Provinces provinces) {
        return provinceRepository.save(provinces);
    }

    @Override
    public void deleteById(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Optional<Provinces> findById(Long id) {
        return provinceRepository.findById(id);
    }
}
