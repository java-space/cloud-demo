/*
 * Copyright 2023 , All Rights Reserved
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential
 * @author  Mothusi Molorane
 * @since 1.0
 */

package za.co.ufs.qwaqwa.cloud_demo.mapper;

import java.util.List;

public interface AbstractMapper<E, D> {

    List<D> internalsToDtos(List<E> entities);
}
