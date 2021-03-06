/*
 * Copyright 2017 Robert Merget <robert.merget@rub.de>.
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
package de.rub.nds.modifiablevariable.string;

import de.rub.nds.modifiablevariable.VariableModification;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 */
@XmlRootElement
@XmlType(propOrder = { "explicitValue", "modificationFilter", "postModification" })
public class StringExplicitValueModification extends VariableModification<String> {

    private String explicitValue;

    public StringExplicitValueModification() {
    }

    public StringExplicitValueModification(String explicitValue) {
        this.explicitValue = explicitValue;
    }

    @Override
    protected String modifyImplementationHook(String input) {
        return explicitValue;
    }

    public String getExplicitValue() {
        return explicitValue;
    }

    public void setExplicitValue(String explicitValue) {
        this.explicitValue = explicitValue;
    }

    @Override
    public VariableModification<String> getModifiedCopy() {
        return new StringExplicitValueModification(explicitValue);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.explicitValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StringExplicitValueModification other = (StringExplicitValueModification) obj;
        if (!Objects.equals(this.explicitValue, other.explicitValue)) {
            return false;
        }
        return true;
    }
}
