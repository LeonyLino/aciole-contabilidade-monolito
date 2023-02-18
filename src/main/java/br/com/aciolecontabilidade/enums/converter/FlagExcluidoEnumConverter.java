package br.com.aciolecontabilidade.enums.converter;

import javax.persistence.AttributeConverter;

import br.com.aciolecontabilidade.enums.FlagExcluidoEnum;

public class FlagExcluidoEnumConverter implements AttributeConverter<FlagExcluidoEnum, Character> {

	@Override
	public Character convertToDatabaseColumn(FlagExcluidoEnum flagExcluidoEnum) {
		return flagExcluidoEnum != null ? flagExcluidoEnum.getChave() : null;
	}

	@Override
	public FlagExcluidoEnum convertToEntityAttribute(Character charFlagExcluido) {
		for (FlagExcluidoEnum fee : FlagExcluidoEnum.values()) {
			if (fee.getChave().equals(charFlagExcluido)) {
				return fee;
			}
		}
		return null;

	}

}
