"use client";

import { createContext, ReactNode } from "react";
import { AppConfig, IAppConfig } from ".";

export const AppConfigContext = createContext<IAppConfig>(AppConfig);

export const AppConfigProvider = ({ children }: { children: ReactNode }) => (
    <AppConfigContext.Provider value={AppConfig}>
        {children}
    </AppConfigContext.Provider>
) 