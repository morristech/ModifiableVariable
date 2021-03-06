/**
 * ModifiableVariable - A Variable Concept for Runtime Modifications
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.modifiablevariable.integer;

import de.rub.nds.modifiablevariable.VariableModification;
import java.util.Objects;
import java.util.Random;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "summand", "modificationFilter", "postModification" })
public class IntegerAddModification extends VariableModification<Integer> {

    private final static int MAX_ADD_MODIFIER = 256;

    private Integer summand;

    public IntegerAddModification() {

    }

    public IntegerAddModification(Integer bi) {
        this.summand = bi;
    }

    @Override
    protected Integer modifyImplementationHook(Integer input) {
        return (input == null) ? summand : input + summand;
    }

    public Integer getSummand() {
        return summand;
    }

    public void setSummand(Integer summand) {
        this.summand = summand;
    }

    @Override
    public VariableModification<Integer> getModifiedCopy() {
        return new IntegerAddModification(summand + new Random().nextInt(MAX_ADD_MODIFIER));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.summand);
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
        final IntegerAddModification other = (IntegerAddModification) obj;
        if (!Objects.equals(this.summand, other.summand)) {
            return false;
        }
        return true;
    }
}
