package com.weweibuy.brms.repository.cache;

import com.weweibuy.brms.model.po.Model;
import com.weweibuy.brms.model.po.ModelAttr;
import com.weweibuy.brms.repository.ModelAndAttrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/11/25 20:50
 **/
@Component
@Primary
@RequiredArgsConstructor
public class CacheModelAndAttrRepositoryImpl implements ModelAndAttrRepository {

    private final ModelAndAttrRepository delegate;

    @Override
    public Optional<Model> selectModel(String modelKey) {
        return delegate.selectModel(modelKey);
    }

    @Override
    public List<ModelAttr> selectModelAttrByModelKey(String modelKey) {
        return delegate.selectModelAttrByModelKey(modelKey);
    }

    @Override
    public Optional<ModelAttr> selectModelAttr(String modelKey, String attrName) {
        return delegate.selectModelAttr(modelKey, attrName);
    }
}
