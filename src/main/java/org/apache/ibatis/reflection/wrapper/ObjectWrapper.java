/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * @author Clinton Begin
 * 对象包装器接口，基于 MetaClass 工具类，定义对指定对象的各种操作。
 * 或者可以说，ObjectWrapper 是 MetaClass 的指定类的具象化。
 */
public interface ObjectWrapper {
  /**
   * 获得值
   *
   * @param prop PropertyTokenizer 对象，相当于键
   * @return 值
   */
  Object get(PropertyTokenizer prop);
  /**
   * 设置值
   *
   * @param prop PropertyTokenizer 对象，相当于键
   * @param value 值
   */
  void set(PropertyTokenizer prop, Object value);

  String findProperty(String name, boolean useCamelCaseMapping);

  String[] getGetterNames();

  String[] getSetterNames();

  Class<?> getSetterType(String name);

  Class<?> getGetterType(String name);

  boolean hasSetter(String name);

  boolean hasGetter(String name);

  MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

  /**
   * 是否为集合
   */
  boolean isCollection();
  /**
   * 添加元素到集合
   */
  void add(Object element);
  /**
   * 添加多个元素到集合
   */
  <E> void addAll(List<E> element);

}
