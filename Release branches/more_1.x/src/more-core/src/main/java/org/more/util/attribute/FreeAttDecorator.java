/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.util.attribute;
import org.more.core.error.DefineException;
/**
 * 自由的属性访问器。该接口进一步扩展了ExtAttribute接口，并支持属性替换模式的更换操作。使得在使用属性的过程中可以自由的切换属性替换策略。
 * @version 2009-12-3
 * @author 赵永春 (zyc@byshell.org)
 */
public class FreeAttDecorator<T> extends ExtAttDecorator<T> {
    //==================================================================================Constructor
    /**
     * 构造一个自由的属性装饰器，该装饰器实现了IFreeAttribute接口的功能。
     * 该方法将采用默认策略IExtAttribute.ReplaceMode_Replace。
     * @param source 要装饰的目标属性对象。
     */
    public FreeAttDecorator(IAttribute<T> source) {
        super(source);
    }
    /**
     * 构造一个属性装饰器，该装饰器扩展了ExtAttDecorator装饰器并且提供了更换属性替换策略的支持。
     * @param source 要装饰的目标属性对象。
     * @param replaceMode 要更改的替换策略策略值，该值必须是IExtAttribute.ReplaceMode所定义的。
     *                   如果使用了一个不存在的值进行定义则会引发NoDefinitionException异常。
     * @throws DefineException 定义了一个不存在的属性策略。
     */
    public FreeAttDecorator(IAttribute<T> source, int replaceMode) throws DefineException {
        super(source);
        this.setReplacMode(replaceMode);
    }
    //==========================================================================================Job
    /** 将属性替换策略切换到ReplaceMode_Original模式 */
    public void changeOriginal() {
        this.setReplacMode(ReplaceMode_Original);
    }
    /** 将属性替换策略切换到ReplaceMode_Replace模式 */
    public void changeReplace() {
        this.setReplacMode(ReplaceMode_Replace);
    }
    /** 将属性替换策略切换到ReplaceMode_Throw模式 */
    public void changeThrow() {
        this.setReplacMode(ReplaceMode_Throw);
    }
}