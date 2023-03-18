/**
 *    Copyright 2009-2016 the original author or authors.
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
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.mapping.StatementType;

/**
 * @author Clinton Begin
 * 通过 SQL 语句获得主键的注解。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SelectKey {
  /**
   * @return 语句
   */
  String[] statement();

  /**
   * @return Java 对象的属性
   */
  String keyProperty();
  /**
   * @return 数据库的字段
   */
  String keyColumn() default "";

  /**
   * @return 在插入语句执行前，还是执行后
   *
   * 注解方式和XML方式配置的属性基本相同，其中before为false时功能等同于order="AFTER"，before=true时功能等同于order="BEFORE"。
   *
   * 注意：在不同的数据库中，order的配置不同
   *
   * order属性的设置和使用的数据库有关。在MySQL数据库中，order属性设置的值是AFTER，因为当前记录的主键是在insert语句执行成功后才获取到的。
   * 而在Oracel数据库中，order属性的值要设置为BEFORE，这是因为Oracle数据库中需要先从序列获取值，然后将值作为主键插入到数据库中。
   *
   */
  boolean before();
  /**
   * @return 返回类型
   */
  Class<?> resultType();

  /**
   * @return {@link #statement()} 的类型
   */
  StatementType statementType() default StatementType.PREPARED;
}
